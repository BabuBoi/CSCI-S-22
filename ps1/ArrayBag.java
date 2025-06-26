/* 
 * ArrayBag.java
 * 
 * Computer Science E-22
 */

import java.util.*;

/*
 * An simple implementation of a bag data structure that uses 
 * an array to store the items.
 */
public class ArrayBag {
    /* 
     * The array used to store the items in the bag.
     */
    private Object[] items;
    
    /* 
     * The number of items in the bag.
     */
    private int numItems;
    
    public static final int DEFAULT_MAX_SIZE = 50;
    
    /*
     * Constructor with no parameters - creates a new, empty ArrayBag with 
     * the default maximum size.
     */
    public ArrayBag() {
        this.items = new Object[DEFAULT_MAX_SIZE];
        this.numItems = 0;
    }
    
    /* 
     * A constructor that creates a new, empty ArrayBag with the specified
     * maximum size.
     */
    public ArrayBag(int maxSize) {
        if (maxSize <= 0) {
            throw new IllegalArgumentException("maxSize must be > 0");
        }
        this.items = new Object[maxSize];
        this.numItems = 0;
    }
    
    /*
     * numItems - accessor method that returns the number of items 
     * in this ArrayBag.
     */
    public int numItems() {
        return this.numItems;
    }

    private Object[] items(){
        return this.items;
    }
    
    /* 
     * add - adds the specified item to this ArrayBag. Returns true if there 
     * is room to add it, and false otherwise.
     * Throws an IllegalArgumentException if the item is null.
     */
    public boolean add(Object item) {
        if (item == null) {
            throw new IllegalArgumentException("item must be non-null");
        } else if (this.numItems == this.items.length) {
            return false;    // no more room!
        } else {
            this.items[this.numItems] = item;
            this.numItems++;
            return true;
        }
    }
    
    /* 
     * remove - removes one occurrence of the specified item (if any)
     * from this ArrayBag.  Returns true on success and false if the
     * specified item (i.e., an object equal to item) is not in this ArrayBag.
     */
    public boolean remove(Object item) {
        for (int i = 0; i < this.numItems; i++) {
            if (this.items[i].equals(item)) {
                // Shift the remaining items left by one.
                for (int j = i; j < this.numItems - 1; j++) {
                    this.items[j] = this.items[j + 1];
                }
                this.items[this.numItems - 1] = null;
                
                this.numItems--;
                return true;
            }
        }
        
        return false;  // item not found
    }
    
    /*
     * contains - returns true if the specified item is in the Bag, and
     * false otherwise.
     */
    public boolean contains(Object item) {
        for (int i = 0; i < this.numItems; i++) {
            if (this.items[i].equals(item)) {
                return true;
            }
        }
        
        return false;
    }
    
    /*
     * containsAll - does this ArrayBag contain all of the items in
     * otherBag?  Returns false if otherBag is null or empty. 
     */
    public boolean containsAll(ArrayBag otherBag) {
        if (otherBag == null || otherBag.numItems == 0) {
            return false;
        }
        
        for (int i = 0; i < otherBag.numItems; i++) {
            if (! this.contains(otherBag.items[i])) {
                return false;
            }
        }
        
        return true;
    }
    
    /*
     * grab - returns a reference to a randomly chosen item in this ArrayBag.
     */
    public Object grab() {
        if (this.numItems == 0) {
            throw new IllegalStateException("the bag is empty");
        }
        
        int whichOne = (int)(Math.random() * this.numItems);
        return this.items[whichOne];
    }

    /*
     * room left returns the number of additional items that the bag can store
     */
    public int roomLeft(){
        return this.items.length - this.numItems;
    }
    
    /*
     * isEmpty returns weithor or not the bag is empty 
     */
    public boolean isEmpty(){
        if(this.numItems <= 0){
            return true;
        }
        else{
            return false;
        }
    }
    /*
     * increasecapacity will increase the maximum capacity of the bag by the given amount
     */
    public void increasecapacity(int amount){
        if(amount > 0){
        Object[] nbag = new Object[this.items.length + amount];
        for(int i=0; i < this.items.length ; i++){
            nbag[i] = this.items[i];
        }
        this.items = nbag;

        }
        else if (amount < 0){
            throw new IllegalArgumentException("cannot increase bag size by negative number");
        }
    }
    /*
     * additems will add all items in other bag into current bag and return true if there is room for all items to be added and false otherwise
     */
    public boolean addItems(ArrayBag other){
        if(other == null){
            throw new IllegalArgumentException("null parameter passed");
        }
        else{
            Object[] arr = other.toArray();
            if(this.roomLeft() >= arr.length){
                for(int i = 0; i < arr.length ; i++){
                    this.items[this.numItems] = arr[i];
                    this.numItems +=1;
                }
                return true;
            }
            else{
                return false;
            }
        }
    }
    /* 
    *intersectionWith create and return an ArrayBag containg one occourence of any item that is found in both the called object and the parameter other
    */ 
    public ArrayBag intersectionWith(ArrayBag other){
        if (other == null){
            throw new IllegalArgumentException("passed null into intersectionWith");
        }
        else if (this.isEmpty() || other.isEmpty()){
            ArrayBag nBag = new ArrayBag(1);
            return nBag;
        }
        else{
            boolean leftS = this.numItems <= other.numItems();
            if (leftS) {
                ArrayBag nBag = new ArrayBag(this.numItems);
                for (int i = 0; i < this.numItems ; i++){
                    if (other.contains(this.items[i]) && !nBag.contains(this.items[i])){
                        nBag.add(this.items[i]);
                    }
                }
                return nBag;  
            }
            else{
                ArrayBag nBag = new ArrayBag(other.numItems());
                for (int i = 0; i < other.numItems() ; i++){
                    if (this.contains(other.toArray()[i]) && !nBag.contains(other.toArray()[i])){
                        nBag.add(other.toArray()[i]);
                    }
                }
                return nBag;
            }
            
        }

    }
    /*
     * toArray - return an array containing the current contents of the bag
     */
    public Object[] toArray() {
        Object[] copy = new Object[this.numItems];
        
        for (int i = 0; i < this.numItems; i++) {
            copy[i] = this.items[i];
        }
        
        return copy;
    }
    
    /*
     * toString - converts this ArrayBag into a string that can be printed.
     * Overrides the version of this method inherited from the Object class.
     */
    public String toString() {
        String str = "{";
        
        for (int i = 0; i < this.numItems; i++) {
            str = str + this.items[i];
            if (i != this.numItems - 1) {
                str += ", ";
            }
        }
        
        str = str + "}";
        return str;
    }
    
    /* Test the ArrayBag implementation. */
    public static void main(String[] args) {

        //test for roofleft()
        System.out.println("_________________________________");
        System.out.println("tests for roomleft()");
        System.out.println("---------------------------------");
        ArrayBag a = new ArrayBag(5);
        a.add("map");
        System.out.println("room left in a: " + a.roomLeft());
        a.add("bottle");
        System.out.println("room left in a: " + a.roomLeft());
        a.add("pen");
        System.out.println("room left in a: " + a.roomLeft());
        //test for isempty()
        System.out.println("_________________________________");
        System.out.println("tests for isempty()");
        System.out.println("---------------------------------");
        ArrayBag b = new ArrayBag(2);
        System.out.println("is b empty = "+b.isEmpty());
        System.out.println("is a empty = " + a.isEmpty());
        //test for increasecapacity
        System.out.println("_________________________________");
        System.out.println("tests for increase capacity");
        System.out.println("---------------------------------");
        ArrayBag c = new ArrayBag(10);
        System.out.println("capacity of c :" + c.items().length);
        System.out.println("capacity of a :" + a.items().length);
        System.out.println("capacity of b :" + b.items().length);
        c.increasecapacity(0);
        //c.increasecapacity(-1);
        a.increasecapacity(1);
        b.increasecapacity(2);
        System.out.println("---Size after increase---");
        System.out.println("capacity of c :" + c.items().length);
        System.out.println("capacity of a :" + a.items().length);
        System.out.println("capacity of b :" + b.items().length);
        //testing for additems
        System.out.println("_________________________________");
        System.out.println("tests for additems");
        System.out.println("---------------------------------");
        ArrayBag d = new ArrayBag(2);
        d.add("pen");
        d.add("paper");
        System.out.println("a :" + a.toString());
        System.out.println("d :" + d.toString());
        a.addItems(d);
        System.out.println("contents of d added to a =" + a.toString());
        System.out.println("adding itms from empty bag b to a :" + a.addItems(b));
        System.out.println("_________________________________");
        System.out.println("tests for intersectionWith");
        System.out.println("---------------------------------");
        ArrayBag x = new ArrayBag();
        x.add(2);
        x.add(2);
        x.add(3);
        x.add(5);
        x.add(7);
        x.add(7);
        x.add(7);
        x.add(8);
        ArrayBag y = new ArrayBag();
        y.add(2);
        y.add(3);
        y.add(4);
        y.add(5);
        y.add(5);
        y.add(6);
        y.add(7);
        System.out.println("x is :" + x.toString());
        System.out.println("y is :" + y.toString());
        System.out.println("x intersection with y is :" + x.intersectionWith(y).toString());
        System.out.println("c is :" + c.toString());
        System.out.println("b is :" + b.toString());
        System.out.println("b intersectionWith c is :" + b.intersectionWith(c).toString());

        // Create a Scanner object for user input.
        Scanner scan = new Scanner(System.in);
        
        // Create an ArrayBag named bag1.
        System.out.print("size of bag 1: ");
        int size = scan.nextInt();
        ArrayBag bag1 = new ArrayBag(size);
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
