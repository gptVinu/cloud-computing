import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
/**
 *
 * @author vinyak
 */
public class Client {
    public static void main(String args[]){
        Client c = new Client();
        c.connectServer();   
    }
    private void connectServer(){
        try{
            Registry reg = LocateRegistry.getRegistry("localhost", 1099);
            Calculator calc = (Calculator) reg.lookup("server");
            
            //accepting the numbers
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter the first number : ");
            int num1 = sc.nextInt();
            System.out.println("Enter the second number : ");
            int num2 = sc.nextInt();

            System.out.println("Choose the operation...");
            System.out.println("1. Addition");
            System.out.println("2. Subtration");
            System.out.println("3. Multipliaction");
            System.out.println("4. Division");
            
            int choice = sc.nextInt();
            
            switch (choice) {
                case 1 -> System.out.println("Addition is : "+ calc.add(num1, num2));
                case 2 -> System.out.println("Subtraction is : "+ calc.sub(num1, num2));
                case 3 -> System.out.println("Multiplication is : "+ calc.mul(num1, num2));
                case 4 -> {
                    if (num2 == 0) {
                        System.out.println("Zero division error!!!");
                    } else {
                        System.out.println("Division is : "+ calc.div(num1, num2));
                    }
                }
                default -> System.out.println("Choose a correct option!");
            }

            
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
