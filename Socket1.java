package Networking;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Socket1 {
  public static void main(String[] args)
  {
      try
      {
          Socket s=new Socket();
          s.connect(new InetSocketAddress("time-a.nist.gov",13),10000);
          //or
          //InetSocketAddress a = new InetSocketAddress("time");
          //s.connect(a,10000);
          
          //read the data received from the 
          Scanner sc=new Scanner(s.getInputStream(),"UTF-8");
          while(sc.hasNextLine())
         {
            System.out.println(sc.nextLine());
         }
       }   catch(IOException ex)
        {
            System.err.println("Exception : " +ex.getMessage());
        }
  }
}

