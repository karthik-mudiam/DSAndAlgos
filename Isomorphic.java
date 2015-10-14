
import java.util.HashMap;

public class Isomorphic {
	public static void main(String[] args) {
		String s1 = "overwriting";
		String s2 = "probability";
		if(s1.length() == s2.length()) {
			String code1 = isomorphic(s1);
			String code2 = isomorphic(s2);
			if(code1.equals(code2)) {
				System.out.println("Isomorphic");
			}else {
				System.out.println("Not Isomorphic");
			}
		} else {
			System.out.println("Not Isomorphic");
		}
 	}
	public static String isomorphic(String s1) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		if(s1 == null) {
			return "-1";
		}
		int count = 1;
		StringBuilder code = new StringBuilder("");
		for(int i=0; i<s1.length(); i++) {
			Character c1 = s1.charAt(i);
			if(map.containsKey(c1)) {
				Integer j = map.get(c1);
				code.append(j.toString());
			}
			else {
				map.put(c1, count);
				code.append(String.valueOf(count));
				count++;				
			}
		}
		return code.toString();
	}
}
