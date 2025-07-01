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
        return -1;
    }
    /*
     * indexOF will give the index of the first instance if the given char
     */
    public static int indexOf(char ch , String str){
        if(str == "" || str == null){
            return -1;
        }
        else{
            if(str.charAt(0) == ch){
                return 0;
            }
            else {
                int i = indexOf(ch , str.substring(1));
                if(i == -1){
                    return i;
                }
                else {
                    return i + 1;
                }
                 
            }
        }
    }
    /*
     * trim will trim off any leading or trailing space chars from a given string
     */
    public static String trim(String str){
        if (str == ""){
            return "";
        }
        else if (str == null){
            return null;
        }
        else{
            if (str.charAt(str.length()-1) == ' '){
                return trim(str.substring(0, str.length()-1));
            }
            else{
                if( str.charAt(1) == ' ' && str.charAt(0) != ' ' && str.charAt(2) != ' ' ){
                    return str.substring(0, 2) + trim(str.substring(2));
                }else if (str.charAt(0) == ' '){
                    return trim (str.substring(1));
                }else{
                    return str;
                }
            }
        }
    }
    public static void main(String[] args){
        String a = "method";
        String b = "abc";
        System.out.println("tests for reflect:");
        System.out.println(reflect(a));
        System.out.println(reflect("method"));
        System.out.println(reflect(b));
        System.out.println("tests for numDiff:");
        System.out.println(numDiff("alien", "allen"));
        System.out.println(numDiff("alien", "alone"));
        System.out.println(numDiff("same", "same"));
        System.out.println(numDiff("same", "sameness"));
        System.out.println(numDiff("some", "sameness"));
        System.out.println(numDiff("", "abc"));
        System.out.println(numDiff("abc", ""));
        System.out.println("tests for indexOf:");
        System.out.println(indexOf('b', "Rabbit"));
        System.out.println(indexOf('P', "Rabbit"));
        System.out.println(indexOf('a',"cat"));
        System.out.println("tests for trim:");
        // the * are to easily see if trailing spaces are trimmed 
        System.out.println(trim(" hello world ") + "*");
        System.out.println(trim("recursion ")+ "*");
    }
}
