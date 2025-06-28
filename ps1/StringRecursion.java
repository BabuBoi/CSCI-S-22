public class StringRecursion {
    public static String reflect(String str){
        if(str == null || str == ""){
            return "";
        }
        //else if (str.length() == 2){return str.charAt(1)+""+str.charAt(0);}
        else{
            //System.out.println("str:"+str);
            //System.out.println("first:"+str.charAt(0));
            String s = reflect(str.substring(1));
            //String last = str.charAt(str.length()-1) + "";
            //System.out.println("str:"+str);
            //System.out.println("s:"+s);
            //System.out.println("first:"+str.charAt(0));
            if (str.length() == 1){
                //System.out.println("==");
                return str + str ;
                //return str + s + str.charAt(0);
            }
            else {
                //System.out.println("!=");
                //System.out.println("s:"+s);
                //System.out.println("str:"+str);
                return str.charAt(0) + s + str.charAt(0);}

        }
    }

    public static void main(String[] args){
        String a = "method";
        String b = "abc";
        System.out.println(reflect(a));
        System.out.println(reflect(b));
    }
}
