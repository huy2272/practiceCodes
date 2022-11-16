import socket

#If local host doesn't work use 127.0.0.1
HOST = "127.0.0.1" 
PORT = 65432

#AF_INET is the Internet family for IPv4
#SOCK_STREAM is the sokcet type for TCP, protocol that is used to transport messages
with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
    s.bind((HOST,PORT))
    s.listen()
    conn, addr = s.accept()
    with conn:
        print(f"Connected by {addr}")
        while True:
            data = conn.recv(1024)
            if not data:
                break
            conn.sendall(data)
