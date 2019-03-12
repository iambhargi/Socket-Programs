import java.net.InetAddress;
import java.net.UnknownHostException;


public class Socket2 {
    public static void main(String []args)
    {
        try
        {
            InetAddress address = InetAddress.getLocalHost();//provide ip on which this machine will rep itself on internet
            System.out.println("Address of localhost : " + address);
            InetAddress addressList[] = InetAddress.getAllByName("google.co.in");
            //getByName se ek hi ip milega , getallbyname se sbi ip if available
            for(InetAddress i : addressList)
            {
                System.out.println(i);
            }
            System.out.println("yahoo address : " + InetAddress.getByName("yahoo.co.in"));
            System.out.println("local host address : " + InetAddress.getByName("localhost"));
            
            System.out.println("LoopbackAddress : " + InetAddress.getLoopbackAddress());
        }catch (UnknownHostException ex)
        {
            System.err.println("Exception : " + ex.getMessage());
        }
    }
}
