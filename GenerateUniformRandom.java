package chapter_5;

import java.util.Random;

public class GenerateUniformRandom {
	
	public static int uniformRandom(int max) {
		int i = 0;
		while ((1 << i) < max) {
			i++;
		}
		int result;
		do {
			result = 0;
			for (int j = 1; j <= i; j++) {
				/**** IMPORTANT ****/
				result = (result << 1) | zeroOneRandom();
			}
		} while (result > max);
		
		return result;
	}
	
	private static int zeroOneRandom() {
		return new Random().nextBoolean() ? 1 : 0;
	}
	
	
	public static void main(String[] args) {
		System.out.println(uniformRandom(10));
	}
	
}
