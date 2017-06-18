package com.edutilos.tcpsocket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by edutilos on 18.06.17.
 */
public class WorkerServer {
    private static final String newline = "\n";
    public static void main(String[] args) {
        int port = 1234;
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println(String.format("Server started at %d", port));
            while(true) {
                Socket clientSocket = server.accept();
                InputStream is = clientSocket.getInputStream();
                OutputStream os = clientSocket.getOutputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os));
                String line = null;

                while((line = reader.readLine()) != null) {
                    Worker w= convertStringToWorker(line);
                    System.out.println(String.format("Received worker = %s", w.toString()));
                    w.setAge(w.getAge()*2);
                    w.setWage(w.getWage()*2);
                    w.setName("modified "+ w.getName());
                    w.setActive(!w.isActive());
                    writer.write(w.toString());
                    writer.write(newline);
                    writer.flush();
                }

                writer.close();
                reader.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static Worker convertStringToWorker(String str) throws Exception {
        Worker w = new Worker();
        String [] splitted = str.split(",");
        w.setId(Long.parseLong(splitted[0]));
        w.setName(splitted[1]);
        w.setAge(Integer.parseInt(splitted[2]));
        w.setWage(Double.parseDouble(splitted[3]));
        w.setActive(splitted[4].equalsIgnoreCase("true")?true:false);
        return w;
    }
}
