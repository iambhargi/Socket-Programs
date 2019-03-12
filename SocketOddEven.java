
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mca241
 */
public class SocketOddEven {

    public static void main(String[] args) {
        // TODO code application logic here
        try{
            
            ServerSocket s1=new ServerSocket(5555);
            Socket incoming = s1.accept();
            
            //Reading msg
            InputStream is= incoming.getInputStream();
            OutputStream os= incoming.getOutputStream();
            
            //reading input from client
            Scanner sc=new Scanner(is,"UTF-8");
            
            //writing data from client
            PrintWriter out = new PrintWriter(
            new OutputStreamWriter(os,"UTF-8"),true);
            
            //for the end of echo
            out.println("type BYE to exit");
            
            //readig data from client
            
            while(sc.hasNextLine()){
                String line=sc.nextLine();
                String tmp="";
                if(Integer.parseInt(line) % 2 == 0){
                    tmp="Even";
                    //out.println(line+" is even.");
                
                }
                else if(Integer.parseInt(line) % 2 != 0){
                    tmp="Odd";
                    //out.println(line+" is odd.");
                }
                if(line.equals("BYE")){
                    out.println("BYEEEEEEEEEEEEEEEEEEEEEEEEE Connection is lost now go Home.");
                    incoming.close();
                    break;
                }
     
                out.println("\nServer Response: " + line + " is "+tmp);
               
            }
        } catch(Exception e){
            System.out.println("Exception:"+e.getMessage());
        }
        
    }
    
}


