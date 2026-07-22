import java.util.Arrays;

class Solution {
    public int lengthOfLastWord(String s) {
        Sting[] data=s.split(" ");
        return data[data.length - 1].length();
    }
}
public class LengthOfLastWord {
    public static void main (String[] args) {
        String s="Hello World";
        Solution sol=new Solution();
        System.out.println(sol.lengthOfLastWord(s));
    }
}