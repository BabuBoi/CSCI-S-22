public class StringRecursion {
    /*
     * gives a reflection of given string with both the reflection and original string
     */
    public static String reflect(String str){
        if(str == null || str == ""){
            return "";
        }
        else{
            String s = reflect(str.substring(1));
            if (str.length() == 1){
                return str + str ;
            }
            else {
                return str.charAt(0) + s + str.charAt(0);
            }
}
    }
    /*
     * returns the number of diffrent charechters between two strings 
     */
    public static int numDiff(String str1, String str2){
        if(str1 == "" || str2 == "" || str1 == null || str2 == null){
            if(str1.length() > str2.length()){
                return str1.length() - str2.length();
            }
            else if (str2.length() > str1.length()){
                return str2.length() - str1.length();
            }
            else if (str1.length() == str2.length()){
                return 0;
            }
        }
        else{
            int r = numDiff(str1.substring(1), str2.substring(1));
            if(str1.charAt(0) == str2.charAt(0)){
                return r;
            }
            else if (str1.charAt(0) != str2.charAt(0)){
                return r + 1;
            }
            else{
                return 0;
            }
        }
        System.out.println("here");
        return 0;
    }
    public static void main(String[] args){
        String a = "method";
        String b = "abc";
        System.out.println(reflect(a));
        System.out.println(reflect(b));
        System.out.println(numDiff("alien", "allen"));
        System.out.println(numDiff("alien", "alone"));
        System.out.println(numDiff("same", "same"));
        System.out.println(numDiff("same", "sameness"));
        System.out.println(numDiff("some", "sameness"));
        System.out.println(numDiff("", "abc"));
        System.out.println(numDiff("abc", ""));
    }
}
