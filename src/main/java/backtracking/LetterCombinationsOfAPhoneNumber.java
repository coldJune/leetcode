package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {

    public static void main(String[] args) {
        System.out.println(letterCombinations(""));

    }

    private static List<String> letterCombinations(String digits) {
         Map<String, String> digit2character = new HashMap<>();
         digit2character.put("2","abc");
        digit2character.put("3","def");
        digit2character.put("4","ghi");
        digit2character.put("5","jkl");
        digit2character.put("6","mno");
        digit2character.put("7","pqrs");
        digit2character.put("8","tuv");
        digit2character.put("9","wxyz");

        List<String> output = new ArrayList<>();

        if(digits == null||digits.length()==0){
            return output;
        }
        backtracking("",digits,output,digit2character);
        return output;
    }
    
    private static void backtracking(String combination,String next_digit, List<String> output, Map<String,String> digit2character){
        if(next_digit.length() == 0){//沒有字符
            output.add(combination);
        }else{//仍然有字符
            String digit = next_digit.substring(0,1);
            String letters = digit2character.get(digit);
            for(int i=0;i<letters.length();i++){
                String letter = digit2character.get(digit).substring(i,i+1);
                //将当前的字母追加在后面，然后继续遍历下一个字母
                backtracking(combination+letter,next_digit.substring(1),output,digit2character);
            }
        }
    }
}
