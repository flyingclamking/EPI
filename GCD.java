package chapter_5;

public class GCD {
	
	public static long gcd(long x, long y) {
		if (x == 0) {
			return y;
		} else if (y == 0) {
			return x;
		} else if ((x & 1) == 0 && (y & 1) == 0) {	//both even
			return gcd(x >> 1, y >> 1) << 1;
		} else if ((x & 1) == 0 && (y & 1) == 1) {	//y is odd
			return gcd(x >> 1, y);
		} else if ((x & 1) == 1 && (y & 1) == 0) {	//x is odd
			return gcd(x, y >> 1);
		} else if ((x & 1) == 1 && (y & 1) == 1 && x > y) {	//both odd and x > y
			return gcd(x - y, y);
		}
		
		return gcd(x, y - x);
	}
	
	public static void main(String[] args) {
		System.out.println(gcd(24, 300));
	}
	
}
