package solutions.strings;
import java.util.Arrays;
public class StringSolutions {
    
    public static void main(String[] args){

    }

    // 1

    public static boolean isAnagram(final String s, final String t) {
        

        if (s.length() != t.length()) return false;
        
        final char[] letterboard = new char[256];
        final char[] cleared = new char[256];
        
        for (final char elt : s.toCharArray()) {
            letterboard[elt]++;
        }
        
        for(final char elt: t.toCharArray()) {
            letterboard[elt]--;
        }
        
        return Arrays.equals(letterboard, cleared);
    }

    //2

    /**
     * Given aab -> 2A1B
     * 
     * do not count dupes gt 9
     *  (12 'a's) aaaaaaaaaaa -> 9A3A
     * 
     * 
     */
    public String runLengthEncoding(String string) {
		StringBuilder sb = new StringBuilder();
		char[] letters = string.toCharArray();
		int left = 0;
		int right = 0;
		int len = letters.length;
		
		while (left < len){
			char curr = letters[left];
			while (right < len && right - left + 1 < 10 && letters[right] == curr ){
				right++;
			}
			
			sb.append(right - left);
			sb.append(curr);
			left = right;
		}
		
    return sb.toString();
	}
}