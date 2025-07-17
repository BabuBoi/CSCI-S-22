import java.util.Scanner;

public class LLBag {
    private class Node {
        private Object item;
        private Node next;
        
        private Node(Object i, Node n){
            this.item = i;
            this.next = n;
        }
    }

    private Node head;
    private int length;

    public LLBag(){
        this.head = new Node(null,null);
        this.length = 0;
    }

    /*
     * length returns length of the LLlist not including the dummy head node
     */
    public int numItems(){
        return this.length;
    }

    /*
     * always returns true and adds an item to LLbag
     */
    public boolean add(Object item){
        if(item == null){
            throw new IllegalArgumentException("null item passed");
        }
        else{
            Node newItem = new Node(item,this.head.next);
            this.head.next = newItem;
            this.length += 1;
        }
        return true;
    }
    /*
     * remove method that removes the first occourance of a given item from this bag
     * returns true if item to remove is in bag
     */
    public boolean remove(Object item){
        Node trav = this.head.next;
        Node prevN = this.head;
        while(trav != null){
            if(trav.item.equals(item)){
                prevN.next = trav.next;
                this.length -=1;
                return true;
            }
            prevN = trav;
            trav = trav.next;
        }
        return false;
    }

    /*
     * contains returns true if this LLbag contains the specified object
     */

     public boolean contains(Object item){
        Node trav = head.next;
        while(trav!=null){
            if(trav.item.equals(item)){return true;}
            trav = trav.next;
        }
        return false;
     }

     /*
      * contains all asks does this LLBag contain all the items in the otherbag and returns false if other 
      * bag is null or empty (could be optimized with hash table)
      */
      public boolean containsAll(LLBag otherBag){
        if(otherBag == null || otherBag.numItems() == 0){
            return false;
        }
        Node trav = otherBag.head.next;
        while (trav != null) {
            if(!this.contains(trav.item)){return false;}
            trav = trav.next;
        }
        return true;
      }
    
    /*
     * grab returns a randomly chosen item in this LLBag
     */

     public Object grab(){
        if (this.length == 0){
            throw new IllegalArgumentException("this bag is empty");
        }
        int indexAt = (int)(Math.random() * this.length);
        int index = 0;
        Node trav = head.next;
        while(trav != null){
            if(index == indexAt){
                return trav.item;
            }
            index +=1;
            trav = trav.next;
        }
        return new Object();
     }

     /*
      * roomleft dosnt apply to LLbag as items acan be added indefnetily
      */



    /*
     * is empty returns whether or not bag is empty
     */
    public boolean isEmpty(){
        if(this.length ==0){return true;}
        else{return false;}
    }
    
    /*
     * increasecapacity is not applicable as LLlist has an indefinite capacity
     */

     /*
      * additms will add all items in other bag and will always return true as size and roomleft is irrelevent in 
      * linked lists implementation
      */
      public boolean addItems(LLBag other){
        if(other == null){
            throw new IllegalArgumentException("null parameter passed");
        }
        else{
            Node trav = other.head.next;
            while(trav != null){
                this.add(trav.item);
                trav = trav.next;
            }
            return true;
        }
      }

      /*
       * intersection with will create an new LLbag containing one occurence of any item that is found in both
       * this LLbag and the other LLbag (could be optimized with a hashtable)
       */
      public LLBag intersectionWith(LLBag other){
        if(other == null){
            throw new IllegalArgumentException("null passed as param");
        }
        else if (this.isEmpty() || other.isEmpty()){return new LLBag();}
        else{
            boolean leftS = this.numItems() <= other.numItems();
            if(leftS){
                LLBag nBag = new LLBag();
                Node trav = this.head.next;
                while(trav != null){
                    if(other.contains(trav.item) && !nBag.contains(trav.item)){
                        nBag.add(trav.item);
                    }
                    trav = trav.next;
                }
                return nBag;
            }
            else{
                LLBag nBag = new LLBag();
                Node trav = other.head.next;
                while(trav != null){
                    if(this.contains(trav.item) && !nBag.contains(trav.item)){
                        nBag.add(trav.item);
                    }
                    trav = trav.next;
                }
                return nBag;
            }

        }
      }

    /*
     * toArray returns an array of objects containing all items in LLbag
     */
    public Object[] toArray(){
        Object[] copy = new Object[this.length];
        Node trav = this.head.next;
        for(int i=0; i<this.length;i++){
            copy[i] = trav.item;
            trav = trav.next;
        }
        return copy;
    }

    /*
     * to string method returns a string format of the LLBag
     */
    public String toString(){
        String str = "{";
        
        Node trav = this.head.next;
        while(trav != null){
            str = str + trav.item;
            if (trav.next != null){str += ", ";}
            trav = trav.next;
        }
        str += "}";
        return str;
    }

    public static void main(String[] args){
        //test add
        LLBag bag = new LLBag();
        System.out.println("initial bag with "+bag.numItems()+" items:" + bag.toString());
        bag.add("hat");
        System.out.println("bag with "+ bag.numItems() +" item:" + bag.toString());
        bag.add("cookie");
        System.out.println("bag with "+bag.numItems()+" items:" + bag.toString());
        bag.add("bottle");
        System.out.println("bag with "+bag.numItems()+" items:" + bag.toString());
        bag.add("compass");
        System.out.println("bag with "+bag.numItems()+" items:" + bag.toString());
        bag.add("jam");
        System.out.println("bag with "+bag.numItems()+" items:" + bag.toString());
        
        //test remove
        bag.remove("jam");
        System.out.println("bag with jam removed:"+bag.toString());
        System.out.println("bag now has "+bag.numItems()+" items");
        bag.remove("hat");
        System.out.println("bag with hat removed:"+bag.toString());
        System.out.println("bag now has "+bag.numItems()+" items");
        bag.remove("bottle");
        System.out.println("bag with bottle removed:"+bag.toString());
        System.out.println("bag now has "+bag.numItems()+" items");

        //test contains
        System.out.println("does bag contain cookie:" +bag.contains("cookie"));
        System.out.println("does bag contain jam:" +bag.contains("jam"));
        LLBag bag2 = new LLBag();
        bag2.add("compass");
        bag2.add("cookie");
        bag2.add("knife");
        System.out.println("bag1 is:" + bag.toString());
        System.out.println("bag2 is:" + bag2.toString());
        System.out.println("does bag1 contain all items in bag2 " + bag.containsAll(bag2));
        bag.add("knife");
        System.out.println("bag1 is:" + bag.toString());
        System.out.println("bag2 is:" + bag2.toString());
        System.out.println("does bag1 contain all items in bag2 " + bag.containsAll(bag2));

        //test for isempty()
        LLBag aTest = new LLBag();
        aTest.add("map");
        aTest.add("bottle");
        aTest.add("pen");
        System.out.println("_________________________________");
        System.out.println("tests for isempty()");
        System.out.println("---------------------------------");
        LLBag bTest = new LLBag();
        System.out.println("is b empty = "+bTest.isEmpty());
        System.out.println("is a empty = " + aTest.isEmpty());

        //testing for additems
        System.out.println("_________________________________");
        System.out.println("tests for additems");
        System.out.println("---------------------------------");
        LLBag dTest = new LLBag();
        dTest.add("pen");
        dTest.add("paper");
        System.out.println("a :" + aTest.toString());
        System.out.println("d :" + dTest.toString());
        aTest.addItems(dTest);
        System.out.println("contents of d added to a =" + aTest.toString());
        System.out.println("adding itms from empty bag b to a :" + aTest.addItems(bTest));

        //tests for intersectionWith
        System.out.println("_________________________________");
        System.out.println("tests for intersectionWith");
        System.out.println("---------------------------------");
        LLBag ctest = new LLBag();
        LLBag xTest = new LLBag();
        xTest.add(2);
        xTest.add(2);
        xTest.add(3);
        xTest.add(5);
        xTest.add(7);
        xTest.add(7);
        xTest.add(7);
        xTest.add(8);
        LLBag yTest = new LLBag();
        yTest.add(2);
        yTest.add(3);
        yTest.add(4);
        yTest.add(5);
        yTest.add(5);
        yTest.add(6);
        yTest.add(7);
        System.out.println("x is :" + xTest.toString());
        System.out.println("y is :" + yTest.toString());
        System.out.println("x intersection with y is :" + xTest.intersectionWith(yTest).toString());
        System.out.println("c is :" + ctest.toString());
        System.out.println("b is :" + bTest.toString());
        System.out.println("b intersectionWith c is :" + bTest.intersectionWith(ctest).toString());

        // Create a Scanner object for user input.
        Scanner scan = new Scanner(System.in);
        
        // Create an LLBag named bag1.
        System.out.print("size of bag 1: ");
        int size = scan.nextInt();
        LLBag bag1 = new LLBag();
        scan.nextLine();    // consume the rest of the line
        
        // Read in strings, add them to bag1, and print out bag1.
        String itemStr;        
        for (int i = 0; i < size; i++) {
            System.out.print("item " + i + ": ");
            itemStr = scan.nextLine();
            bag1.add(itemStr);
        }
        System.out.println("bag 1 = " + bag1);
        System.out.println();
        
        // Select a random item and print it.
        Object item = bag1.grab();
        System.out.println("grabbed " + item);
        System.out.println();
        
        // Iterate over the objects in bag1, printing them one per
        // line.
        Object[] items = bag1.toArray();
        for (int i = 0; i < items.length; i++) {
            System.out.println(items[i]);
        }
        System.out.println();
        
        // Get an item to remove from bag1, remove it, and reprint the bag.
        System.out.print("item to remove: ");
        itemStr = scan.nextLine();
        if (bag1.contains(itemStr)) {
            bag1.remove(itemStr);
        }
        System.out.println("bag 1 = " + bag1);
        System.out.println();

        scan.close();


    }

}
