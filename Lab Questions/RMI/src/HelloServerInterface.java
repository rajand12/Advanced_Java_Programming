import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HelloServerInterface extends Remote {
    String sayHello() throws RemoteException;
}
