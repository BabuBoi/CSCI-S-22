import java.util.*;
public class Problem2 {
    public static boolean isSorted(int[] arr) {
        if(arr == null){
            throw new IllegalArgumentException("null passed into isSorted method");
        }
        else if(arr.length == 1 || arr.length == 0) {
            return true;
        }
        else {
            for(int i=1; i < arr.length; i++){
                if(arr[i-1] > arr[i]){
                    return false;
                }
            }
        }
        return true;
    }
    public static void scale(int[] arr, int factor) {
        if(arr == null){
            throw new IllegalArgumentException("null passed into scale");
        }
        else if(arr.length != 0){
            for(int i = 0; i < arr.length; i++){
                arr[i] = arr[i]*factor;
            }
        }
    }

    
    public static void main(String[] args){
        int[] x = {1,2,3,4,5};
        System.out.println(isSorted(x));
        int[] y = {1};
        System.out.println(isSorted(y));
        int[] z = {};
        System.out.println(isSorted(z));
        //int[] a = null;
        //System.out.println(isSorted(a));
        int[] b = {2,1,3};
        System.out.println(isSorted(b));
        int[] c = {-1,2,3};
        System.out.println(isSorted(c));
        int[] d = {-1,-2,3};
        System.out.println(isSorted(d));

        scale(x,3);
        System.out.println(Arrays.toString(x));
        scale(y,2);
        System.out.println(Arrays.toString(y));
        scale(z,2);
        System.out.println(Arrays.toString(z));
        //scale(a,5);
        scale(b,6);
        System.out.println(Arrays.toString(b));
        scale(c,6);
        System.out.println(Arrays.toString(c));
        scale(d,7);
        System.out.println(Arrays.toString(d));
    }
}