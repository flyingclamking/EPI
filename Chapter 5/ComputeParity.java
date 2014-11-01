package chapter_5;

public class ComputeParity {
	
	public static int computeParity(long num) {
		int result = 0;
		while (num != 0) {
			result++;
			num = num & (num - 1);
		}
		
		return (result & 0x0001) == 1 ? 1 : 0;
	}
	
	public static void main(String[] args) {
		//136 --> 10001000
		System.out.println(computeParity(136));
	}
	
}
