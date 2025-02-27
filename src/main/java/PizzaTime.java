
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PizzaTime {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        String pizza_size = pizzaSize();
        List<String> toppings = pizzaTopping();
        System.out.println("Your Address is " + address() + " , your postal code is " + postalCode() + " and you live in " + city() + " you have ordered a " +  pizza_size + " size pizza, with these toppings " + toppings  + " and it costs $"+ pizzacost(pizza_size,toppings));
    }
    private static String address(){
        System.out.println("What is your address: ");
        String address = scanner.nextLine().trim().toLowerCase();
        String[] splitAddress = address.split(" ", 2);
        List<String> streetnames =  Arrays.asList("burrows", "main", "henderson", "magnus", "mountain"); // just had a question what is a hashset and can i use it here 
        if (!streetnames.contains(splitAddress[1])){
            System.out.println("Error! Invalid street name");
            return address();
        }
        int streetNumber = 0;
        try {
            streetNumber = Integer.parseInt(splitAddress[0]);
        }
        catch(NumberFormatException e){
            System.out.println("Error! Invalid street number");
            return address();
        }
        return splitAddress[0] + " " + splitAddress[1].toUpperCase();
    }
    private static String city(){
        System.out.println("What is your city: ");
        String city = scanner.nextLine().trim().toLowerCase();
        if (!city.equals("winnipeg")) {
            System.out.println("Error! Invalid city ");
            return city();
        }
        else{
            return city.toUpperCase();
        }
    }
    private static String postalCode(){
        System.out.println("What is your postal code: ");
        String city = scanner.nextLine().trim().toLowerCase();
        city = city.replaceAll(" ",""); // note use "//s" as the regex if tab or newline is a issue
        char postalChar = city.charAt(0);
        if (city.length() == 6){
            for (int a = 0; a < city.length(); a ++) {
                postalChar = city.charAt(a);
                if (!((a % 2 == 0 && Character.isLetter(postalChar)) || (a % 2 != 0 &&Character.isDigit(postalChar)))){
                    
                    System.out.println("Error! Invalid postal code");
                    return postalCode();
                }
            }
            return city.toUpperCase();
        }
        else{
            System.out.println("Error! Invalid postal code");
            return postalCode();
        }
    }   
    private static String pizzaSize(){
        System.out.println("What size pizza would you like order small($4), medium($7), or large($9)");
        String pizzaSize = scanner.nextLine().trim();
        if (!(pizzaSize.equalsIgnoreCase("small") || pizzaSize.equalsIgnoreCase("medium") || pizzaSize.equalsIgnoreCase("large"))){
            System.out.println("Error! Invalid size selected");
            return pizzaSize();
        }
        return pizzaSize;
    }
    private static List<String> pizzaTopping(){
        System.out.println("What pizza toppings would you like: pepperoni($2), onions($2), peppers($2), chicken($2), pineapple($2) or olives($2)?");
        
        List<String> toppings = new ArrayList<>(); 

        while (true) {
            String pizzaTopping = scanner.nextLine().trim().toLowerCase();
            switch (pizzaTopping) {
                case "pepperoni":
                    toppings.add("pepperoni");
                    break;
                case "onions":
                    toppings.add("onions");
                    break;
                case "peppers":
                    toppings.add("peppers");
                    break;
                case "chicken":
                    toppings.add("chicken");
                    break;
                case "pineapple":
                    toppings.add("pineapple");
                    break;
                case "olives":
                    toppings.add("olives");
                    break;
                case "no":  
                    return toppings;  
                default:
                    System.out.println("Error! Invalid input, please choose one of the listed toppings.");
                    break; 
            }
            
            System.out.println("Would you like to add any more toppings? (pepperoni, onions, peppers, chicken, pineapple, olives, or no to finish)");
        }
    }
    private static int pizzacost(String pizza_size, List<String> toppings){
        int pizza_cost = 0;
            switch (pizza_size) {
                case "small":
                    pizza_cost = 4;
                    break;
                case "medium":
                    pizza_cost = 7;
                    break;
                case "large":
                    pizza_cost = 9;
                    break;
                default:
                    break;
            }
        int toppings_cost = (toppings.size()) * 2;
        int total_cost = toppings_cost + pizza_cost;
        return total_cost;
    }

}