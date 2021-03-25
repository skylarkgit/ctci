package ctci.dp;
// https://practice.geeksforgeeks.org/problems/path-in-matrix3805/1#

//{ Driver Code Starts
//Initial Template for Java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class GFG {
	public static void main(String args[]) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		while (t-- > 0) {
			int N = Integer.parseInt(in.readLine());
			String input_line[] = in.readLine().trim().split("\\s+");
			int Matrix[][] = new int[N][N];
			for (int i = 0; i < N * N; i++)
				Matrix[(i / N)][i % N] = Integer.parseInt(input_line[i]);

			MaxPathSum ob = new MaxPathSum();
			System.out.println(ob.maximumPath(N, Matrix));
		}
	}
}
//} Driver Code Ends

//User function Template for Java

class MaxPathSum {
	static int maximumPath(int N, int matrix[][]) {
		// for row n
		// max path = this path + max of prev 3 path
		// solution = max of last row
		int[][] dp = new int[N][N];
		int maxSum = 0;
		for (int i = 0; i < N; i++) { // for row i
			for (int j = 0; j < N; j++) { // cell i, j
				int cost = matrix[i][j];
				dp[i][j] = Math.max(dp[i][j], cost + getCost(i - 1, j - 1, dp, N));
				dp[i][j] = Math.max(dp[i][j], cost + getCost(i - 1, j, dp, N));
				dp[i][j] = Math.max(dp[i][j], cost + getCost(i - 1, j + 1, dp, N));
				maxSum = Math.max(dp[i][j], maxSum);
				// System.out.print(dp[i][j] + " ");
			}
			// System.out.println();
		}
		return maxSum;
	}

	static int getCost(int i, int j, int[][] matrix, int N) {
		return (i < N && j < N && i >= 0 && j >= 0) ? matrix[i][j] : 0;
	}
}