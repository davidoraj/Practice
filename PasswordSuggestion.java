import java.util.*;

public class PasswordSuggestion
{
	public ArrayList<String> getPasswords(String pwd, Map<Character, Character> charMap)
	{
		ArrayList<String> passwords = new ArrayList<String>();
		passwords.add(pwd);
		int len = pwd.length();

		for(int k=0; k<passwords.size(); k++)
		{
			String pass = passwords.get(k);
			for(int i=0; i<len; i++)
			{
				StringBuilder p = new StringBuilder(pass);

				Character c = p.charAt(i);
				if(charMap.containsKey(c))
				{
					p.setCharAt(i, charMap.get(c));
					if(!passwords.contains(p.toString()))
					{
						passwords.add(p.toString());
					}
				}
			}
		}

		return passwords;
	}

	public static void main(String args[])
	{
		Map<Character, Character> charMap = new HashMap<Character, Character>()
		{{
			put('i','!');
			put('a','@');
			put('s','$');
			put('o','0');
			put('E','3');
			put('l','1');
		}};

		PasswordSuggestion ps = new PasswordSuggestion();
		ArrayList<String> passwords = ps.getPasswords("lovethelord", charMap);
		System.out.println(passwords);
		System.out.println("Size: " + passwords.size());
	}
}
