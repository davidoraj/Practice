public class BinaryToHexadecimal
{
	public String binaryToHexadecimal(String bin) throws ArrayIndexOutOfBoundsException
	{
		if(bin.isEmpty()) return "0";

		if( !bin.replace("1","").replace("0","").isEmpty() )
			return "Error!";

		String hexValue = "";

		int diff = bin.length() % 4;
		if(diff > 0)
		{
			for(int i=0; i<4-diff; i++)
			{
				bin = "0".concat(bin);
			}
		}
		
		System.out.println("  Updated bin = " + bin);
		
		int nibbleCount = bin.length() / 4;
		System.out.println("  NibbleCount = " + nibbleCount);
		for(int i=0; i<nibbleCount; i++)
		{
			// … 0,1,2,3, 4,5,6,7
			hexValue = hexValue + nibbleToHex(bin.substring(i*4, i*4 + 4));
		}
		
		return hexValue;
	}

	private String nibbleToHex(String nibble) throws NumberFormatException
	{
		String hexVal = "";
		
		if(nibble.isEmpty()) return "";
		else
		{
			// 8, 4, 2, 1
			int value = Character.getNumericValue(nibble.charAt(0)) * 8 + Character.getNumericValue(nibble.charAt(1)) * 
				4 + Character.getNumericValue(nibble.charAt(2)) * 2 + Character.getNumericValue(nibble.charAt(3));
			System.out.println("  Nibble hex value: " + Integer.toString(value));
			if(value < 10)
				hexVal = Integer.toString(value);
			else if (value < 16)
			{
				// return asciiValue(value + ALPHABET_CAPS);
				switch(value)
				{
					case 10: hexVal = "A"; break;
					case 11: hexVal = "B"; break;
					case 12: hexVal = "C"; break;
					case 13: hexVal = "D"; break;
					case 14: hexVal = "E"; break;
					case 15: hexVal = "F"; break;
				}
			}
			else
			{
				hexVal = "Error!";
			}
		}
		return hexVal;
	}
	
	public static void main(String args[])
	{
		BinaryToHexadecimal bth = new BinaryToHexadecimal();
		System.out.println("Hex Value: " +  bth.binaryToHexadecimal("1"));
		System.out.println("Hex Value: " +  bth.binaryToHexadecimal(""));
		System.out.println("Hex Value: " +  bth.binaryToHexadecimal("0"));
		System.out.println("Hex Value: " +  bth.binaryToHexadecimal("1111"));
		System.out.println("Hex Value: " +  bth.binaryToHexadecimal("111011"));
		System.out.println("Hex Value: " +  bth.binaryToHexadecimal("1110A11"));
		System.out.println("Hex Value: " +  bth.binaryToHexadecimal("11210A11"));
		System.out.println("Hex Value: " +  bth.binaryToHexadecimal("1113311"));
		System.out.println("Hex Value: " +  bth.binaryToHexadecimal("1111000011110000111100001"));
	}
}
