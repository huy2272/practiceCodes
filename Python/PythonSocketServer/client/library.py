import socket
from urllib.parse import urlparse
import json

class Library:
    def HTTPRequest(self, HOST, HTTP_METHOD, PATH = "/", HEADERS = [], DATA = None, OUTPUT_FILE = None):
            if PATH == "":
                PATH = "/"
            
            if HOST.count(":") == 1:
                HOST, PORT = HOST.split(":")
                PORT = int(PORT)
            else:
                PORT = 65432

            with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
                s.connect((HOST, PORT))
                request = self.RequestFormat(HOST, HTTP_METHOD, PATH, HEADERS, DATA)    
                s.sendall(request)
                responseHeader, responseBody = self.ResponseFormat(s)

                # Print server response
                print("Server response: ")
                print(responseBody)

    def RequestFormat(self, HOST, HTTP_METHOD, PATH, HEADERS, DATA):
        request = ''
        
        request += HTTP_METHOD + " " + PATH + " HTTP/1.1\r\n"
        request += "Host: " + HOST + "\r\n"

        for HEADER in HEADERS:
            request += HEADER + "\r\n"

        if DATA is not None:
            DATA = json.dumps(DATA)
            request += "Length of data: " + str(len(DATA)) + "\r\n"
            request += "\r\n"
            request += DATA + "\r\n"

        request += "\r\n"
        return request.encode()

    def ResponseFormat(self, socket):
        BUFFER_SIZE = 1024
        response = b''


        while True:
            packet = socket.recv(BUFFER_SIZE)
            response += packet
            if len(packet) < BUFFER_SIZE: break   # Last packet
        
        response = response.decode('utf-8')

        '''
        Return empty string if respBod does not exist
        '''
        if response.count('\r\n\r\n') < 1:
            return response, ""
        
        else:
            responseHeader, responseBody = response.split('\r\n\r\n', 1)
            return responseHeader, responseBody