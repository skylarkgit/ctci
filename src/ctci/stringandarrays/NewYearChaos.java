package ctci.stringandarrays;
// https://www.hackerrank.com/challenges/new-year-chaos/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
// Problem: Number of items greater than the element at i for all i: 0->n, best complexity would be O(nlogn)

import java.util.Scanner;

public class NewYearChaos {

    // Complete the minimumBribes function below.
	// 1 2 3 4 5 6 7 8
	// 1 2 5 3 7 8 6 4
//	Bribed
	// 5 - 2
	// 7 - 2
	// 8 - 2
	// 6 - 1
//	Bribed By
	// 3 - 1
	// 6 - 2
	// 4 - 4
	static void minimumBribes(int[] q) {
        int bribes = 0;
        for (int i = 1; i<=q.length; i++) {
            int item = q[i-1];
            int dist = item - i;
            if (dist > 2) {
                System.out.println("Too chaotic");
                return;
            }
            int j = i-1;
            int to = Math.max(item - 2, 0);
            while(j-- > to) {
            	bribes += (q[j] > item ? 1 : 0);
            }
        }
        System.out.println(bribes);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}

