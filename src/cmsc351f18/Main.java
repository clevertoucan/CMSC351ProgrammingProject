package cmsc351f18;

import java.util.Random;
import java.util.Scanner;

/**
 * Sample cmsc351f18.Main for you to test your class(es)
 * You don't need to submit this file
 */
public class Main {

	public static void main(String[] args) {

		PermutationGenerator p = new PermutationGenerator(new Random());
		int n = 300000000;
		MartianOracle m = new MartianOracle(n);
		int[] permutation = p.nextPermutation(n);
		for(int x : permutation){
			m.process(x);
		}
		System.out.println(
				n + "," + Heap.comparisons + "," + Heap.comparisons/(n*Math.log10(n)));
		Heap.comparisons = 0;

		/*
		// Create a scanner from stdin
		Scanner scanner = new Scanner(System.in);
		// First value is the total number of positive integers
		int totalSize = scanner.nextInt();
		// Create a cmsc351f18.MartianOracle
		cmsc351f18.MartianOracle oracle = new cmsc351f18.MartianOracle(totalSize);
		while(scanner.hasNext()) {
			// Read next value
			int value = scanner.nextInt();
			if(value == 0) {
				// Query
				System.out.println(oracle.query());
			}
			else {
				// Process
				oracle.process(value);
			}
		}
		scanner.close();
		*/
	}

}
