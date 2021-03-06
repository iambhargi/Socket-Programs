
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;



class ThreadServer implements Runnable{

    Socket s;
    
    public ThreadServer(Socket s) {
        this.s=s;
    }
    
    @Override
    public void run() {
        try{
            InputStream in = s.getInputStream();
            OutputStream out=s.getOutputStream();
            
            Scanner sc =new Scanner(in,"UTF-8");
            PrintWriter pw=new PrintWriter(new OutputStreamWriter(out),true);
            
            pw.println("BYE to break the loop..........!!!!!!!!!!!!!!!!!!!");
            
            while(sc.hasNextLine()){
                String line=sc.nextLine();
                if(line.equals("BYE")){
                    pw.println(Thread.currentThread()+"Is Closed");
                    pw.println();
                    pw.println("BYEEEEEEEEEEEEEEEEEEEEEEEEE Connection is lost now go Home.");
                    pw.println();
                    in.close();
                    break;
                }
                pw.println("Server Responce:="+line);
                pw.println();
                
            }
            
            
        }catch(Exception e){
            System.out.println("Exception:"+e.getMessage());
        }
    
    }
}

public class MultiClientSingleServerDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            ServerSocket s1=new ServerSocket(5555);
            int cnt=1;
            while(true){
                Socket s= s1.accept();
                System.out.println("Thread="+cnt+" Created");
                Thread t=new Thread(new ThreadServer(s));
                t.start(); 
                cnt++;
            } 
        }catch(Exception e){
            System.out.println("Exception:"+e.getMessage());
        }
    
}
