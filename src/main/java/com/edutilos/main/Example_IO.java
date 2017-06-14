package com.edutilos.main;

import java.io.*;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * Created by edutilos on 14.06.17.
 */

public class Example_IO {
    public static void main(String[] args) {
     testFile8();
    }



    private static void testFile8() {
        try {
            Stream<Path> res =  Files.walk(Paths.get("/home/edutilos"),  2, FileVisitOption.FOLLOW_LINKS);
           res.forEach(p -> {
               System.out.println(p.toString());
           });
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    //ZipFile list entries
    private static void testFile7() {
        try {
            ZipFile file = new ZipFile(new File("test.zip"), ZipFile.OPEN_READ);
            Enumeration<? extends ZipEntry> entries = file.entries();
            while(entries.hasMoreElements()) {
                ZipEntry entry = entries.nextElement();
                System.out.println(entry.getName());
            }
        } catch(Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

  //PipedInputStream and PipedOutputStream -> does not work as i wanted
    //=> I have to close pos everytime , in order to read from pis
    private static void testFile6() {
        PipedInputStream pis = null ;
        PipedOutputStream pos = null ;

        try {
            pos = new PipedOutputStream();
            pis = new PipedInputStream();
            pos.connect(pis);
            String [] lines = {
               "foo\n",
                    "bar\n",
                    "bim\n"
            };
            for(String line: lines) {
                pos.write(line.getBytes());
                pos.flush();
               // pos.close();
                int r = -1;
                List<Byte> list = new ArrayList<>();
                while ((r = pis.read()) > 0) {
                    list.add((byte) r);
                }
                byte[] bytes = new byte[list.size()];
                int i = 0;
                for (byte b : list) {
                    bytes[i++] = b;
                }

                String str = new String(bytes);
                System.out.println(str);
             //   pis.close();
                break ;
            }
        } catch(Exception ex) {
            System.err.println(ex.getMessage());
        } finally {
            try {
                pos.close();
                pis.close();
            } catch(Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
    }


    //BufferedReader and BufferedWriter
    private static void testFile5() {
        String filename = "temp4.out";
        //write
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            String [] lines = {
               "foo\n",
                    "bar\n",
                    "bim\n"
            };
            for(String line: lines) {
                writer.write(line);
            }
        } catch(Exception ex) {
            System.err.println(ex.getMessage());
        }


        //read
        try(BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line = null;
            while((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch(Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    //FileReader and FileWriter
    private static void testFile4() {
        String filename = "temp3.out";
        //write
        try(FileWriter writer = new FileWriter(filename)) {
           String [] lines = {
                   "foo\n",
                   "bar\n",
                   "bim\n"
           };
           for(String line: lines) {
               writer.write(line);
           }
        } catch(Exception ex) {
            System.err.println(ex.getMessage());
        }


        //read
        try(FileReader reader = new FileReader(filename)) {
            List<Byte> list = new ArrayList<>();
            int read = -1 ;
            while((read = reader.read()) > 0) {
                list.add((byte)read);
            }
            byte[] bytes = new byte[list.size()];
            for(int i= 0 ; i< bytes.length; ++i) {
                bytes[i] = list.get(i);
            }
            String str = new String(bytes);
            System.out.println(str);
        } catch(Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    //BufferedInputStream and BufferedOutputStream
    private static void testFile3() {
        String filename = "temp2.out";
        //write
        BufferedOutputStream bos = null ;
        try {
            bos = new BufferedOutputStream(new FileOutputStream(filename));
            String []  lines = {
                    "foo\n",
                    "bar\n",
                    "bim\n"
            };

            for(String line: lines) {
                for(byte b: line.getBytes()) {
                    bos.write(b);
                }
            }

        } catch(Exception ex) {
            System.err.println(ex.getMessage());
        } finally {
            try {
                bos.close();
            } catch(Exception ex) {
                System.err.println(ex.getMessage());
            }
        }

        //read
        BufferedInputStream bis = null;
        try {
             bis = new BufferedInputStream(new FileInputStream(filename));
             List<Byte> list = new ArrayList<>();
             while(bis.available()> 0 ) {
                 byte b = (byte)bis.read();
                 list.add(b);
             }
             byte[] bytes = new byte[list.size()];
             int i = 0 ;
             for(Byte b: list) {
                 bytes[i++]= b ;
             }
             String str = new String(bytes);
            System.out.println(str);
        } catch(Exception ex) {
            System.err.println(ex.getMessage());
        } finally {
            try {
                bis.close();
            } catch(Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
    }

    //InputStream and OutputStream
    private static void testFile2() {
        String filename = "temp.out";
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(filename);
            String [] lines = {
                    "hello world.\n",
                    "how are you?\n",
                    "i am fine.\n"
            };
            for(String line: lines) {
                for(byte b: line.getBytes()) {
                    fos.write(b);
                }
            }
        } catch(Exception ex) {
            System.err.println(ex.getMessage());
        } finally {
            try {
                fos.close();
            } catch(Exception ex) {
                System.err.println(ex.getMessage());
            }
        }

        //reading
        FileInputStream fis = null ;
        try {
            fis = new FileInputStream(filename);
            List<Byte> bytes = new ArrayList<>();
            while(fis.available()>0) {
              //  System.out.print(new String(fis.read()));
                byte b = (byte)fis.read();
                bytes.add(b);
            }

            byte[] bs = new byte[bytes.size()];
            int i = 0 ;
            for(Byte b: bytes)  {
                bs[i++] = b ;
            }
            String str = new String(bs);
            System.out.println(str);
        } catch(Exception ex) {
            System.err.println(ex.getMessage());
        } finally {
            try {
                fis.close();
            } catch(Exception ex) {
                System.err.println(ex.getMessage());
            }
        }

    }


    private static void testFile1() {
        //file infos
        try {
            File file =new File("Example_IO.java");
            boolean isAbsolute = file.isAbsolute();
            boolean isDirectory = file.isDirectory();
            boolean isFile = file.isFile();
            boolean isHidden = file.isHidden();
            boolean exists = file.exists();
            boolean canExecute = file.canExecute();
            boolean canRead = file.canRead();
            boolean canWrite = file.canWrite();
            File absoluteFile = file.getAbsoluteFile();
            String absolutePath = file.getAbsolutePath();
            File canonicalFile = file.getCanonicalFile();
            String canonicalPath = file.getCanonicalPath();
            long freeSpace = file.getFreeSpace();
            String name = file.getName();
            String parent = file.getParent();
            File parentFile = file.getParentFile();
            String path = file.getPath();
            long totalSpace = file.getTotalSpace();
            long usableSpace = file.getUsableSpace();

            file = new File("/home/edutilos");
            File[] all = file.listFiles();
            for(File f: all) {
              //  System.out.println(f.getName());
            }


            all = file.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                   // System.out.println(dir.getName() + "=> "+ name);
                    if(name.startsWith(".")) return false ;
                    return true ;
                }
            });

            for(File f: all) System.out.println(f.getName());
            System.out.println();


            all = file.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    if(!name.startsWith(".")) return false ;
                    return true ;
                }
            });
            for(File f: all) System.out.println(f.getName());
            System.out.println();
        } catch(Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
}
