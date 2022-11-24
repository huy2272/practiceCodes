from urllib.parse import urlparse
from library import HTTPLibrary
from enum import Enum

# Enum for HTTP methods
class HTTPMethod(Enum):
    GET = 'GET'
    POST = 'POST'
    PATCH = 'PATCH'
    DELETE = 'DELETE'

class CustomerApp:

    def __init__(self):
        self.http = HTTPLibrary()
        self.default_url = 'http://localhost:65432'
        self.hostname = ''
        self.full_path = ''
    
    def start(self):
        while self.show_menu(): continue

    def show_menu(self):
        print("Python DB Menu:\n")
        print("  1. Find customer")
        print("  2. Add customer")
        print("  3. Delete customer")
        print("  4. Update customer age")
        print("  5. Update customer address")
        print("  6. Update customer phone")
        print("  7. Print report")
        print("  8. Exit")
        print()

        val = input("Enter a menu number: ")
        while not val.isnumeric() or (val.isnumeric() and (int(val) < 1 or int(val) > 8)):
            print(" Please make sure to enter a value from 1 - 8\n")
            val = input("Enter a menu number: ")
        
        return self.process_action(int(val))
    
    def clean(self, name):
        return name.strip().replace(' ', '%20')
    def reset(self):
        self.hostname = ''
        self.full_path = ''
    
    def process_action(self, val):
        name = ''
        if val == 1:
            name = self.name()
            print()
            url = self.default_url + '/' + name
            self.URLValidator(url)
            self.http.sendHTTPRequest(self.hostname,HTTPMethod.GET.name,self.full_path)
            self.reset()
        elif val == 2:
            # Name
            name = self.name()
            # Age (optional)
            age = self.age()
            # Address (optional)
            address = input("Please enter customer's address: ")
            # Number (optional)
            number = self.phoneNumber()
            print()

            data = {
                'name': name,
                'age': age,
                'address': address.strip(),
                'number': number
            }
            url = self.default_url + '/' + name
            self.URLValidator(url)
            self.http.sendHTTPRequest(self.hostname, HTTPMethod.POST.name, self.full_path, DATA=data)
            self.reset()
        elif val == 3:
            # Delete customer
            name = self.name()
            url = self.default_url + '/' + name
            self.URLValidator(url)
            self.http.sendHTTPRequest(self.hostname, HTTPMethod.DELETE.name, self.full_path)    
            self.reset()
        elif val == 4:
            # Update customer age
            name = self.name()
            age = self.age()
            data = { 'age': age }
            url = self.default_url + '/' + name
            self.URLValidator(url)
            self.http.sendHTTPRequest(self.hostname, HTTPMethod.PATCH.name, self.full_path, DATA = data)
            self.reset()
        elif val == 5:
            # Update customer address
            name = self.name()
            address = input("Enter customer address: ")
            data = { 'address': address.strip() }
            url = self.default_url + '/' + name
            self.URLValidator(url)
            self.http.sendHTTPRequest(self.hostname, HTTPMethod.PATCH.name, self.full_path, DATA = data)
            self.reset()
            self.reset()
        elif val == 6:
            # Update customer phone
            name = self.name()
            number = self.phoneNumber()
            data = { 'number': number }
            url = self.default_url + '/' + name
            self.URLValidator(url)
            self.http.sendHTTPRequest(self.hostname, HTTPMethod.PATCH.name, self.full_path, DATA = data)
            self.reset()
            self.reset()
            self.reset()
        elif val == 7:
            url = self.default_url + '/'
            self.URLValidator(url)
            self.http.sendHTTPRequest(self.hostname, HTTPMethod.GET.name, self.full_path)
            self.reset()
        elif val == 8:
            return False
        
        return True
    
    def name(self):
        while True:
            name = input("Enter customer name: ")
            if self.nameValidator(name): break
            print('Please input correct customer name. It should only consist of letters and/or spaces.')

        if not name: raise Exception('Invalid name')
        return self.clean(name)
    
    def age(self):
        age = ''
        while True:
            age = input("Enter customer age: ")
            if age.isnumeric() or age == '': break
            print('Please input correct customer age.')

        return age.strip()
    
    def phoneNumber(self):
        # Number (optional)
        number = ''
        while True:
            number = input("Please enter the customer's number: ")
            if self.numberValidator(number): break
            print('Please input correct customer number.')

        return number.strip()
    
    def numberValidator(self, nb):
        if nb == '' or all(i.isnumeric() or i.isspace() or i == '-' for i in nb):
            return True
        return False
    
    def nameValidator(self, name):
        if name and all(i.isalpha() or i.isspace() for i in name):
            if all(i.isspace() for i in name): return False
            return True
        return False

    # Validates URL in simple manner (checks if has http:// or https:// + a hostname)
    def URLValidator(self, url):
        result = urlparse(url)
        if all([result.scheme, result.netloc, result.hostname]):
            # Set the hostname and full url path
            self.hostname = result.netloc
            self.full_path = result.path
            if result.params: self.full_path += f';{result.params}'
            if result.query: self.full_path += f'?{result.query}'
            return url
        else:
            raise Exception('Please enter a valid URL.')
    
'''
The program's starting point.
'''
def main():
    print("\nAssignment2\n")

    app = CustomerApp()
    app.start()

    print("\nGood bye!")
    print("Client application terminated\n")

if __name__ == "__main__":
    main()