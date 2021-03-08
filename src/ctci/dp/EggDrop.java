package ctci.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EggDrop 
{
	
	public static void main (String[] args) throws IOException  {
	    
	    //reading input using BufferedReader class
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//reading total testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    
		    //reading number of eggs and floors
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    int n = Integer.parseInt(inputLine[0]);
		    int k = Integer.parseInt(inputLine[1]);
		    
		    //calling eggDrop() method of class
		    //EggDrop
		    System.out.println(EggDrop.eggDrop(n, k));
		}
	}

    static int eggDrop(int n, int k) 
	{
	    // Your code here
        // Base case:: 
        // x egg 1 floor attempts = 1
        // 1 egg x floor attempts = x
        
        // x eggs and k floors
        // find f such that 
        // 1 + min(max((x,k-f), (x-1, f-1)))   f C (1 - k)
        
        int[][] drops = new int[11][51];
        
        for (int f = 1; f <= k; f++) {
            drops[1][f] = f;
            drops[0][f] = Integer.MAX_VALUE;
        }
        for (int e = 1; e <= n; e++) {
            drops[e][0] = 0;
        }
        drops[0][0] = 1;
        
        for (int e = 2; e <= n; e++) {
            for (int j = 1; j <= k; j++) {
                int minAttempts = Integer.MAX_VALUE;
                for (int f = 1; f <= j; f++) {
                    // System.out.println("     " + e + " - " + j + " -" + f + "-> (" + drops[e][j-f] + ", " + drops[e-1][f-1] + ")");
                    minAttempts = Math.min(minAttempts, Math.max(drops[e][f-1], drops[e-1][f-1]));
                }
                drops[e][j] = minAttempts + 1;
                // System.out.println(e + " - " + j + " -> " + drops[e][j]);
            }
        }
        
        return drops[n][k];
	}
}