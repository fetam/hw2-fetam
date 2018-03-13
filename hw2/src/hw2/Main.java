package hw2;
import java.io.IOException;
import java.util.Scanner;

public class Main {	
	public static void main(String[] args) throws IOException{
		
		inventory Inv = new Inventory("inventory.txt");		
		customers Cust = new Customers("customers.txt");
		Menu m = new Menu();
		Scanner in1 = new Scanner(System.in);
		int UC = 0;
		
		

		 while(true){
			System.out.println();
			m.mainMenu();
			UC = in1.nextInt();
			String UserType ="";
			
			System.out.println();
			if(UC == 1){
				boolean match = false;
				while(match == false){
					System.out.print("Please input your user id: ");
					String ID = in1.next();
					System.out.print("Please input password: ");
					String Password = in1.next();
					
					for(int i=0;i<Cust.nm;i++){
						if(ID.equals(Cust.members[i].id)){
							if(Password.equals(Cust.members[i].pw)){
							match = true;
							UserType = "Normal";
							}
						}
					}
					
					if(ID.equals("admin")){
						if(Password.equals("adminpass")){
							match = true;
							UserType = "Admin";
						}
					}
					if(match==false){
						System.out.println("Log In and Password do not match");
					}
				}
				
				
				if(UserType.equals("Normal")){
					while(true){
						System.out.println();
						m.LogInDoneMenu();
						UC = in1.nextInt();
						if(UC == 1){
							Inv.displayCars();
						}
						else if(UC == 2){
							m.SortCarsMenu();
							UC = in1.nextInt();
							if(UC == 1){
								m.SortByVin();
							}
							else if(UC == 2){
								m.SortByBrand();
							}
							else if(UC == 3){
								m.SortByModel();
							}
							else if(UC == 4){
								m.SortByYear();
							}
							else if(UC == 5){
								m.SortByMileage();
							}	
							else if(UC == 6){
								m.SortByPrice();
							}
							else if(UC == 7){
								m.SortByColor();	
							}

						}
						else if(UC == 3){
							break;
						}
						
					}
				}
				else if(UserType.equalsIgnoreCase("Admin")){
					while(true){
						System.out.println();
						m.AdminMenu();
						UC = in1.nextInt();
						if(UC == 1){
							Inv.displayCars();
						}
						else if(UC == 2){
							m.AddCar();
							Inv = new Inventory("inventory.txt");
						}
						else if(UC == 3){
							m.DeleteCar();
						}
						else if(UC == 4){
							m.UpdateCar();
						}
						else if(UC == 5){
							Cust.displayCustomers();
						}	
						else if(UC == 6){
							m.SignUpMenu();
							Cust = new Customers("customers.txt");	
						}
						else if(UC == 7){
							m.DeleteUser();		
						}	
						else if(UC == 8){
							m.UpdateUser();
						}
						else if(UC == 9){
							break;
						}
					}
				}

			}
			else if(UC == 2){
				m.SignUpMenu();
				Cust = new Customers("customers.txt");	
			}
			else if(UC == 3){
				break;
			}
		}
		in1.close();
		
	}
}
