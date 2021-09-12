package Exception;
import java.util.*;
public class SingleCatch{

    public static int resolver(int i, int j){
        int d=0;
        try{
            d=i/j;
        }catch(ArithmeticException e){
            d=-9999;
        }
        return d;
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int i=in.nextInt();
        int j=in.nextInt();
        System.out.println(resolver(i,j));
    }
}
