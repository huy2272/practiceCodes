import socket
from urllib.parse import urlparse
import json

class HTTPLibrary:
    def sendHTTPRequest(self, HOST, HTTP_METHOD, PATH = "/", HEADERS = [], DATA = None, OUTPUT_FILE = None):
            if PATH == "":
                PATH = "/"
            
            '''Contains PORT number'''
            if HOST.count(":") == 1:
                HOST, PORT = HOST.split(":")
                PORT = int(PORT)
            else:
                PORT = 80

            with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
                
                s.connect((HOST, PORT))

                request = self.__prepareRequest(HOST, HTTP_METHOD, PATH, HEADERS, DATA)    
                s.sendall(request)
                responseHeader, responseBody = self.__receiveResponse(s)

                # Print server response
                print("Response: ")
                print(responseBody)

    def __prepareRequest(self, HOST, HTTP_METHOD, PATH, HEADERS, BODY_DATA):
        request = ''
        
        request += HTTP_METHOD + " " + PATH + " HTTP/1.1\r\n"
        request += "Host: " + HOST + "\r\n"

        for HEADER in HEADERS:
            request += HEADER + "\r\n"

        if BODY_DATA is not None:
            BODY_DATA = json.dumps(BODY_DATA)
            request += "Content-Length: " + str(len(BODY_DATA)) + "\r\n"
            request += "\r\n"
            request += BODY_DATA + "\r\n"

        request += "\r\n"
        return request.encode()

    def __receiveResponse(self, socket):
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