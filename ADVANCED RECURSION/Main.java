import java.util.*;

class MoveZeros{
    public static int[] output(int arr[],int i , int j){
        if(i >= j || j >= arr.length){
            return arr;
        }
        if(arr[i]==0 || i ==arr.length-1){
            if (arr[j]!=0){
                arr[i]=arr[j]+arr[i];
                arr[j]=arr[i]-arr[j];
                arr[i]=arr[i]-arr[j];
                 return output(arr , 0 , arr.length-1);
            }
            else{
                return output(arr , i , j-1);
            }
        }
        else{
            return output(arr , i+1 , j);
        }
    }
}







public class Main{
    public static void main(String args[]){
        for(int i : MoveZeros.output(new int[] {1,0,8,4,0,0,0,3,5,0},0,9)){
            System.out.print(i + " ");
        }
    }
}