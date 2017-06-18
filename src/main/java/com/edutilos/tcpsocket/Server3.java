package com.edutilos.tcpsocket;

import org.codehaus.groovy.runtime.powerassert.SourceText;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by edutilos on 18.06.17.
 */
//simple echo upper case server
public class Server3 {
    public static void main(String[] args) {
        int port = 1234;

        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println(String.format("Server started at %d", port));
            while(true) {
                System.out.println("Waiting for message from client");
                Socket client = server.accept();
                InputStream is = client.getInputStream();
                OutputStream os = client.getOutputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os));
                String line = null ;
                while((line= reader.readLine()) != null) {
                    System.out.println(String.format("Received: %s", line));
                    writer.write(line.toUpperCase());
                    writer.write("\n");
                    writer.flush();
                }

                reader.close();
                writer.close();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
