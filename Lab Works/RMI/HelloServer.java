package RMI;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class HelloServer {
    public static void main(String[] args) {
        try {
            HelloService helloService = new HelloServiceImpl();

            // Bind the object to the RMI registry
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("HelloService", helloService);

            System.out.println("RMI Server is running...");
        } catch (Exception e) {
            System.err.println("RMI Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
