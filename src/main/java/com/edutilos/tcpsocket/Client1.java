package com.edutilos.tcpsocket;

import java.io.*;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 * Created by edutilos on 18.06.17.
 */
public class Client1 {
    public static void main(String[] args) {
        int port = 1234 ;
        String host = "localhost";
        try {
            Socket clientSocket = new Socket(host ,port);
            InputStream is = clientSocket.getInputStream();
            OutputStream os = clientSocket.getOutputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
           // BufferedOutputStream bos = new BufferedOutputStream(os);
            DataOutputStream dos = new DataOutputStream(os);
            String sent = "hello server from client\n";
            dos.writeBytes(sent);
            dos.flush();
            String line =  reader.readLine();

            System.out.println(String.format("Received: %s", line));
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
