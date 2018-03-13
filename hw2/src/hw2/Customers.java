package hw2;
import java.io.*;
import java.util.Scanner;

public class Customers {
	    
	    int nm;
	    
	    Member [] members;
	    
	    public Customers(String fn) throws IOException {
	        File inF_CU = new File(fn);
	        Scanner s_Count = new Scanner(inF_CU);
	        Scanner s_CU = new Scanner(inF_CU);
	        
	        nm = 0;
	        
	        while (s_Count.hasNext()) {
	            String line;
	            line = s_Count.next();
	         
	            nm++;
	        }
	       
	        members = new Member[nm];
	        
	        for (int x = 0; x < nm; ++x)
	            members[x] = new Member();
	        
	        int y = 0;
	        
	        while (s_CU.hasNext()) {
	            String line;
	            
	            line = s_CU.next();
	            
	            String[] result = line.split("/");
	            
	            for (int x = 0; x < result.length; x++)
	            {
	                if (x == 0)
	                    members[y].setID(result[x]);
	                else if (x == 1)
	                    members[y].setPW(result[x]);
	                else if (x == 2)
	                    members[y].setFN(result[x]);
	                else if (x == 3)
	                    members[y].setLN(result[x]);
	                else if (x == 4)
	                    members[y].setE(result[x]);
	            }
	            y++;
	        }
	        s_Count.close();
	        s_CU.close();
	    }
	    
	    public void displayCustomers() {
	        
	        System.out.printf("%-12s %-12s %-12s %-12s %-12s\n", "Id", "Password", "FirstName", "LastName", "Email");
	        for (int x = 0; x < nm; ++x) {
	            System.out.printf("%-12s %-12s %-12s %-12s %-12s\n", members[x].getID(), members[x].getPW(), members[x].getFN(), members[x].getLN()
	                    , members[x].getE());
	        }
	        
	    }
	    
	    public int findUser(String usrID, String usrPass) {
	        
	        for (int x = 0; x < nm; ++x) {
	            if (usrID.equals(members[x].getID())) {
	                
	                if (x == 0 && usrPass.equals(members[x].getPW()))
	                    return 1;
	                else if (x != 0 && usrPass.equals(members[x].getPW()))
	                    return 2;
	                else if (!usrPass.equals(members[x].getPW()))
	                    return 0;
	                else
	                    return -1;
	            }
	        }
	        
	        return 0;
	    }
	    
	    public void adminName() {
	        System.out.println("Welcome back " + members[0].getFN() + " " + members[0].getLN());
	    }
	    
	    public void usrName(String usrID) {
	        
	        for (int x = 0; x < nm; ++x) {
	            if (usrID.equals(members[x].getID())) {
	                System.out.println("Welcome back " + members[x].getFN() + " " + members[x].getLN());
	                return;
	            }
	        }
	    }
	    
	    public void addUser() {
	        Member newEntry = new Member();
	        Scanner in = new Scanner(System.in);
	        System.out.print("Please input user id: ");
	        newEntry.setID(in.next());
	        System.out.print("Please input user password: ");
	        newEntry.setPW(in.next());
	        System.out.print("Please input your first name: ");
	        newEntry.setFN(in.next());
	        System.out.print("Please input your last name: ");
	        newEntry.setLN(in.next());
	        System.out.print("Please input your email: ");
	        newEntry.setE(in.next());
	        nm++;
	        Member[] temp = new Member[nm];
	        for (int x = 0; x < nm-1; x++) {
	            temp[x] = members[x];
	        }
	        temp[nm-1] = newEntry;
	        members = temp;
	    }
	    
	    public void deleteUser() {
	        displayCustomers();
	        String id;
	        boolean flag = false;
	        int ind = -1;
	        Scanner in = new Scanner(System.in);
	        System.out.print("Please input ID: ");
	        id = in.next();
	        Member[] temp = new Member[nm-1];
	        for (int x = 0; x < nm; ++x) {
	            if (id.compareTo(members[x].getID()) == 0) {
	                ind = x;
	                break;
	            }
	        }
	        
	        if (ind == -1) {
	            System.out.println("ID not found");
	            return;
	        }
	        else {
	            
	            for (int x = 0; x < nm; ++x) {
	                if (x != ind && flag == false) {
	                    temp[x] = members[x];
	                }
	                if (x == ind) {
	                    temp[x] = members[x+1];
	                    flag = true;
	                }
	                if (x != ind && flag == true) {
	                    temp[x-1] = members[x];
	                }
	            }
	        }
	        nm--;
	        members = temp;
	        in.close();
	    }
	    
	    public void updateUser(int usrChoice) {
	        String usrID;
	        int ind = -1;
	        Scanner in = new Scanner(System.in);
	        System.out.print("Please input user id: ");
	        usrID = in.next();
	        
	        for (int x = 0; x < nm; ++x) {
	            if (usrID.compareTo(members[x].getID()) == 0) {
	                ind = x;
	            }
	        }
	        
	        if (ind == -1) {
	            System.out.println("ID not found");
	            return;
	        }
	        
	        String update;
	        if (usrChoice == 1) {
	            System.out.print("Please input new password: ");
	            update = in.next();
	            members[ind].setPW(update);
	        }
	        else if (usrChoice == 2) {
	            System.out.print("Please input new first name: ");
	            update = in.next();
	            members[ind].setFN(update);
	        }
	        else if (usrChoice == 3) {
	            System.out.print("Please input new last name: ");
	            update = in.next();
	            members[ind].setLN(update);
	        }
	        else if (usrChoice == 4) {
	            System.out.print("Please input new email: ");
	            update = in.next();
	            members[ind].setE(update);
	        }
	        else {
	            System.out.println("Incorrect choice");
	            return;
	        }
	    }
	    
	    public void updateCustomersFile(String fn) throws IOException {
	        FileWriter fw_CU = new FileWriter(fn, true);
	        PrintWriter outF_CU = new PrintWriter(fw_CU);
	        
	        for (int x = 0; x < nm; ++x) {
	            outF_CU.println(members[x].getID() + "/" + members[x].getPW() + "/" + members[x].getFN() + "/" 
	                    + members[x].getLN()+ "/" + members[x].getE());
	        }
	        fw_CU.close();
	        outF_CU.close();
	    }
	}  
}
