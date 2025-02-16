import java.util.ArrayList;
import java.util.Scanner;

public class PizzaTime {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        streetName();
    }
    private static void streetName(){
        System.out.println("What street do you live on");
        String StreetName = scanner.nextLine();

        ArrayList<String> address = new ArrayList<String>();
        address.add("Burrows");
        address.add("Main");
        address.add("Henderson");
        address.add("Magnus");
        address.add("Mountain");
        System.out.println(address);
        
    }
    
}