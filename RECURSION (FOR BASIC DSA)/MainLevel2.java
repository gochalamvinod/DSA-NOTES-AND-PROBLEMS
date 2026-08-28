class Count{
    public static int output(int n){
        return output(n, 0);
    }
    public static int output(int n , int p){
        if (n==0){
            return p;
        }
        else{
            return output(n/10,p+1);
        }
    }
}

class Reverse{
    public static int output(int n){
        if(n==0){
            return 0;
        }
        else{
            if (n/10==0){
                return n;
            }
            return Integer.parseInt(String.valueOf(n%10)+String.valueOf(output(n/10)));
        }
    }
}




public class MainLevel2{
    public static void main(String args[]){
        // System.out.print(Count.output(807465));
        // System.out.print(Reverse.output(807465));


    }
}