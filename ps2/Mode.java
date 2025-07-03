
public class Mode {
    public static int oldfindMode(int[] arr) {
        int mode = -1;
        int modeFreq = 0;   // number of times that the mode appears

        for (int i = 0; i < arr.length; i++) {
            int freq = 1;   // number of times that arr[i] appears from
                            // position i to the end of the array

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] == arr[i]) {   // how many times is this executed?
                    freq++;
                }
            }

            if (freq > modeFreq || (freq == modeFreq && arr[i] < mode)) {
                mode = arr[i];
                modeFreq = freq;
            }
        }

        return mode;
    }
    //use shell sort for new findmode as it has the best time complexity
    /*
     * find mode returns an int that has the most occurance in an array and if it is tied 
     * it will return the smallest number of the tied number
     */
    public static int findMode(int[] arr){
        int lastm = -1; // the last mode number
        int lastf = -1; // last highest frequency
        int curf = 1; // current frequency 
        if(arr == null){
            return -1;
        }
        else if (arr.length == 0){
            return -1;
        }
        else if (arr.length == 1){
            return arr[0];
        }
        else{
            for(int i = 1; i < arr.length ; i++){
                if (arr[i] == arr[i-1]){
                    curf +=1;
                    if(lastf < curf){
                        lastm = arr[i];
                    }
                    
                }
                else if(arr[i] != arr[i-1]){
                    lastf = curf;
                    curf = 1;
                }
            }
        }
        return lastm;
    }
    public static void main(String[] args){
        int[] a1 = {10, 8, 12, 8, 10, 5, 8};
        int[] a2 = {7, 5, 3, 5, 7, 11, 11};
        Sort.quickSort(a1);
        Sort.quickSort(a2);
        System.out.println(findMode(a1));
        System.out.println(findMode(a2));
    }
}
