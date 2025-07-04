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
        else if (a2.length >= a1.length){
            int[] out = new int[a1.length];
            Sort.quickSort(a1);
            Sort.quickSort(a2);
            //System.out.println(Arrays.toString(a1));
            //System.out.println(Arrays.toString(a2));
            int i = 0;
            int j = 0;
            int k = 0;
            int lin = Integer.MIN_VALUE;
            do {
                //System.out.println("a1[i]:" + a1[i]);
                //System.out.println("a2[j]:" + a2[j]);
                //System.out.println("linb" + lin);
                if(a1[i] != a2[j]){
                    //System.out.println("!=");
                    if(a1[i] < a2[j]){
                        if (i < a1.length -1){
                            i+=1;
                        }
                        else{
                            break;
                        }
                    }
                    else{
                        j+=1;
                    }
                }
                else if(a1[i] == a2[j] && a1[i] != lin){
                    //System.out.println("==");
                    out[k] = a1[i];
                    lin = a1[i];
                    if (k < out.length -1){
                        k+=1;
                    }
                    if (i < a1.length -1){
                        i+=1;
                    }
                    else{
                        break;
                    }
                    j+=1;
                    
                    
                }
                else if (a1[i] == a2[j] && a1[i] == lin){
                    //System.out.println("==skip");
                    if (i < a1.length -1){
                        i+=1;
                    }
                    else{
                        break;
                    }
                    j+=1;
                }
                //System.out.println("lina" + lin);
            }while(j < a2.length);
            if(lin == Integer.MIN_VALUE){
                int[] o = new int[0];
                return o;
            }else{
                return out;
            } 
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

        int[] a5 = {0, 0, -4, 6, 10, 8};
        int[] a6 = {12, 0, -4, 8, 10, 8};
        int[] result3 = intersect(a5, a6);
        System.out.println(Arrays.toString(result3));

        int[] a7 = {0,0,0,0,0,0,0,0,0,0};
        int[] a8 = {7, 11, -40, 8, 10, 8};
        int[] result4 = intersect(a7, a8);
        System.out.println(Arrays.toString(result4));

    }
}
