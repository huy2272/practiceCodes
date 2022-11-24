import os
import shutil
import mimetypes
from pathlib import Path
from Modules.FileLock import FileLock

class dataHandler:
    def __init__(self):
        self.default = 'data.txt'
        self.database = {}
        self.count = 0
        self.read()
       
    def read(self):
        path = self.default
        if not Path(path).is_file():
            raise Exception('The file "data.txt" does not exist!')
        
        self.count = 0

        with open(path) as file:
            while True:
                line = file.readline()
                if not line:
                    break

                self.count += 1
                customer = line.split('|')
                name, age, address, number = customer
                #Skip record if the name is missing
                if all(i == '' or i.isspace() for i in name):
                    continue
                #If there's no number
                if number == '\n':
                    number = ''
                self.database[name.strip()] = [age.strip(), address.strip(), number.strip()]
    
    def print(self):
        path = self.default
        try:
            self.save()
            if not Path(path).is_file():
                return{
                    'data': 'Cannot find database'
                }
            with open(path) as file:
                data = file.read()
            
        except Exception as e:
            return {'data': f'Error getting content: {e}'}
    
    def save(self):
        path = self.default

        content = []
        for name, value in self.database.items():
            if name: content.append([name] + value)
        content.sort()
        content = '\n'.join('|'.join(customer) for customer in content)

        with FileLock(path):
            try:
                f = open(path, 'w')
                f.write(content)
                f.close()
                return {'data' : 'Writing successful'}

            except Exception as e:
                return {'data': f'Error while writing to file: {e}'}

    def findCustomer(self, name):
        if name not in self.database:
            return {
                'data': f'Customer not found: {name}'
            }
        
        data = '|'.join([name] + self.database[name])
        return {
            'data': data
        }

    def addCustomer(self, name, customer):
        customer_name, age, address, number = customer.values()
        if name in self.database:
            return {
                'data': f'Customer already exists: {name}'
            }
        
        self.count += 1
        self.database[name] = [str(age),address,number]
        self.save()
        return {
                'data': f'Customer added: {name}'
            }
    
    def deleteCustomer(self, name):
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
    
    def updateCustomer(self, name, customer):
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

        self.save()
        return {
                'data': f'Customer updated: {name}'
            }