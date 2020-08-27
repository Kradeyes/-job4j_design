package ru.job4j.io;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        boolean isWork = true;

        try (ServerSocket server = new ServerSocket(9000)) {
            while (isWork) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str = in.readLine();
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    while (!(str.isEmpty())) {
                        System.out.println(str);
                        if (str.contains("Exit")) {
                            out.write("Server closed\r\n".getBytes());
                            isWork = false;
                            break;
                        }
                        if (str.contains("Hello")) {
                            out.write("Hello, dear friend\r\n".getBytes());
                        } else {
                            if (str.contains("msg")) {
                                String[] splitMsg = str.split(" ");
                                String message = splitMsg[1].split("=")[1] + System.lineSeparator();
                                out.write(message.getBytes());
                            }
                        }
                        str = in.readLine();
                    }
                }
            }
        }
    }
}