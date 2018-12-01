package cmsc351f18;

import java.util.Random;

public class PermutationGenerator {
	final private Random m_random;
	
	/**
	 * constructor. You should not modify this constructor
	 * @param random The random source
	 */
	PermutationGenerator(Random random) {
		m_random = random;
	}
	
	/**
	 * Generate a new random permutation of {1, 2, 3, ... , n}
	 * @param n The size of the permutation
	 * @return The new random permutation
	 */
	public int[] nextPermutation(int n) {
		int[] permutation = new int[n];
		for(int i = n-1; i > 0; i--){
			int j = 1 + m_random.nextInt(i + 1);
			permutation[i] = j;
		}
		return permutation;
	}
}
