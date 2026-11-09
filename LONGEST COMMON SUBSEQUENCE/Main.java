//LONGEST COMMON SUBSEQUENCE
//-----------------------------------
//          RECURSSION  [topdown]
//-----------------------------------
import java.util.*;
class LongestCommonSubsequence{
    public int LCS(char[] array1 , char[] array2 , int length1 , int length2 ){
        if(length1 == 0 || length2 == 0){
            return 0;
        }
        else if(array1[length1 - 1] == array2[length2 - 1]){
            return 1 + LCS( array1 , array2 , length1-1 , length2-1);
        }
        else{
            return Math.max(LCS(array1 , array2 , length1, length2-1),LCS(array1 , array2 , length1-1, length2));
        }
    }
}

//LONGEST COMMON SUBSEQUENCE
//-----------------------------------
//          RECURSSION MEMORIZATION [topdown]
//-----------------------------------

class LongestCommonSubsequence_Memorization{
    int[][] memory;
    public void init(int a , int b){
        if(memory == null){
            memory = new int[a+1][b+1];
            for(int i = 1 ; i<=a ; i++){
                for(int j = 1 ; j<=b;j++){
                    memory[i][j] = -1;
                }
            }
        }
    }
    public int LCS(char[] array1 , char[] array2 , int length1 , int length2 ){
        init(length1,length2);
        if(length1 == 0 || length2 == 0){
            return memory[length1][length2] = 0;
        }
        else if(array1[length1 - 1] == array2[length2 - 1]){
            if(memory[length1-1][length2-1] == -1){
                memory[length1-1][length2-1] = LCS( array1 , array2 , length1-1 , length2-1);
            }
            return memory[length1][length2] = 1 + memory[length1-1][length2-1];
        }
        else{
            if(memory[length1][length2-1] == -1){
                memory[length1][length2-1] = LCS(array1 , array2 , length1, length2-1);
            }

            if(memory[length1-1][length2] == -1){
                memory[length1-1][length2] = LCS(array1 , array2 , length1-1, length2);
            }
            memory[length1][length2] = Math.max(memory[length1][length2-1],memory[length1-1][length2]);
            return memory[length1][length2];
        }

    }
}

//-----------------------------------
//           BOTTOM UP [tabulization]
//-----------------------------------

class LongestCommonSubsequence_BottomUp{
    public int LCS(char[] array1 , char[] array2 , int length1 , int length2 ){
        int[][] memory = new int[length1 + 1][length2 + 1];
        for(int i = 1 ; i < length1 + 1 ; i++){
            for(int j = 1 ; j < length2 + 1 ; j++){
                if(array1[i-1] == array2[j-1]){
                    memory[i][j] = 1 + memory[i-1][j-1];
                }
                else{
                    memory[i][j] = Math.max(memory[i-1][j],memory[i][j-1]);
                }
            }
        }
        return memory[length1][length2];
    }
}

public class Main{
    public static void main(String args[]){
        char[] input1 = "adgdhsjtrfscadgdhsjtrfscadgdhsjtrfscadgdhsjtrfscadgdhsjtrfscadgdhsjtrfsc".toCharArray();
        char[] input2 = "dgrtgdfvdsfbfdgrtgdfvdsfbfdgrtgdfvdsfbfdgrtgdfvdsfbfdgrtgdfvdsfbfdgrtgdfvdsfbf".toCharArray();


        // LongestCommonSubsequence method1 = new LongestCommonSubsequence();
        // System.out.println(method1.LCS(input1,input2,input1.length,input2.length));

        // LongestCommonSubsequence_Memorization method2 = new LongestCommonSubsequence_Memorization();
        // System.out.println(method2.LCS(input1,input2,input1.length,input2.length));

        LongestCommonSubsequence_BottomUp method3 = new LongestCommonSubsequence_BottomUp();
        System.out.println(method3.LCS(input1,input2,input1.length,input2.length));

    }
}