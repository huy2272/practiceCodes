from serverLib import ServerLib

def main():
    print("\nServer's information\n")

    http = ServerLib()
    port = 65432
    directory = 'data.txt'

    print("Starting server on port: ", port)
    http.startServer(port, directory)

if __name__ == "__main__":
    main()