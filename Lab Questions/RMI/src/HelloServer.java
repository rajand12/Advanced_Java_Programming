import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloServer extends UnicastRemoteObject implements HelloServerInterface {
    public HelloServer() throws RemoteException {
    }

    @Override
    public String sayHello() throws RemoteException {
        return "Hello Client, Server Started";
    }

    public static void main(String[] args) {
        try {
            HelloServer server = new HelloServer();
            java.rmi.registry.Registry registry = java.rmi.registry.LocateRegistry.createRegistry(1099);
            registry.rebind("HelloServer", server);
            System.out.println("Server started");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
