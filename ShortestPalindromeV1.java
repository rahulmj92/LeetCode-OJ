import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class ShortestPalindromeV1
{
	public static String shortestPalindrome(String original) {
        
        if(original.length() == 0 || original.length() == 1) {
            return original;
        }
        
        if(checkPalindrome(original)) {
            return original;
        }
        
        String reverse = new StringBuffer(original).reverse().toString();
       
        int start = 0;
        int end = original.length();
        while(((original.substring(0,end)).compareTo(reverse.substring(start))) != 0) {
            start++;
            end--;
        }
        
        if(start==0){
            return original;
        }
        else {
            return reverse.substring(0,start).concat(original);
        }
    }
    
    public static boolean checkPalindrome(String inputString) {
        int length  = inputString.length();
        int i, begin, end, middle;
     
        begin  = 0;
        end    = length - 1;
        middle = (begin + end)/2;
     
        for (i = begin; i <= middle; i++) {
          if (inputString.charAt(begin) == inputString.charAt(end)) {
            begin++;
            end--;
          }
          else {
            break;
          }
        }
        if (i == middle + 1) {
          return true;
        }
        else {
          return false;
        } 	
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		System.out.println(shortestPalindrome(new String(""ababababa")));
	}
}
