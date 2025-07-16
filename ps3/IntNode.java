public class IntNode {
    private int val;
    private IntNode next;
    /*
     * doubles any instance of n in a linked list with iteration
     */
    public static void doubleIter(IntNode first , int n ){
        if(first == null){return;}
        else {
            IntNode curNode = first;
            IntNode nextNode = first.next;
            while (curNode != null ){
                if(curNode.val == n){
                    curNode.val *= 2;
                }
                curNode = nextNode;
                nextNode = curNode.next;
            }
        }
    }
    /*
     * doubles any instance of n in a linked list with recursion
     */

    public static void doubleRecur(IntNode first, int n){
        if(first == null){return;}
        else{
            if(first.val == n){
                first.val *= 2;
                doubleRecur(first.next, n);
            }
            else{doubleRecur(first.next, n);}
        }
    }
}
