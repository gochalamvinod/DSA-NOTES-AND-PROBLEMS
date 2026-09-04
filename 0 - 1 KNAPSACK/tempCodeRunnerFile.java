import java.util.*;
class KnapSack01{
    public static int check(int[] arr1 , int[] arr2 , int weight , int length){
        if(weight == 0 || length == 0){
            return 0;
        }
        if(arr1[length-1]>weight){
            return check(arr1,arr2,weight,length-1);
        }
        if(arr1[length-1]<=weight){
            return Math.max(arr2[length-1] + check(arr1,arr2,weight-arr1[length-1],length-1),check(arr1,arr2,weight,length-1));
        }
        return 0;
    }

}

public class tempCodeRunnerFile{
    public static void main(String args[]){
        int[] weight = new int[] {5,7,3,1,2,8,6};
        int[] values = new int[] {1,2,3,5,6,7,8};
        int Weight = 1;
        System.out.print(KnapSack01.check(weight , values , Weight , weight.length));
    }
}