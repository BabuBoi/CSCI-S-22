public class Mode {
    public static int findMode(int[] arr) {
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
}
