
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
public class SocketOddEvenFinal {

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
            out.println("\nEnter Number To Check For Odd Or Even: ");
            
            //readig data from client
            
            while(sc.hasNextLine()){
                out.println("\nEnter Number To Check For Odd Or Even: ");
                String line=sc.nextLine();
                String tmp="";
                for(int i=0;i<line.length();i++){
                        if((int)line.charAt(i) > 47 && (int)line.charAt(i) < 58){
                            if(Integer.parseInt(line) % 2 == 0){
                            tmp="Even";
                            out.println("\n"+line+" is even.");
                            break;

                        }
                        else if(Integer.parseInt(line) % 2 != 0){
                            tmp="Odd";
                            out.println("\n"+line+" is odd.");
                            break;
                        }
                    }

                    else{
                        out.println("\nEnter Numeric value only");
                        break;
                    }
                }
                
                if(line.equals("BYE")){
                    out.println("BYEEEEEEEEEEEEEEEEEEEEEEEEE Connection is lost now go Home.");
                    incoming.close();
                    break;
                }
     
                //out.println("\nServer Response: " + line + " is "+tmp);
               
            }
        } catch(Exception e){
            System.out.println("Exception:"+e.getMessage());
        }
        
    }
    
}


