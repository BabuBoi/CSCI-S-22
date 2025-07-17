public class Problem4 {
    /*
     * takes a given stack and reverses its contents
     */
    public static void reverseStack(Stack<Object> stack){
        if (!stack.isEmpty()){
            Queue<Object> q = new LLQueue();
            do{
                q.insert(stack.pop());
            }while(!stack.isEmpty());
            do{
                stack.push(q.remove());
            }while(!q.isEmpty());
        }
        else{return;}
    }
    /*
     * takes a given queue and reverses its contents
     */
    public static void reverseQueue(Queue<Object> queue){
        if(!queue.isEmpty()){
            Stack<Object> s = new LLStack();
            do{
                s.push(queue.remove());
            }while(!queue.isEmpty());
            do{
                queue.insert(s.pop());
            }while(!s.isEmpty());
        }
        else{return;}
    }
    public static void main(String[] args){
        Stack<Object> s = new ArrayStack(5);
        s.push(10);
        s.push(3);
        s.push(7);
        s.push(2);
        s.push(5);
        System.out.println("stack before:"+s.toString());
        reverseStack(s);
        System.out.println("stack after:"+s.toString());
        Queue<Object> q = new ArrayQueue(5);
        q.insert(5);
        q.insert(2);
        q.insert(7);
        q.insert(3);
        q.insert(10);
        System.out.println("queue before:"+q.toString());
        reverseQueue(q);
        System.out.println("queue after:"+q.toString());


    }
}
