import socket
from http.client import responses
from dataHandler import FileHandler
from threading import Thread
import json


class ServerLib:
    def __init__(self): 
        # TODO: change verbose to false
        self.fileHandler = FileHandler()

    def startServer(self, PORT=9999, DIRECTORY = "data.txt"):
        with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as server_socket:

            server_socket.bind(('localhost', PORT))
            server_socket.listen()

            while True:    
                conn, addr = server_socket.accept()
                thread = Thread(target = self.clientHandler, args = (conn, addr))
                thread.start()

    def requestHandler(self, reqHead, reqBod):

        HEADERS = reqHead.split('\r\n')
        METHOD_INFO = HEADERS[0].split(' ')

        METHOD = METHOD_INFO[0].strip()
        PATH = METHOD_INFO[1].strip()
        name = PATH.replace('%20', ' ')
        name = name.replace('/', '')

        if METHOD not in ['GET', 'POST', 'PATCH', 'DELETE']:
            return {
                'data': 'HTTP Method not supported: ' + METHOD
            }
        # Print all customers
        if METHOD == 'GET':
            if PATH == '/':
                return self.fileHandler.printDB()
            else:
                
                return self.fileHandler.find(name)
        # Add a customer
        elif METHOD == 'POST':
            return self.fileHandler.add(name, reqBod)
        # Delete a customer
        elif METHOD == 'DELETE':
            return self.fileHandler.delete(name)
        # Update a customer
        elif METHOD == 'PATCH':
            return self.fileHandler.update(name, reqBod)

    def clientHandler(self, conn, addr):

        reqHead, reqBod = self.listener(conn)

        if reqBod: reqBod = json.loads(reqBod)
        filehandlerResponse = self.requestHandler(reqHead, reqBod)
        response = self.respHandler(filehandlerResponse)
        
        conn.sendall(response)
        conn.close()

    def listener(self, socket):
        BUFFER_SIZE = 1024
        response = b''

        while True:
            packet = socket.recv(BUFFER_SIZE)
            response += packet
            # Last packet
            if len(packet) < BUFFER_SIZE: break  
        
        response = response.decode('utf-8')

        '''If responseBody does not exists'''
        if response.count('\r\n\r\n') < 1:
            return response, ""
        
        else:
            respHead, respBod = response.split('\r\n\r\n', 1)
            return respHead, respBod

    def respHandler(self, RESPONSE):
        HEADERS = RESPONSE.get('headers', [])
        BODY = RESPONSE.get('data', "")

        request = ''
        request += 'HTTP/1.0 '
        
        for HEADER in HEADERS:
            request += '\r\n' + HEADER

        request += '\r\n\r\n'
        request += BODY
        request += '\r\n'

        return request.encode()