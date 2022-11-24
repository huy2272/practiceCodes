import mimetypes
from pathlib import Path
from Modules.FileLock import FileLock

class FileHandler:

    def __init__(self):
        # when in debug mode, use 'server/data.txt' instead
        self.defaultDirectory = 'data.txt'
        '''
        {Name : [Age, Address, Number]}
        '''
        self.database = {}
        self.count = 0
        self.readDB()

    def readDB(self):
        file_path = self.defaultDirectory
        if not Path(file_path).exists() or not Path(file_path).is_file():
            raise Exception('Cannot read from database. Incorrect path or "data.txt" does not exist.')
        
        self.count = 0
        with open(file_path) as f:
            while True:
                line = f.readline()
                if not line:
                    break
                
                self.count += 1
                customer = line.split('|')
                name, age, address, number = customer
                if all(i == '' or i.isspace() for i in name): continue
                if number == '\n': number = ''
                self.database[name.strip()] = [age.strip(), address.strip(), number.strip()]
        

    def printDB(self):
        file_path = self.defaultDirectory
        try:
            self.save_database()
            if not Path(file_path).exists() or not Path(file_path).is_file():
                return {
                    'data': 'Database does not exist.'
                }
                
            with open(file_path) as f: 
                file_data = f.read()

            
            CONTENT_TYPE = 'Content-Type: ' + mimetypes.guess_type(file_path)[0] 
            CONTENT_DISPOSITION = 'Content-Disposition: attachment; filename="' + self.defaultDirectory + '"'

            return {
                'data': file_data,
                'headers': [CONTENT_TYPE, CONTENT_DISPOSITION]
            }
        except Exception as e:
            return {
                'data': f'Error getting file content: {e}'
            }

    def find(self, name):
        if name not in self.database:
            return {
                'data': f'Customer not found: {name}'
            }
        
        data = '|'.join([name] + self.database[name])
        
        return {
            'statusCode': 201,
            'data': data
        }

    def add(self, name, customer):
        customer_name, age, address, number = customer.values()
        if name in self.database:
            return {
                'data': f'Customer already exists: {name}'
            }
        
        self.count += 1
        self.database[name] = [str(age),address,number]
        
        self.save_database()
        return {
                'data': f'Customer added: {name}'
            }
    
    def delete(self, name):
        if name not in self.database:
            return {
                'data': f'Customer does not exists: {name}'
            }
        
        self.count -= 1

        del self.database[name]
        self.save_database()
        return {
            'data': f'Customer deleted: {name}'
        }
    
    def update(self, name, customer):
        if name not in self.database:
            return {
                'data': f'Customer does not exists: {name}'
            }
        
        

        curr_customer = self.database[name]
        if 'name' in customer:
            del self.database[name]
            name = customer['name']
        if 'age' in customer: curr_customer[0] = customer['age']
        if 'address' in customer: curr_customer[1] = customer['address']
        if 'number' in customer: curr_customer[2] = customer['number']
        self.database[name] = curr_customer

        self.save_database()
        return {
                'data': f'Customer updated: {name}'
            }

    def save_database(self):
        filename = self.defaultDirectory

        filecontent = []
        for name,value in self.database.items():
            if name: filecontent.append([name] + value)
        filecontent.sort()
        filecontent = '\n'.join('|'.join(customer) for customer in filecontent)
        

        # Locking the file to perform the write operation
        with FileLock(filename):
            try:
                f = open(filename, "w")
                f.write(filecontent)
                f.close()
                return {
                    'data': 'Successfully wrote file content.',
                }
            except Exception as e:
                return {
                    'data': f'Error getting file content: {e}'
                }