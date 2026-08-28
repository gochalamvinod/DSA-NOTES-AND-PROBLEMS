import java.util.*;

/* IMPORTANT NOTE 
RECURSION IS WORKS LIKE STACK (FIRST IN LAST OUT )
+-------------------------------------------------------+
| PHASES OF EXECUTION FOR output(4)                      |
+-------------------------------------------------------+
|                                                       |
|  [PHASE 1: WINDING (Pushing onto Stack)]               |
|  output(4) -> calls output(3) [Waiting to print 4]    |
|  output(3) -> calls output(2) [Waiting to print 3]    |
|  output(2) -> calls output(1) [Waiting to print 2]    |
|  output(1) -> calls output(0) [Waiting to print 1]    |
|  output(0) -> condition (n > 0) is FALSE (Base Case)  |
|                                                       |
|  [PHASE 2: UNWINDING (Popping off Stack & Executing)] |
|  output(0) finishes and returns                       |
|  output(1) resumes -> Prints "1 " -> returns          |
|  output(2) resumes -> Prints "2 " -> returns          |
|  output(3) resumes -> Prints "3 " -> returns          |
|  output(4) resumes -> Prints "4 " -> returns          |
+-------------------------------------------------------+
*/
class print1toN{                           //important question
    public static void output(int n){
        if(n>0){
            output(n-1);
            System.out.print(n+" ");
        }
    }
}



class printNto1{
    public static void output(int n){
        if(n>0){
            if(n==1){
                System.out.print(n);
            }
            else{
                System.out.print(n+" ");
                output(n-1);
            }
        }
    }
}

class printEven{
    public static void output(int n){
        if(n>0){
            if (n%2!=0){
                output(n-1);
            }
            else{
                output(n-2);
                System.out.print(n+" ");
            }
        }
    }
}

class printOdd{
    public static void output(int n){
        if (n>0){
            if(n%2!=0){
                output(n-2);
                System.out.print(n + " ");
            }
            else{
                output(n-1);
            }
        }
    }
}

class printSum{
    public static int output(int n){
        if (n>0){
            return (n+output(n-1));
        }
        else{
            return 0;
        }
    }
}

class factorial{
    public static int output(int n){
        if (n>0){
            return n*output(n-1);
        }
        else{
            return 1;
        }
    }
}

class power2{
    public static int output(int n){
        if(n>0){
            return 2*output(n-1);
        }
        else{
            return 1;
        }
    }
}

class FibNum{
    public static int output(int n){
        if(n<=2){
            return 1;
        }
        else{
            return output(n-1)+output(n-2);
        }
    }
}







public class Main{
    public static void main(String args[]){
        // print1toN.output(30);
        // printNto1.output(30);
        // printEven.output(31);
        // printOdd.output(30);
        // System.out.print("Sum is : " + printSum.output(10));
        // System.out.print("factorial is : " + factorial.output(5));
        // System.out.print("power is : " + power2.output(2));
        // System.out.print("fib number is : " + FibNum.output(30));



    }
}