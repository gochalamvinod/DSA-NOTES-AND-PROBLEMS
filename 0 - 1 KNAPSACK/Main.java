import java.util.*;
/*=============================================================*/
class KnapSack01{
    public static int check(int[] arr1 , int[] arr2 , int weight , int length){
        if(weight == 0 || length == 0){
            return 0;
        }
        if(arr1[length-1]>weight){
            return check(arr1,arr2,weight,length-1);
        }
        return Math.max(arr2[length-1] + check(arr1,arr2,weight-arr1[length-1],length-1),check(arr1,arr2,weight,length-1));

    }

}

/*=============================================================*/

class KnapSack01_Memorization{
    static int[][] memory ; // = new int[weight+1][length+1]; 
//                           THIS IS THE MEMORY TABLE OF ALL POSSIBLITES  

    public static void init(int a, int b) {
        if (memory == null) {                    //CHECK IS DATA INITILIZED OR NOT
            memory = new int[a][b];

            for (int[] row : memory) {            //INITILIZE THE MEMORY ONCE 
                Arrays.fill(row, -1);
            }
        }
    }


    public static int check(int[] arr1 , int[] arr2 , int weight , int length){
        init(weight+1,length+1);
        if(weight == 0 || length == 0){
            return 0;
        }
        if(arr1[length-1]>weight){
            return check(arr1,arr2,weight,length - 1);
        }
        if(memory[weight][length]!=-1){
            return memory[weight][length];
        }
        else{
            return memory[weight][length]=Math.max(arr2[length-1] + check(arr1,arr2,weight-arr1[length-1],length-1),check(arr1,arr2,weight,length-1));
        }
    
    }
}

/*=============================================================*/

class UnBoundedKnapSack01{
    public static int check(int[] arr1 , int[] arr2 , int weight , int length){
        if(weight == 0 || length == 0){
            return 0;
        }
        if(arr1[length-1]>weight){
            return check(arr1,arr2,weight,length-1);
        }
        return Math.max(arr2[length-1]+check(arr1,arr2,weight-arr1[length-1],length), /*Only difference  is we dont do length -1 here*/
        check(arr1,arr2,weight,length-1));
        
    }
}

/*=============================================================*/

class UnBoundedKnapSack01_Memorization{
    static int[][] memory_1;
    public static void init(int a , int b){
        if(memory_1==null){
            memory_1=new int[a][b];
            
            for(int[] row: memory_1){
                Arrays.fill(row,-1);
            }
        }
    }
    public static int check(int[] arr1 , int[] arr2 , int weight , int length){
        init(weight+1,length+1);
        if(weight == 0 || length == 0){
            return 0;
        }
        if(arr1[length-1]>weight){
            return check(arr1,arr2,weight,length-1);
        }
        if(memory_1[weight][length]!=-1){
            return memory_1[weight][length];
        }
        return memory_1[weight][length]=Math.max(arr2[length-1]+check(arr1,arr2,weight-arr1[length-1],length), check(arr1,arr2,weight,length-1));
    }
}

/*=============================================================*/

class FractionalKnapSack{         //(GREEDY APPROACH)
    static class Helper{          //My own dataType
        int weight;
        int value;
        double ratio;
        Helper(int weight ,int value){
            this.weight = weight;
            this.value = value;
            this.ratio =  (double) value/(double)weight;   //filtering based on highest values;
        }
    }
    public static double check(int[] arr1 , int[] arr2 , int weight , int length)
    {
        List<Helper> items = new ArrayList<>();
        for(int i = 0 ; i<length ;i++){
            items.add(new Helper(arr1[i],arr2[i]));
        }
        items.sort((a, b) -> Double.compare(b.ratio, a.ratio));    // Sorting by ratio decreasing 
    
        double storage_value = 0.0;
        int remaining_capacity = weight;
        for(Helper item : items){
            if(remaining_capacity<=0){
                break;
            }
            if(remaining_capacity>=item.weight){
                storage_value+=item.value;
                remaining_capacity-=item.weight;
            }
            else{
                storage_value+=(double)remaining_capacity/(double)item.weight*(double)item.value;
                break;
            }
        }
        return storage_value;
    }
}
/*=============================================================*/

public class Main{
    public static void main(String args[]){
        int[] weight = new int[] {5,7,3,1,2,8,6};
        int[] values = new int[] {1,2,3,5,6,7,8};
        int Weight = 15;
        System.out.println(KnapSack01.check(weight , values , Weight , weight.length));
        System.out.println(UnBoundedKnapSack01.check(weight , values , Weight , weight.length));
        System.out.println(KnapSack01_Memorization.check(weight , values , Weight , weight.length));
        System.out.println(UnBoundedKnapSack01_Memorization.check(weight , values , Weight , weight.length));
        System.out.println(FractionalKnapSack.check(weight , values , Weight , weight.length));
    }
}