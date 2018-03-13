import java.util.Scanner;

public class program2 {
	    public static void main(String[] args) {
	        
	        Scanner sc = new Scanner(System.in);
	        int tc,j,city,i,minGas;
	        int ans=0, ans1 = 0, ans2 = 0, ans3 = 0, ans4 = 0, ans5 = 0;
	        int ans6 = 0, ans7 =0, ans8 = 0, ans9 =0;
	        
	        System.out.println("Input:");
	        tc = sc.nextInt();
	        
	        for(j=0;j<tc;j++)
	        {
	            city = sc.nextInt();
	            
	            int [] dist = new int[city];
	            int [] gas = new int[city+1];
	            
	            for ( i = 0; i < city-1; i++)
	                dist[i] = sc.nextInt();
	            
	            for ( i = 0; i < city; i++)
	                gas[i] = sc.nextInt();
	            
	            minGas = gas[0];
	            if (j == 0)
	                ans = dist[0]*minGas;
	            if (j == 1)
	                ans1 = dist[0]*minGas;
	            if (j == 2)
	                ans2 = dist[0]*minGas;
	            if (j == 3)
	                ans3 = dist[0]*minGas;
	            if (j == 4)
	                ans4 = dist[0]*minGas;
	            if (j == 5)
	                ans5 = dist[0]*minGas;
	            if (j == 6)
	                ans6 = dist[0]*minGas;
	            if (j == 7)
	                ans7 = dist[0]*minGas;
	            if (j == 8)
	                ans8 = dist[0]*minGas;
	            if (j == 9)
	                ans9 = dist[0]*minGas;
	            
	            for(i=1;i<city;i++)
	            {
	                if(gas[i]<minGas)
	                    minGas=gas[i];
	                
	                if (j == 0)
	                    ans = ans + minGas * dist[i];
	                else if (j == 1)
	                    ans1 = ans1 + minGas * dist[i];
	                else if (j == 2)
	                    ans2 = ans2 + minGas * dist[i];
	                else if (j == 3)
	                    ans3 = ans3 + minGas * dist[i];
	                else if (j == 4)
	                    ans4 = ans4 + minGas * dist[i];
	                else if (j == 5)
	                    ans5 = ans5 + minGas * dist[i];
	                else if (j == 6)
	                    ans6 = ans6 + minGas * dist[i];
	                else if (j == 7)
	                    ans7 = ans7 + minGas * dist[i];
	                else if (j == 8)
	                    ans8 = ans8 + minGas * dist[i];
	                else
	                    ans9 = ans9 + minGas * dist[i];
	            }
	            sc.nextLine();
	        }
	        System.out.println("Output:");
	        
	        if (tc == 1)
	            System.out.println(ans);
	        else if (tc == 2)
	        {
	            System.out.println(ans);
	            System.out.println(ans1);
	        }
	        else if (tc == 3)
	        {
	            System.out.println(ans);
	            System.out.println(ans1);
	            System.out.println(ans2);
	        }
	        else if (tc == 4)
	        {
	            System.out.println(ans);
	            System.out.println(ans1);
	            System.out.println(ans2);
	            System.out.println(ans3);
	        }
	    }
}