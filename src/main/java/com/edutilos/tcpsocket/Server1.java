package com.edutilos.tcpsocket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 * Created by edutilos on 18.06.17.
 */
public class Server1 {
    public static void main(String[] args) {
        int port  = 1234 ;
        try {
            ServerSocket server = new ServerSocket(1234);
            System.out.println(String.format("Server is running on port %d", port));
            while(true) {
                Socket client = server.accept();
                InputStream cis = client.getInputStream();
                OutputStream cos = client.getOutputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(cis));
                DataOutputStream dos = new DataOutputStream(cos);

                String line = reader.readLine();
                System.out.println(String.format("Received: %s", line));
                dos.writeBytes(line.toUpperCase());
                dos.flush();
                cis.close();
                cos.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
