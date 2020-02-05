package self.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class NumberToWords {
	
	static String initial_digit[] = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve"};
	static String pre_word[] = {"Twenty", "Thirty", "Fourty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	
	public static void main(String ar[]) throws IOException {
		final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		final int input;
		
		System.out.println("Enter the number..");
		try {
			input = Integer.parseInt(bufferedReader.readLine());
		} catch (final IOException | NumberFormatException exception) {
			throw new IOException("\n **** \n Something seems fishy. Please run the program again.. \n ****");
		}
		
		System.out.println(getWordForNumber(input));
		
	}
	
	public static String getWordForNumber(int input) {
		
		int first_num;
		int second_num;
		int len;
		int temp;
		String word = "";
		final NumberToWords ntw = new NumberToWords();
		
		len = String.valueOf(input).length();
		
		if (len == 1) {
			System.out.println(initial_digit[input]);
		} else if (len == 2) {
			if (input >= 10 && input <= 12) {
				System.out.println(initial_digit[input]);
			} else if (input >= 13 && input <= 19) {
				second_num = input % 10;
				word = initial_digit[second_num] + "teen";
			} else word += ntw.two_digits(input);
			
		} else if (len == 3) {
			first_num = input / 100;
			word += ntw.three_digits(input);
			input = input - (first_num * 100);
			word += ntw.two_digits(input);
		} else if (len == 4) {
			first_num = input / 1000;
			word += initial_digit[first_num] + " thousand ";
			input = input - (first_num * 1000);
			word += ntw.three_digits(input);
			second_num = input / 100;
			input = input - (second_num * 100);
			word += ntw.two_digits(input);
		} else if (len == 5) {
			temp = input / 1000;
			word += ntw.two_digits(temp);
			word += " thousand ";
			input = input - (temp * 1000);
			word += ntw.three_digits(input);
			second_num = input / 100;
			input = input - (second_num * 100);
			word += ntw.two_digits(input);
		} else if (len == 6) {
			first_num = input / 100000;
			word += initial_digit[first_num] + " lakh ";
			input = input - (first_num * 100000);
			temp = input / 1000;
			if (temp > 0) {
				word += ntw.two_digits(temp);
				word += " thousand ";
			}
			input = input - (temp * 1000);
			word += ntw.three_digits(input);
			second_num = input / 100;
			input = input - (second_num * 100);
			word += ntw.two_digits(input);
		} else if (len == 7) {
			temp = input / 100000;
			word += ntw.two_digits(temp);
			word += " lakh ";
			input = input - (temp * 100000);
			temp = input / 1000;
			if (temp > 0) {
				word += ntw.two_digits(temp);
				word += " thousand ";
			}
			input = input - (temp * 1000);
			word += ntw.three_digits(input);
			second_num = input / 100;
			input = input - (second_num * 100);
			word += ntw.two_digits(input);
		} else if (len == 8) {
			first_num = input / 10000000;
			word += initial_digit[first_num] + " crore ";
			input = input - (first_num * 10000000);
			temp = input / 100000;
			if (temp > 0) {
				word += ntw.two_digits(temp);
				word += " lakh ";
			}
			input = input - (temp * 100000);
			temp = input / 1000;
			if (temp > 0) {
				word += ntw.two_digits(temp);
				word += " thousand ";
			}
			input = input - (temp * 1000);
			word += ntw.three_digits(input);
			second_num = input / 100;
			input = input - (second_num * 100);
			word += ntw.two_digits(input);
		} else if (len == 9) {
			temp = input / 10000000;
			word += ntw.two_digits(temp);
			word += " crore ";
			input = input - (temp * 10000000);
			temp = input / 100000;
			if (temp > 0) {
				word += ntw.two_digits(temp);
				word += " lakh ";
			}
			input = input - (temp * 100000);
			temp = input / 1000;
			if (temp > 0) {
				word += ntw.two_digits(temp);
				word += " thousand ";
			}
			input = input - (temp * 1000);
			word += ntw.three_digits(input);
			second_num = input / 100;
			input = input - (second_num * 100);
			word += ntw.two_digits(input);
		}
		return word;
	}
	
	String two_digits(int input) {
		int first_num, second_num;
		String word = "";
		first_num = input / 10;
		if (input >= 10 && input <= 12) {
			word += initial_digit[input];
		} else if (input >= 13 && input <= 19) {
			second_num = input % 10;
			word = initial_digit[second_num] + "teen";
		} else if (input >= 20) {
			word += pre_word[first_num - 2];
			second_num = input % 10;
			if (second_num > 0)
				word += " " + initial_digit[second_num];
		}
		return word;
	}
	
	String three_digits(int input) {
		String word = "";
		int first_num;
		first_num = input / 100;
		if (first_num > 0)
			word += initial_digit[first_num] + " hundred ";
		return word;
	}
	
}
