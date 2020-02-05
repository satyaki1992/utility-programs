package self.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class NumberToBits {
	
	public static void main(final String[] args) throws Exception {
		
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int user_input;
		try {
			System.out.println("Kindly enter a numeric value..");
			user_input = Integer.parseInt(br.readLine().trim());
		} catch (final IOException e) {
			throw new Exception("Something went berserk");
		}
		catch (final NumberFormatException number_format) {
			throw new Exception("Sorry human, NOT a valid number");
		}
		
		System.out.println("voila --> "+getBitsFromNumber(user_input));
		
	}
	
	public static String getBitsFromNumber(int user_input) {
		
		int power=0;
		int sum_of_power=0;
		int val_remain;
		int i;
		String bits="";
		String temp;
		
		sum_of_power+=Math.pow(2, power);
		while(sum_of_power<user_input)
		{
			bits+="1";
			power++;
			sum_of_power+=Math.pow(2, power);
		}
		bits+="1";
		bits=bits.replace("1", "0");
		bits="1"+bits.substring(1,bits.length());
		sum_of_power=(int) Math.pow(2, power);
		//total amount remain to arrange bits
		val_remain=user_input-sum_of_power;
		for(i=power-1; val_remain>0; i--)
		{
			if((int) Math.pow(2, i)<=val_remain)
			{
				sum_of_power+=(int) Math.pow(2, i);
				val_remain=user_input-sum_of_power;
				temp=bits.substring(0, power-i)+"1"+bits.substring((power-i)+1, bits.length());
				bits="";
				bits=temp;
			}
		}
		
		return bits;
	}
	
}
