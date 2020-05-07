package string;

public class LongestPalindrome {

    /**
     * 暴力求解
     * @param s
     * @return
     */
    private static String longestPalindrome(String s) {
        String re = "";
        int max = 0;
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                String test = s.substring(i,j+1);
                if(isPalindrome(test)&&test.length()>max){
                    re = test;
                    max = test.length();
                }
            }
        }
        return re;
    }

    private static boolean isPalindrome(String s){
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(s.length()-i-1)){
                return false;
            }
        }
        return true;
    }
}
