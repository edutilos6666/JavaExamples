package com.edutilos.tcpsocket;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by edutilos on 18.06.17.
 */
public class Client3 {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 1234 ;
        String menu = "Enter your message(\"quit\" to quit)";
        try {
            Socket client = new Socket(host , port);
            BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            BufferedReader userInputReader = new BufferedReader(new InputStreamReader(System.in));
            String sent = null ;

            while(true) {
                System.out.println(menu);
                sent = userInputReader.readLine();
                if(sent.equalsIgnoreCase("quit")) break;
                writer.write(sent);
                writer.write("\n");
                writer.flush();
                String line = reader.readLine() ;
                System.out.println(String.format("Received: %s", line));

            }

            client.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
