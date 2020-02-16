import java.util.*;
import java.sql.*;

public class App {
    public static void first_screen() {
        System.out.println("Please enter the type of user you are (Admin-1, Seller-2, Customer-3)");
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        DB_Helper database = new DB_Helper();

        database.initialize();

        System.out.println("Welcome to CandyLand!");

        int choice, user_type, candy_seller, purchase_id;
        candy_seller = 0;
        purchase_id = 0;
        while (true) {
            first_screen();
            user_type = in.nextInt();
            in.nextLine();
            switch (user_type) {
                case 2:
                    int id,mobile,candy_id, quantity,contains_egg, price, weight;
                    String name,email,address,candy_name, candy_type;
                    System.out.println("Enter id: ");
                    id = in.nextInt();
                    in.nextLine();
                    if (database.checkIfSellerExists(id) == 0) {
                        System.out.println("Enter name(string): ");
                        name = in.nextLine();
                        System.out.println("Enter address(string): ");
                        address = in.nextLine();
                        System.out.println("Enter email(string): ");
                        email = in.nextLine();
                        System.out.println("Enter mobile num(int): ");
                        mobile = in.nextInt();
                        // in.nextLine();
                        database.addSeller(id, name, address, email, mobile);
                    }
                    int add;
                    while (true) {
                        System.out.println("Do you want to add candy (1-yes, 0-no): ");
                        add = in.nextInt();
                        in.nextLine();
                        if (add == 1) {
                            System.out.println("Enter the following:");
                            System.out.println("Candy_id(int): ");
                            candy_id = in.nextInt();
                            in.nextLine();
                            if (database.checkIfCandyExists(candy_id) == 0) {
                                System.out.println("Candy name(string): ");
                                candy_name = in.nextLine();
                                System.out.println("Candy type(string): ");
                                candy_type = in.nextLine();
                                System.out.println("Does it contain egg (1-if yes and 0-if no): ");
                                contains_egg = in.nextInt();
                                System.out.println("Price(int): ");
                                price = in.nextInt();
                                System.out.println("Weight(int): ");
                                weight = in.nextInt();
                                // candy_ids.add(candy_id);
                                System.out.println("Quantity you wish to add(int): ");
                                quantity = in.nextInt();
                                database.addCandy(candy_id, candy_name, candy_type, quantity, contains_egg, price, weight);
                                candy_seller += 1;
                                database.addCandySeller(candy_seller, quantity, id, candy_id);
                            }
                            else {
                                System.out.println("Quantity you wish to add(int): ");
                                quantity = in.nextInt();
                                database.updateCandy(candy_id, quantity);
                                if (database.isSellerInCandySeller(id) == 1) {
                                    database.updateCandySeller(quantity, id, candy_id);
                                }
                                else {
                                    candy_seller += 1;
                                    database.addCandySeller(candy_seller, quantity, id, candy_id);
                                }
                            }
                            
                        }         
                        else if (add == 0) {
                            break;
                        }
                        else {
                            System.out.println("Please enter either 1 or 0.");
                            continue;
                        }
                    }
                    break;
                case 1:
                    while (true) {
                        int authenticate;
                        System.out.println("Do you wish to authenticate candy(1-yes, 0-no): ");    
                        authenticate = in.nextInt();
                        if (authenticate == 1) {
                            // display available candy
                            System.out.println("Here is a list of unauthorized candy: ");
                            if (database.browse_admin() == 0) {
                                break;
                            }
                            int can_id;
                            System.out.println("Enter candy id(int): ");
                            can_id = in.nextInt();
                            if (database.checkIfCandyExists(can_id) == 1) {
                                if (database.isAuthenticated(can_id) == 1) {
                                    System.out.println("Candy with id "+can_id+" is already authenticated.");
                                }
                                else {
                                    database.authenticateCandy(can_id);
                                    System.out.println("Candy with id "+can_id+" authenticated.");
                                    // auth_candy_ids.add(can_id);
                                }
                            }
                            else {
                                System.out.println("Candy with id "+can_id+" isn't present. Please check the id you have given.");
                                continue;
                            }
                        }
                        else if (authenticate == 0){
                            break;
                        }
                        else {
                            continue;
                        }
                    }
                    break;
                case 3:
                    int cust_id,cust_mobile;
                    String cust_name,cust_address,cust_email;
                    System.out.println("Enter id(int): ");
                    cust_id = in.nextInt();
                    in.nextLine();
                    if (database.checkIfCustomerExists(cust_id) == 0) {
                        System.out.println("Enter name(string): ");
                        cust_name = in.nextLine();
                        System.out.println("Enter address(string): ");
                        cust_address = in.nextLine();
                        System.out.println("Enter email(string): ");
                        cust_email = in.nextLine();
                        System.out.println("Enter mobile number(int): ");
                        cust_mobile = in.nextInt();
                        // cust_ids.add(cust_id);
                        database.addCustomer(cust_id, cust_name, cust_address, cust_email, cust_mobile);
                    }
                    while (true) {
                        int option;
                        System.out.println("Choose an option: ");
                        System.out.println("1. Browse.");
                        System.out.println("2. Buy a candy.");
                        System.out.println("3. Exit.");
                        System.out.println("Enter option: ");
                        option = in.nextInt();
                        if (option == 1) {
                            System.out.println("Here's a list of all available candy: ");
                            database.browse();
                        }
                        else if (option == 2) {
                            int pick_candy_id, number_of_candy;
                            System.out.println("Enter id of candy you want to buy(int): ");
                            pick_candy_id = in.nextInt();
                            // add code to check if candy exists
                            if (database.checkIfCandyExists(pick_candy_id) == 0) {
                                System.out.println("The candy you chose isn't available. Please check the id you have given.");
                                continue;
                            }
                            else {
                                // This is code to check if candy is authenticated
                                if (database.isAuthenticated(pick_candy_id) == 0) {
                                    System.out.println("The candy you chose isn't available. Please check the id you have given.");
                                    continue;
                                }
                                else {
                                    int curr_stock = database.getCandyStock(pick_candy_id);
                                    if (curr_stock == 0) {
                                        System.out.println("The candy you chose isn't available. Please choose another candy.");
                                        continue;
                                    }
                                    else {
                                        System.out.println("Enter the quantity of the candy you want to buy(int): ");
                                        number_of_candy = in.nextInt();
                                        if (number_of_candy > curr_stock) {
                                            System.out.println("The quantity you have chosen exceeds the stock. Current stock is: " + curr_stock);
                                            continue;
                                        }
                                        else {
                                            database.buyCandy(pick_candy_id, curr_stock, number_of_candy);
                                            purchase_id += 1;
                                            database.addPurchase(purchase_id, number_of_candy, cust_id, pick_candy_id);
                                        }
                                    }
                                }
                            }
                        }
                        else if (option == 3) {
                            break;
                        }
                        else {
                            System.out.println("Please enter a valid option.");
                            continue;
                        }
                    }
                    break; 
                default:
                    System.out.println("Please enter one of the provided option numbers.");
                    
            }
            if (user_type == 1 || user_type == 2 || user_type == 3) {
                break;
            }
        }
        database.terminate();
    }
}