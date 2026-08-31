import java.util.*;
class Palandrome {
    public static boolean check(String S){
        int i = 0 ;
        int j = S.length()-1 ; 
        while(i<j){
            if(S.charAt(i)==S.charAt(j)){
                i++;
                j--;
            }
            else{
                return false;
            }
        }
        return true;
    }
}

class TwoSumSorted{
    public static int[] check(int[] input,int target){
        int i = 0 ;
        int j = input.length-1;
        while(i<j){
            if(input[i]+input[j]==target){
                return new int[]{i,j};
            }
            else if(input[i]+input[j]<target){
                i++;
            }
            else if(input[i]+input[j]>target){
                j--;
            }
        }
        return new int[]{};
    }
}

class ReverseString{
    public static String check(String S){
        char[] s=S.toCharArray();
        int i=0;
        int j = s.length-1;
        while(i<j){
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
        return new String(s);
    }
}


public class Main{
    public static void main(String args[]){
        // System.out.print(Palandrome.check("abcbag"));

        // for(int i : TwoSumSorted.check(new int[]{100,200,300,400,500,600,700,},1000)){
        //     System.out.print(i+" ");
        // }
        // System.out.print(ReverseString.check("i am Vinod"));
        for(int i : MergeSored.check(new int[] {1,2,3,4,5,6,7,8},new int[] {10,11,22,45,80})){}

    }
}