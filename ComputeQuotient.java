package chapter_5;

public class ComputeQuotient {
	
	public static int computeQuotient(int x, int y) {
		if (y == 0) {
			throw new ArithmeticException();
		}
		
		int result = 0;
		boolean sign = (x > 0 && y > 0) || (x < 0 && y < 0);
		x = Math.abs(x);
		y = Math.abs(y);
		while (x >= y) {
			int i = 0;
			while (x >= (y << i)) {
				i++;
			}
			x -= (y << i - 1);
			result += 1 << (i - 1);
		}
		
		return sign ? result : -result;
	}
	
	public static void main(String[] args) {
		System.out.println(computeQuotient(11111, 1));
	}
	
}
