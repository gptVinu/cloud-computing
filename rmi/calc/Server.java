import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
/**
 *
 * @author vinyak
 */
public class Server extends UnicastRemoteObject implements Calculator{
    public Server() throws RemoteException{
        super();
    }
    @Override
    public int add(int a, int b) throws RemoteException{
        return a+b;
    }
    @Override
    public int sub(int a, int b) throws RemoteException{
        return a-b;
    }
    public int mul(int a, int b) throws RemoteException{
        return a*b;
    }
    public int div(int a, int b) throws RemoteException{
        return a/b;
    }
    
    //main method
    public static void main(String args[]) throws RemoteException{
        try{
            Registry reg = LocateRegistry.createRegistry(1099);
            reg.rebind("server",new Server());
            System.out.println("Server is running...");
        }catch (Exception e){
            System.out.println(e);
        }
    } 
}
