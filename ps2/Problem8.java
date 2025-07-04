import java.util.Arrays;

public class Problem8 {
    /*
     * takes two arrays and returns the intersecton of the two arrays as well as sorts them 
     */
    public static int[] intersect(int[] a1, int[] a2){
        if (a1 == null || a2 == null){
            throw new IllegalArgumentException("null array passed");
        }
        else if (a1.length == 0 || a2.length == 0){
            int[] out = new int[0];
            return out;
        }
        else if (a1.length > a2.length){
            return intersect(a2,a1);
        }
        else if (a2.length > a1.length){
            int[] out = new int[a1.length];
            Sort.quickSort(a1);
            Sort.quickSort(a2);
            int i = 0;
            int j = 0;
            int k = 0;
            int lin = Integer.MIN_VALUE;
            do {
                if (a1[i] != a2[j]){
                    if(a2[j] > a1[i]){
                        if (i < a1.length -1){
                            i++;
                        }
                    }
                }
                else if(a1[i] == a2[j] && a1[i] != lin){
                    out[k] = a1[i];
                    if (k < out.length -1){
                        k++;
                    }
                    if (i < a1.length -1){
                        i++;
                    }
                    lin = a1[i];
                    j++;
                }
                
            }while(j < a2.length);
            return out; 
        }
        else if (a1.length == a2.length){
            int[] out = new int[a1.length];
            Sort.quickSort(a1);
            Sort.quickSort(a2);
            int i = 0;
            int j = 0; 
            int k = 0;
            int lin = Integer.MIN_VALUE;
            do {
                if(a1[i] == a2[j] && a1[i] != lin){
                    out[k] = a1[i];
                    k++;
                    lin = a1[i];
                }
                i++;
                j++;
            }while(i < a1.length);
            return out;
        }
        int[] out = new int[0];
        return out;
    }
    public static void main(String[] args){
        int[] a1 = {10, 5, 7, 5, 9, 4};
        int[] a2 = {7, 5, 15, 7, 7, 9, 10};
        int[] result1 = intersect(a1, a2);
        System.out.println(Arrays.toString(result1));

        int[] a3 = {0, 2, -4, 6, 10, 8};
        int[] a4 = {12, 0, -4, 8};
        int[] result2 = intersect(a3, a4);
        System.out.println(Arrays.toString(result2));
    }
}
