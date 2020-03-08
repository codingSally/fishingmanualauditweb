package leetTest;

import java.util.Vector;

/**
 * @description  Integer to Roman
 * @author xueshangling
 * @date 2019-04-02
 * Symbol       Value
	I             1
	V             5
	X             10
	L             50
	C             100
	D             500
	M             1000
	
Input is guaranteed to be within the range from 1 to 3999
 */
public class demo12 {

	public static void main(String[] args) {
		
		int test = 3;
		System.out.println(intToRoman2(test));

	}
	
    private static String intToRoman(int num) {
        
    	if(num < 1 || num > 3999){
    		return "";
    	}
    	String ret = "";
    	int[] val = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
    	String[] rom = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    	
    	for(int i = 0; i < val.length; ++i){
    		while(num >= val[i]){
    			num = num - val[i];
    			ret = ret + rom[i];
    		}
    	}
    	return ret;
    }
    
	private static String intToRoman2(int num) {
		
		String[] rom1 = {"", "M", "MM", "MMM"};
		String[] rom2 = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
		String[] rom3 = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
		String[] rom4 = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
		
		return rom1[num/1000] + rom2[(num%1000) /100] + rom3[(num%100) /10] + rom4[(num%10)];
	}
}
