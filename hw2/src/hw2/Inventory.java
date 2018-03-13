package hw2;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Inventory {
	    
	    int nc;
	    
	    Car[] cars;
	    
	    public Inventory(String fn) throws FileNotFoundException {
	       
	        File inF_IN = new File(fn);
	        Scanner s_Count = new Scanner(inF_IN);
	        Scanner s_IN = new Scanner(inF_IN);
	        
	        nc = 0;
	        
	        while (s_Count.hasNext()) {
	            String line;
	            line = s_Count.next();
	            nc++;
	        }
	        
	        cars = new Car[nc];
	        
	        for (int x = 0; x < nc; ++x)
	            cars[x] = new Car();
	        
	        int y = 0;
	        
	        while (s_IN.hasNext()) {
	            String line;
	            line = s_IN.next();
	            
	            String[] result = line.split("/");
	            
	            for (int x = 0; x < result.length; ++x) {
	                if (x == 0)
	                    cars[y].setVin(result[x]);
	                else if (x == 1)
	                    cars[y].setBrand(result[x]);
	                else if (x == 2)
	                    cars[y].setModel(result[x]);
	                else if (x == 3)
	                    cars[y].setYear(Integer.parseInt(result[x]));
	                else if (x == 4)
	                    cars[y].setMile(Integer.parseInt(result[x]));
	                else if (x == 5)
	                    cars[y].setPrice(Double.parseDouble(result[x]));
	                else if (x == 6)
	                    cars[y].setColor((result[x]).charAt(0));
	                else if (x == 7) {
	                    if (result[x].equals("Y") || result[x].equals("y"))
	                        cars[y].setBrandnew(true);
	                    else
	                        cars[y].setBrandnew(false);
	                }
	                
	            }
	            y++;
	        }
	    }
	    
	    public void displayCars() {
	        // Print formatted
	        System.out.printf("%-12s %-12s %-12s %-12s %-12s %-12s %-12s %-12s\n", "VIN", "Brand", "Model", "Year", "Mileage", "Price", "Color", "New");
	        for (int x = 0; x < nc; ++x) {
	            if (cars[x].getBrandnew())
	                System.out.printf("%-12s %-12s %-12s %-12s %-12s %-12s %-12s %-12s\n", cars[x].getVin(), cars[x].getBrand(), cars[x].getModel(), cars[x].getYear()
	                        , cars[x].getMile(), cars[x].getPrice(), cars[x].getColor(), "Y");
	            else if (!cars[x].getBrandnew())
	                System.out.printf("%-12s %-12s %-12s %-12s %-12s %-12s %-12s %-12s\n", cars[x].getVin(), cars[x].getBrand(), cars[x].getModel(), cars[x].getYear()
	                        , cars[x].getMile(), cars[x].getPrice(), cars[x].getColor(), "N");
	        }
	    }
	    
	    public void displaySorted(Car[] arr) {
	      
	        System.out.printf("%-12s %-12s %-12s %-12s %-12s %-12s %-12s %-12s\n", "VIN", "Brand", "Model", "Year", "Mileage", "Price", "Color", "New");
	        for (int x = 0; x < nc; ++x) {
	            if (cars[x].getBrandnew())
	                System.out.printf("%-12s %-12s %-12s %-12s %-12s %-12s %-12s %-12s\n", cars[x].getVin(), cars[x].getBrand(), cars[x].getModel(), cars[x].getYear()
	                        , cars[x].getMile(), cars[x].getPrice(), cars[x].getColor(), "Y");
	            else if (!cars[x].getBrandnew())
	                System.out.printf("%-12s %-12s %-12s %-12s %-12s %-12s %-12s %-12s\n", cars[x].getVin(), cars[x].getBrand(), cars[x].getModel(), cars[x].getYear()
	                        , cars[x].getMile(), cars[x].getPrice(), cars[x].getColor(), "N");
	        }
	    }
	    
	    public void usrDisplayCars(int usrChoice) {
	        // Print formatted
	        System.out.printf("%-12s %-12s %-12s %-12s %-12s %-12s %-12s %-12s\n", "VIN", "Brand", "Model", "Year", "Mileage", "Price", "Color", "New");
	        for (int x = 0; x < nc; ++x) {
	            if (usrChoice == 1) {
	                if (cars[x].getBrandnew())
	                    System.out.printf("%-12s %-12s %-12s %-12s %-12s %-12s %-12s %-12s\n", cars[x].getVin(), cars[x].getBrand(), cars[x].getModel(), cars[x].getYear()
	                            , cars[x].getMile(), cars[x].getPrice(), cars[x].getColor(), "Y");
	            }
	            else if (usrChoice == 2) {
	                if (!cars[x].getBrandnew())
	                    System.out.printf("%-12s %-12s %-12s %-12s %-12s %-12s %-12s %-12s\n", cars[x].getVin(), cars[x].getBrand(), cars[x].getModel(), cars[x].getYear()
	                            , cars[x].getMile(), cars[x].getPrice(), cars[x].getColor(), "N");
	            }
	        }
	    }
	    
	    public void sortVin() {
	        Car temp = new Car();
	        Car [] copy = Arrays.copyOf(cars, nc);
	        
	        for (int x = 0; x < nc; ++x) {
	            for (int y = 1; y < nc; ++y) {
	                if (copy[y-1].getVin().compareTo(copy[y].getVin()) > 0) {
	                    temp = copy[y-1];
	                    copy[y-1] = copy[y];
	                    copy[y] = temp;
	                }
	            }
	        }
	        
	        displaySorted(copy);
	    }
	    
	    public void sortBrand() {
	        Car temp = new Car();
	        Car [] copy = Arrays.copyOf(cars, nc);
	        
	        for (int x = 0; x < nc; ++x) {
	            for (int y = 1; y < nc; ++y) {
	                if (copy[y-1].getBrand().compareTo(copy[y].getBrand()) > 0) {
	                    temp = copy[y-1];
	                    copy[y-1] = copy[y];
	                    copy[y] = temp;
	                }
	            }
	        }
	        
	        displaySorted(copy);
	    }
	    
	    public void sortModel() {
	        Car temp = new Car();
	        Car [] copy = Arrays.copyOf(cars, nc);
	        
	        for (int x = 0; x < nc; ++x) {
	            for (int y = 1; y < nc; ++y) {
	                if (copy[y-1].getModel().compareTo(copy[y].getModel()) > 0) {
	                    temp = copy[y-1];
	                    copy[y-1] = copy[y];
	                    copy[y] = temp;
	                }
	            }
	        }
	        
	        displaySorted(copy);
	    }
	    
	    public void sortYear() {
	        Car temp = new Car();
	        Car [] copy = Arrays.copyOf(cars, nc);
	        
	        for (int x = 0; x < nc; ++x) {
	            for (int y = 1; y < nc; ++y) {
	                if (copy[y-1].getYear() > copy[y].getYear()) {
	                    temp = copy[y-1];
	                    copy[y-1] = copy[y];
	                    copy[y] = temp;
	                }
	            }
	        }
	        
	        displaySorted(copy);
	    }
	    
	    public void sortMile() {
	        Car temp = new Car();
	        Car [] copy = Arrays.copyOf(cars, nc);
	        
	        for (int x = 0; x < nc; ++x) {
	            for (int y = 1; y < nc; ++y) {
	                if (copy[y-1].getMile() > copy[y].getMile()) {
	                    temp = copy[y-1];
	                    copy[y-1] = copy[y];
	                    copy[y] = temp;
	                }
	            }
	        }
	        
	        displaySorted(copy);
	    }
	    
	    public void sortPrice() {
	        Car temp = new Car();
	        Car [] copy = Arrays.copyOf(cars, nc);
	        
	        for (int x = 0; x < nc; ++x) {
	            for (int y = 1; y < nc; ++y) {
	                if (copy[y-1].getPrice() > copy[y].getPrice()) {
	                    temp = copy[y-1];
	                    copy[y-1] = copy[y];
	                    copy[y] = temp;
	                }
	            }
	        }
	        
	        displaySorted(copy);
	    }
	    
	    public void sortColor() {
	        Car temp = new Car();
	        Car [] copy = Arrays.copyOf(cars, nc);
	        
	        String c1;
	        String c2;
	        
	        for (int x = 0; x < nc; ++x) {
	            for (int y = 1; y < nc; ++y) {
	                if (cars[y-1].getColor() < cars[y].getColor()) {
	                    temp = cars[y-1];
	                    cars[y-1] = cars[y];
	                    cars[y] = temp;
	                }
	            }
	        }
	        
	        displaySorted(copy);
	    }
	    
	    public void addCar() {
	        Car newEntry = new Car();
	        String bn;
	        Scanner in = new Scanner(System.in);
	        System.out.print("VIN: ");
	        newEntry.setVin(in.next());
	        System.out.print("Brand: ");
	        newEntry.setBrand(in.next());
	        System.out.print("Model: ");
	        newEntry.setModel(in.next());
	        System.out.print("Year: ");
	        newEntry.setYear(in.nextInt());
	        System.out.print("Mile: ");
	        newEntry.setMile(in.nextInt());
	        System.out.print("Price: ");
	        newEntry.setPrice(in.nextDouble());
	        System.out.print("Color: ");
	        newEntry.setColor(in.next().charAt(0));
	        System.out.print("Brand new: ");
	        bn = in.next();
	        if (bn.equals("Y") || bn.equals("y"))
	            newEntry.setBrandnew(true);
	        else
	            newEntry.setBrandnew(false);
	        nc++;
	        Car[] temp = new Car[nc];
	        for (int x = 0; x < nc-1; x++) {
	            temp[x] = cars[x];
	        }
	        temp[nc-1] = newEntry;
	        cars = temp;
	    }
	    
	    public void deleteCar() {
	        displayCars();
	        String v;
	        boolean flag = false;
	        int ind = -1;
	        Scanner in = new Scanner(System.in);
	        System.out.print("Please input VIN: ");
	        v = in.next();
	        Car[] temp = new Car[nc-1];
	        for (int x = 0; x < nc; ++x) {
	            if (v.compareTo(cars[x].getVin()) == 0) {
	                ind = x;
	                break;
	            }
	        }
	        
	        if (ind == -1) {
	            System.out.println("VIN not found");
	            return;
	        }
	        else {
	            
	            for (int x = 0; x < nc; ++x) {
	                if (x != ind && flag == false) {
	                    temp[x] = cars[x];
	                }
	                if (x == ind) {
	                    temp[x] = cars[x+1];
	                    flag = true;
	                }
	                if (x != ind && flag == true) {
	                    temp[x-1] = cars[x];
	                }
	            }
	        }
	        nc--;
	        cars = temp;
	    }
	    
	    public void updateCar(int usrChoice) {
	        String usrVIN;
	        int ind = -1;
	        Scanner in = new Scanner(System.in);
	        System.out.print("Please input VIN: ");
	        usrVIN = in.next();
	        
	        for (int x = 0; x < nc; ++x) {
	            if (usrVIN.compareTo(cars[x].getVin()) == 0) {
	                ind = x;
	            }
	        }
	        
	        if (ind == -1) {
	            System.out.println("VIN not found");
	            return;
	        }
	        
	        String update;
	        if (usrChoice == 1) {
	            System.out.print("Please input brand: ");
	            update = in.next();
	            cars[ind].setBrand(update);
	        }
	        else if (usrChoice == 2) {
	            System.out.print("Please input model: ");
	            update = in.next();
	            cars[ind].setModel(update);
	        }
	        else if (usrChoice == 3) {
	            System.out.print("Please input year: ");
	            update = in.next();
	            cars[ind].setYear(Integer.parseInt(update));
	        }
	        else if (usrChoice == 4) {
	            System.out.print("Please input mileage: ");
	            update = in.next();
	            cars[ind].setMile(Integer.parseInt(update));
	        }
	        else if (usrChoice == 5) {
	            System.out.print("Please input price: ");
	            update = in.next();
	            cars[ind].setPrice(Double.parseDouble(update));
	        }
	        else if (usrChoice == 6) {
	            System.out.print("Please input color: ");
	            update = in.next();
	            cars[ind].setColor(update.charAt(0));
	        }
	        else {
	            System.out.println("Incorrect choice");
	            return;
	        }
	    }
	    
	    public void updateInventoryFile(String fn) throws IOException {
	        FileWriter fw_IV = new FileWriter(fn, false);
	        PrintWriter outF_IV = new PrintWriter(fw_IV);
	        
	        for (int x = 0; x < nc; ++x) {
	            outF_IV.print(cars[x].getVin() + "/" + cars[x].getBrand() + "/" + cars[x].getModel() + "/" 
	                    + cars[x].getYear()+ "/" + cars[x].getMile() + "/" + cars[x].getPrice() + "/" + cars[x].getColor() + "/");
	            if (cars[x].getBrandnew()) {
	                outF_IV.println("Y");
	            }
	            else {
	                outF_IV.println("N");
	            }
	        }
	        
	        fw_IV.close();
	        outF_IV.close();
	    }
	    
	}
}
