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
                arr[i] = i*factor;
            }
        }
    }

    
    public static void main(String[] args){
        int[] x = {1,2,3,4,5};
        System.out.println(x.length);
        System.out.println(isSorted(x));
        scale(x,3);
        System.out.println(x);

    }
}