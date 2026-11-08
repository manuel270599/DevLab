from http.server import SimpleHTTPRequestHandler, HTTPServer

HOST = "localhost"
PORT = 8000

class MyHandler(SimpleHTTPRequestHandler):
    def do_GET(self):
        self.send_response(200)
        self.send_header("Content-type", "text/html")
        self.end_headers()
        self.wfile.write(b"<html><body><h1>Servidor Web en Python</h1></body></html>")

if __name__ == "__main__":
    server = HTTPServer((HOST, PORT), MyHandler)
    print(f"Servidor iniciado en http://{HOST}:{PORT}")
    server.serve_forever()
