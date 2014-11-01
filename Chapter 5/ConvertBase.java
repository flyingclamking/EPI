package chapter_5;

public class ConvertBase {
	
	//we can assume all the input is valid
	public static String convertBase(int b1, String x, int b2) {
		
		if (x.equals("0")) {
			return "0";
		}
		
		StringBuilder result = new StringBuilder();
		int temp = 0;
		boolean sign = x.startsWith("-");
		
		//convert to 10 base
		for (int i = (sign ? 1 : 0); i < x.length(); i++) {
			temp *= b1;
			temp += Character.isDigit(x.charAt(i)) ? x.charAt(i) - '0' : x.charAt(i) - 'A' + 10;
		}
		
		while (temp != 0) {
			int r = temp % b2;
			result.append((char) (r >= 10 ? 'A' + r - 10 : r + '0'));
			temp /= b2;
		}
		
		if (sign) {
			result.append("-");
		}
		
		return result.reverse().toString();
	}
	
}
