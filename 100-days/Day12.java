

// DAY 12
public class Day12 {
	// Defanging an IP Address
	class q1 {
		public String defangIPaddr(String address) {
			StringBuilder sb = new StringBuilder();
			for (int i=0; i< address.length(); i++) {
				if (address.charAt(i) == '.') {
					sb.append("[.]");
				} else 
					sb.append(address.charAt(i));
			}
			return sb.toString();
		}
	}

	// Reverse Only Letters
	class q2 {
		public String reverseOnlyLetters(String s) {
			int i=0, j =s.length()-1;
			char[] str = s.toCharArray();
			while (i < j) {
				while (i<s.length()-1 && !isAlphabhet(str[i]))
					i++;
				while (j>0 && !isAlphabhet(str[j]))
					j--;
				
				if (i<j) {
					char temp = str[i];
					str[i] =  str[j];
					 str[j] = temp;
				}
				i++;
				j--;
			}
			return new String(str);
		}
		
		public boolean isAlphabhet(char ch) {
			return (ch>='A' && ch <='Z' )||(ch>='a' && ch <='z' );
		}
	}

	// Reverse Vowels of a String
	// Length of Last Word
	// Add Strings
	class q5 {
		public String addStrings(String num1, String num2) {
			StringBuilder sb = new StringBuilder();
			int i = num1.length()-1, j = num2.length()-1;
			int carry = 0, sum = 0;
			while (i>=0 || j>=0) {
				int a = (i>=0) ? num1.charAt(i) - '0' : 0;
				int b = (j>=0) ? num2.charAt(j) - '0' : 0;
				sum = (a+b+ carry)%10;
				carry = (a+b+carry)/10;
				sb.append(sum);
				i--; j--;
			}
			if (carry > 0) 
				sb.append(carry);
			sb.reverse();
			return sb.toString();
		}
	}
	// Fizz Buzz	
}
