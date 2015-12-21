/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echos;

import java.io.*;
import java.net.*;
import java.lang.Thread;

public class miThread extends Thread{
    Socket client;
     miThread (Socket client) {
        this.client = client;
     }
    public void run(){
    try {
      BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
      PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
      while (true) {
        String line = reader.readLine();
          System.out.println(line);
        writer.println("[echo] " +" "+ line );
      }
    }
    catch (Exception e) {
      System.err.println("Exception caught: client disconnected.");
    }
    finally {
      try { client.close(); }
      catch (Exception e ){ ; }
    }
  
    }
}
