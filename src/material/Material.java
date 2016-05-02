/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material;

import java.io.*;
import java.net.*;

/**
 *
 * @author debian
 */
public class Material {

    static int gruen = 10;
    static int rot = 10;
    static int gelb = 10;
    
    static String line;
    static BufferedReader fromClient;
    static DataOutputStream toClient;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
        String line;
        boolean verbunden;
        ServerSocket listenSocket = new ServerSocket(9999);
        while (true){
            Socket cliSocket = listenSocket.accept();
            verbunden = true;
            BufferedReader fromClient = new BufferedReader(new InputStreamReader(cliSocket.getInputStream()));
            DataOutputStream toClient = new DataOutputStream(cliSocket.getOutputStream());
            while(verbunden){
                line = fromClient.readLine();
                System.out.println("Empfangen: " + line);
                if (line.equals("gruen")) {
                    gruen--;
                    System.out.println("gruen verringert");
                    if (gruen == 0) {
                        toClient.writeBytes("leer" + '\n');
                    }
                    else {
                        toClient.writeBytes("erfolgreich" + '\n');
                    }
                }
                if (line.equals("rot")) {
                    rot--;
                    System.out.println("rot verringert");
                    if (rot == 0) {
                        toClient.writeBytes("leer" + '\n');
                    }
                    else {
                        toClient.writeBytes("erfolgreich" + '\n');
                    }
                }
                if (line.equals("gelb")) {
                    gelb--;
                    System.out.println("gelb verringert");
                    if (gelb == 0) {
                        toClient.writeBytes("leer" + '\n');
                    }
                    else {
                        toClient.writeBytes("erfolgreich" + '\n');
                    }
                }
                if (line.equals("gruen auffuellen")) {
                    gruen = 10;
                    System.out.println("gruen aufgefuellt");
                    toClient.writeBytes("erfolgreich" + '\n');
                }
                if (line.equals("rot auffuellen")) {
                    rot = 10;
                    System.out.println("rot aufgefuellt");
                    toClient.writeBytes("erfolgreich" + '\n');
                }
                if (line.equals("gelb auffuellen")) {
                    gelb = 10;
                    System.out.println("gelb aufgefuellt");
                    toClient.writeBytes("erfolgreich" + '\n');
                }
            } // end while verbunden
            toClient.close(); cliSocket.close();
        } // end repeat forever
        } //end try
        catch(IOException e){
    
        }
    }
}