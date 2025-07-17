/*
 * Problem8.java
 */
   
public class Problem8 {
    public static boolean isPal(String s) {
        // replace the following return statement with your implementation
        // of the method.
        // ascii range for upper 65 <= x <= 90
        if (s == null){throw new IllegalArgumentException("null passed in");}
        else if(s.length()==1||s.length() == 0){return true;}
        else{
            int len = s.length();
            int snum = 0;
            LLStack<Character> s1 = new LLStack<Character>();
            LLStack<Character> s2 = new LLStack<Character>();
            for(int i = 0; i<len;i++){
                char ch = s.charAt(i);
                ch = Character.toUpperCase(ch);
                if(ch>=65 && ch <=90){
                    s1.push(ch);
                    snum +=1;
                }
            }
            boolean isOdd = false;
            if(snum%2 != 0){isOdd = true;}
            if(isOdd){
                for(int i =0; i < (snum/2);i++){
                    s2.push(s1.pop());
                }
                s1.pop();
                for(int i = (snum/2); i < len;i++){
                    if(s1.pop() != s2.pop()){return false;}
                }
            }
            else{
                for(int i =0; i < (snum/2);i++){
                    s2.push(s1.pop());
                }
                for(int i = (snum/2); i < len;i++){
                    if(s1.pop() != s2.pop()){return false;}
                }
            }
            return true;
        }
    }
    
    public static void main(String[] args) {
        System.out.println("--- Testing method isPal ---");
        System.out.println();

        System.out.println("(0) Testing on \"A man, a plan, a canal, Panama!\"");
        try {
            boolean results = isPal("A man, a plan, a canal, Panama!");
            System.out.println("actual results:");
            System.out.println(results);
            System.out.println("expected results:");
            System.out.println("true");
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(results == true);
        } catch (Exception e) {
            System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
        }
        
        System.out.println();    // include a blank line between tests

        System.out.println("(1) Testing on \"radar\"");
        try {
            boolean results = isPal("radar");
            System.out.println("actual results:");
            System.out.println(results);
            System.out.println("expected results:");
            System.out.println("true");
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(results == true);
        } catch (Exception e) {
            System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
        }
        
        System.out.println();    // include a blank line between tests

        System.out.println("(1) Testing on \"race car\"");
        try {
            boolean results = isPal("race car");
            System.out.println("actual results:");
            System.out.println(results);
            System.out.println("expected results:");
            System.out.println("true");
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(results == true);
        } catch (Exception e) {
            System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
        }
        
        System.out.println();    // include a blank line between tests

        System.out.println("(1) Testing on \"abba\"");
        try {
            boolean results = isPal("abba");
            System.out.println("actual results:");
            System.out.println(results);
            System.out.println("expected results:");
            System.out.println("true");
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(results == true);
        } catch (Exception e) {
            System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
        }
        
        System.out.println();    // include a blank line between tests

        System.out.println("(1) Testing on \"hat\"");
        try {
            boolean results = isPal("hat");
            System.out.println("actual results:");
            System.out.println(results);
            System.out.println("expected results:");
            System.out.println("false");
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(results == false);
        } catch (Exception e) {
            System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
        }
        
        System.out.println();    // include a blank line between tests
        
        /*
         * We encourage you to add more unit tests below that test a variety 
         * of different cases, although doing so is not required.
         */
    }
}