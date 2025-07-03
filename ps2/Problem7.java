import java.util.*;
public class Problem7 {
    /*
     * this method removes duplicate integers in an arry
     */
    public static int removeDups(int[] arr){
        if (arr == null){
            throw new IllegalArgumentException("passed null array");
        }
        else if (arr.length == 0){
            return 0;
        }
        else if (arr.length == 1){
            return 1;
        }
        else{
            int u = 1; // how many uniqes 
            int lnu = -1; // last uniqe checked 
            int start = -1; // start location of free space 
            int end = -1; // end location of free space 
            boolean repeat = false; // true if has multiple reapets
            for(int i = 1; i < arr.length ; i++){
                if(arr[i] == arr[i-1] || (lnu == arr[i] && start == -1 && end == -1)){
                    if (!repeat){
                        start = i;
                        end = i;
                        repeat = true;
                        
                    }
                    else if (repeat){
                        end = i;
                    }
                    lnu = arr[i];
                    arr[i] = 0;
                }
                else if(arr[i] != arr[i-1]){
                    if(lnu == arr[i]){
                        end = i;
                        arr[i] = 0;
                        repeat = true;
                    }
                    else if (lnu !=arr[i]){
                        u+=1;
                        repeat = false;
                        lnu = arr[i];
                        if(start != -1 || end != -1){
                            if((0 < (end-start+1)) && (start >= 0)){
                                System.out.println("here");
                                arr[start] = arr[i];
                                arr[i] = 0;
                                end +=1;
                                if((start+1) <= end){
                                    start +=1;
                                }
                                else if ((start+1) > end){
                                    start = -1;
                                    end = -1;
                                }
                            }
                        }
                        
                    }
                }
            }
            return u;
        }
    }

    public static void main(String[] args){
        int[] a1 = {2, 5, 5, 5, 10, 12, 12};
        int numUnique = removeDups(a1);
        System.out.println(Arrays.toString(a1));
        System.out.println(numUnique);
        int[] a2 = {1,1,1,2,3,4,4,5};
        int numUnique2 = removeDups(a2);
        System.out.println(Arrays.toString(a2));
        System.out.println(numUnique2);
        int[] a3 = {1,1,2,2,3,3,4,4};
        int numUnique3 = removeDups(a3);
        System.out.println(Arrays.toString(a3));
        System.out.println(numUnique3);
        int[] a4 = {1,1,1};
        int numUnique4 = removeDups(a4);
        System.out.println(Arrays.toString(a4));
        System.out.println(numUnique4);
    }
}
