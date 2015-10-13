package other;

import java.util.*;

public class FirstRepeatingLetter {

	public static void main(String[] args) {
		System.out.println(find("asdfghjkasdfghjkl"));
	}

	private static Character find(String string) {

		Set<Character> set = new HashSet<Character>();
		for(int i=0; i<string.length(); i++){
			char temp = string.charAt(i);
			if(!set.contains(temp)){
				set.add(temp);
			}else{
				return temp;
			}
		}
		return null;
	}

}
