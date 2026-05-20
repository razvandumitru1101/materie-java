package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class LissteningClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",5001);
        BufferedReader serverIn = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
        );
while(true) {
    System.out.println("Listening client conectat. Asteapta mesaje");

    String serverMessage;

    while ((serverMessage = serverIn.readLine()) != null) {
        System.out.println("Mesaj primit: " + serverMessage);
    }
}
//        socket.close();
    }
}
