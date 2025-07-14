public class Problem4 {

    public static void printReverse(Object[] arr ,int i){
        if (i == (arr.length - 1)){
            System.out.println(arr[i]);
        }
        else if (i >= arr.length || i < 0){
            throw new IllegalArgumentException("index out of bounds");
        }
        else if (arr.length == 0){
            System.out.println("{}");
        }
        else{
            printReverse(arr, i + 1);
            System.out.println(arr[i]);
        }
    }
    public static void printReverse(Object[] arr){
        printReverse(arr,0);
    }
    public static void main(String[] args){
        Object[] items = {"a" , "b" , "c"};
        printReverse(items);
        Object[] g = {};
        printReverse(g);
    }
}
