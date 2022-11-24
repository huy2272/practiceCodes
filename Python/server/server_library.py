import socket
import json
from http.client import responses
from threading import Thread
from dataHandler import dataHandler

class ServerLib:
    def __init__(self):
        self.dataHandler = dataHandler()

    def startServer(self, PORT = 65432, DIRECTORY = "data.txt"):
        with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as server:
            server.bind(('localhost',PORT))
            server.listen()
            
            while True:
                conn, addr = server.accept()
                thread = Thread(target = self.clientHandler, args = (conn, addr))
                thread.start()

    def requestHandler(self, reqHeader, reqBod):
        HEADERS = reqHeader.split('\r\n')
        HTTP_INFORMATION = HEADERS[0].split(' ')

        METHOD = HTTP_INFORMATION[0].strip()
        PATH = HTTP_INFORMATION[1].strip()
        custName = PATH.replace('%20', ' ')
        custName = custName.replace('/', ' ')

        if METHOD not in ['GET', 'POST', 'DELETE', 'PATCH']:
            return {
                'data':  METHOD + ' is not supported!' 
            }
        
        if METHOD == 'GET':
            if PATH == '/':
                return self.dataHandler.print()
            else:
                return self.dataHandler.findCustomer(custName)
        elif METHOD == 'POST':
            return self.dataHandler.addCustomer(custName, reqBod)
        elif METHOD == 'DELETE':
            return self.dataHandler.deleteCustomer(custName)
        elif METHOD == 'PATCH':
            return self.dataHandler.updateCustomer(custName, reqBod)

    def clientHandler(self, conn, addr):
        reqHeader, reqBod = self.listener(conn)
        if reqBod: reqBod = json.loads(reqBod)
        filehandlerResponse = self.requestHandler(reqHeader, reqBod)
        resp = self.respHandler(filehandlerResponse)

        conn.sendall(resp)
        conn.close()
        
    def listener(self, socket):
        BUFFER_SIZE = 1024
        response = b''

        while True:
            packet = socket.recv(BUFFER_SIZE)
            response += packet
            # Last packet might not fill up the buffer
            if len(packet) < BUFFER_SIZE: break
        
        response = response.decode('utf-8')
        if response.count('\r\n\r\n') < 1:
            return response, ""
        else:
            respHeader, respBod = response.split('\r\n\r\n', 1)
            return respHeader, respBod

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