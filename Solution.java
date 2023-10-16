import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String number = "MMXXIII";
        System.out.println("Roman to Integer of " +number + " is "+ sol.romanToInt(number));
        System.out.println("Roman to Integer Version 1 of " +number + " is "+ sol.romanToIntV1(number));
    }
    public int romanToInt(String s) {
        Map<Character, Integer> lookupTable = new HashMap<>();
        lookupTable.put('I',1 );
        lookupTable.put('V', 5);
        lookupTable.put('X', 10);
        lookupTable.put('L', 50);
        lookupTable.put('C',100);
        lookupTable.put('D',500);
        lookupTable.put('M',1000);

        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            System.out.println("count: " + i +" Character: "+ s.charAt(i));
            for (Character key : lookupTable.keySet()) {
                if((s.charAt(i) == 'I' || s.charAt(i) == 'X' || s.charAt(i) == 'C') && (i + 1) < s.length()){
                    if(s.charAt(i) == 'I' && s.charAt(i+1) == 'V'){
                        sum += 4;
                        i++;
                        break;
                    }
                    if(s.charAt(i) == 'I' && s.charAt(i + 1) == 'X'){
                        sum += 9;
                        i++;
                        break;
                    }
                    if(s.charAt(i) == 'X' && s.charAt(i + 1) == 'L'){
                        sum += 40;
                        i++;
                        break;
                    }
                    if(s.charAt(i) == 'X' && s.charAt(i + 1) == 'C'){
                        sum += 90;
                        i++;
                        break;
                    }
                    if(s.charAt(i) == 'C' && s.charAt(i + 1) == 'D'){
                        sum += 400;
                        i++;
                        break;
                    }
                    if(s.charAt(i) == 'C' && s.charAt(i + 1) == 'M'){
                        sum += 900;
                        i++;
                        break;
                    }
                }
                if(s.charAt(i) == key){
                    System.out.println("sum = " + sum);
                    sum += lookupTable.get(key);
                }
            }
        }
        return sum;
    }

    public int romanToIntV1(String s){
        if (s.length() == 0 || s == null) return 0;
        HashMap<Character, Integer> lookupTable = new HashMap<>();

        lookupTable.put('I', 1);
        lookupTable.put('V', 5);
        lookupTable.put('X', 10);
        lookupTable.put('L', 50);
        lookupTable.put('C', 100);
        lookupTable.put('D', 500);
        lookupTable.put('M', 1000);


        int sum = lookupTable.get(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int current = lookupTable.get(s.charAt(i));
            int previous = lookupTable.get(s.charAt(i - 1));
            if(current > previous){
                sum += current - 2 * previous;
            }else{
                sum += lookupTable.get(s.charAt(i));
            }
        }
        return sum;
    }
}
