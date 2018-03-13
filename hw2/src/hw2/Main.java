package hw2;
import java.io.IOException;
import java.util.Scanner;

public class Main {			
		public static void main(String[] args) throws IOException {
	        
	        Menu m = new Menu();
	        
	        Customers cu = new Customers("customers.txt");
	        Inventory iv = new Inventory("inventory.txt");
	        Scanner in = new Scanner(System.in);
	        int choice = 0;
	        
	        while (true) {
	            
	            m.welcome();
	            System.out.print("Please input: ");
	            choice = in.nextInt();
	            
	            if (choice == 1) {
	                String id;
	                String pass;
	                int found;
	                System.out.print("Please input your user id: ");
	                id = in.next();
	                System.out.print("Please input your password: ");
	                pass = in.next();
	                
	                found = cu.findUser(id, pass);
	                
	                if (found == 1) {
	                    cu.adminName();
	                    do {
	                        m.wBackAdmin();
	                        System.out.print("\nPlease input: ");
	                        choice = in.nextInt();
	                        
	                        if (choice == 1)
	                            iv.displayCars();
	                        else if (choice == 2)
	                            iv.addCar();
	                        else if (choice == 3)
	                            iv.deleteCar();
	                        else if (choice == 4) {
	                            m.adminSub4();
	                            System.out.print("\nPlease input: ");
	                            iv.updateCar(choice);
	                        }
	                        else if (choice == 5)
	                            cu.displayCustomers();
	                        else if (choice == 6)
	                            cu.addUser();
	                        else if (choice == 7)
	                            cu.deleteUser();
	                        else if (choice == 8) {
	                            m.adminSub8();
	                            System.out.print("\nPlease input: ");
	                            cu.updateUser(choice);
	                        }
	                        else if (choice == 9)
	                            break;
	                        else
	                            System.out.println("Not a valid option");
	                        
	                    } while (choice != 9);
	                }
	                else if (found == 2) {
	                    
	                    cu.usrName(id);
	                    do {
	                        
	                        m.wBackUser();
	                        choice = in.nextInt();
	                        
	                        if (choice == 1) {
	                            int usrC;
	                            m.userSub1();
	                            System.out.print("\nPlease input: ");
	                            usrC = in.nextInt();
	                            if (usrC == 1 || usrC == 2)
	                                iv.usrDisplayCars(usrC);
	                            else
	                                System.out.println("Incorrect choice");
	                        }
	                        
	                        else if (choice == 2) {
	                            m.userSub2();
	                            System.out.print("\nPlease input: ");
	                            choice = in.nextInt();
	                            
	                            if (choice == 1)
	                                iv.sortVin();
	                            else if (choice == 2)
	                                iv.sortBrand();
	                            else if (choice == 3)
	                                iv.sortModel();
	                            else if (choice == 4)
	                                iv.sortYear();
	                            else if (choice == 5)
	                                iv.sortMile();
	                            else if (choice == 6)
	                                iv.sortPrice();
	                            else if (choice == 7)
	                                iv.sortColor();
	                            else
	                                System.out.println("Incorrect choice");
	                        }
	                        else if (choice == 3)
	                            break;
	                        else
	                            System.out.println("Not a valid option");
	                        
	                    } while (choice != 3);
	                }
	                
	                else if (found == 0)
	                    System.out.println("Combination does not exist");
	                else if (found == -1)
	                    System.out.println("Combination does not exist");
	                else
	                    System.out.println("Combination does not exist");
	            }
	            
	            else if (choice == 2) {
	               cu.addUser(); 
	            }
	            
	            else if (choice == 3) {
	                break;
	            }
	        }
	        
	        System.out.println("Thank you!");
	        in.close();
	  }
	}