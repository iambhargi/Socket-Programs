
//server creation which will echo the msg sent by the client
//(single client/server architecture)
import java.net.ServerSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
public class socket3 {

    /**
     * @param args the command line arguments
     */
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
                if(line.equals("BYE")){
                    out.println("BYEEEEEEEEEEEEEEEEEEEEEEEEE Connection is lost now go Home.");
                    incoming.close();
                    break;
                }
     
                out.println("Server Response:" + line);
               
            }
        } catch(Exception e){
            System.out.println("Exception:"+e.getMessage());
        }
        
    }
    
}
