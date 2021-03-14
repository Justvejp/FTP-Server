package com.company;

import java.net.*;
import java.io.*;
import java.util.EmptyStackException;
import java.util.Stack;

public class EchoServer {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        int portNumber = 8080;

        try {
            ServerSocket serverSocket = new ServerSocket(portNumber); //TODO Skapa en server socket som lyssnar på en angiven port på server
            Socket clientSocket = serverSocket.accept(); //TODO acceptera anslutningar från en klient

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); //TODO läsa data från klienten
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            while (true) {

                out.println("Login to proceed.");

                out.printf("Username: ");
                String inputFile = in.readLine();
                out.printf("Password: ");
                String inputFileSec = in.readLine();

                if (inputFile.equalsIgnoreCase("admin") && inputFileSec.equalsIgnoreCase("test")) {

                    out.println("ACCEPTED");
                    while (true) {

                        out.printf("Type here: ");
                        String message = in.readLine();
                        out.println("admin: " + message);

                        if (message.equals("cancel")) {
                            out.println("Bye");
                            break;
                        }
                    }




                } else {
                    out.println("Try again..");
                }
            }

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
