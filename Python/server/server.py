from server_library import ServerLib

def main():
    print("\n=====[Server]=====\n")

    http = ServerLib()
    port = 65432
    directory = 'data.txt'

    print("Starting server on port: ", port)
    http.startServer(port, directory)

if __name__ == "__main__":
    main()