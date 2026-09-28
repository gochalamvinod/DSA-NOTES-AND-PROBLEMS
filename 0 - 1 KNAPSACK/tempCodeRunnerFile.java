// class tempCodeRunnerFile{
//     public static void main(String args[]){
//         int i = 0 ;
//         int j = 1;
//         int arr[] = new int[]{1,1,1,2,2,3,4,5,5,5,5,5,6};
//         while(j<arr.length-1){
//             if(arr[i]!=arr[j]){
//                 i++;
//                 arr[i]=arr[j];
//             }
//                 j++;
//         }
//         for(int k = 0 ; k<=i ;k++){
//             System.out.print(arr[k]+" ");
//         }
//     }
// }

// class tempCodeRunnerFile{
//     public static void main(String args[]){
//         int arr[] = new int[]{0,0,1,0,2,2,0,4,0,5,0,5,0,6};
//         int i  = 0;
//         int j = arr.length-1;
//         while(j>i){
//             if (arr[i]!=0){
//                 i++;
//             }
//             else if(arr[j]==0){
//                 j--;
//             }
//             else{
//                 arr[i]=arr[i]+arr[j];
//                 arr[j]=arr[i]-arr[j];
//                 arr[i]=arr[i]-arr[j];
//             }
//         }
//         for(int k : arr){
//             System.out.print(k+" ");
//         }
//     }
// }

class tempCodeRunnerFile{
    public static void main(String args[]){
        int arr[] = new int[]{1,2,3,4,5,7};
        for(int i = 0 ; i<arr.length;i++){
            if(arr[i]!=i+1){
                System.out.print(i+1);
                break;
            }
        }
    }
}