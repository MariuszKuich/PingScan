import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

public class Scanner {

    public static long checkResponse(String ipAddress) {
        Date start, stop;
        InetAddress inetAddress = null;
        try {
            inetAddress = InetAddress.getByName(ipAddress);
            int timeoutInMs = 5000;
            start = new Date();
            if(inetAddress.isReachable(timeoutInMs)) {
                stop = new Date();
                return (stop.getTime() - start.getTime());
            }
        }
        catch(UnknownHostException e) {
            System.out.println("Problem during execution: unknown host");
        }
        catch(IOException e) {
            System.out.println("Error during checking connection: " + e.getMessage());
        }
        return -1;
    }
}
