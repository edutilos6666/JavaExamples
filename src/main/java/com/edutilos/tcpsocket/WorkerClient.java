package com.edutilos.tcpsocket;

import java.io.*;
import java.net.Socket;

/**
 * Created by edutilos on 18.06.17.
 */
public class WorkerClient {
    private static final String newline = "\n";
    public static void main(String[] args) {
        String host = "localhost";
        int port = 1234 ;

        Socket client =null ;
        try {
            client = new Socket(host , port);
            StringBuilder sb = new StringBuilder() ;
            sb.append("insert id,name,age,wage,active of Worker instance")
                    .append(newline)
                    .append("insert quit to quit.");
            String menu = sb.toString();

            InputStream is = client.getInputStream();
            OutputStream os = client.getOutputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os));
            BufferedReader userInputReader = new BufferedReader(new InputStreamReader(System.in));

            while(true) {
                System.out.println(menu);
                String input = userInputReader.readLine();
                if(input.equalsIgnoreCase("quit")) break;
                Worker w = convertStringToWorker(input);
                writer.write(w.toString());
                writer.write(newline);
                writer.flush();

                String line = reader.readLine();
                System.out.println(line);
                Worker modifiedWorker = convertStringToWorker(line);
                System.out.println(String.format("Modified worker = %s", modifiedWorker.toString()));
            }
        } catch(IOException ex) {
            ex.printStackTrace();
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch(NullPointerException ne) {
                ne.printStackTrace();
            }
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
