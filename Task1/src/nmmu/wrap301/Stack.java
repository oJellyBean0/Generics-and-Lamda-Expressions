package nmmu.wrap301;

import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * Created by s2133 on 2017/02/16.
 */
public class Stack<T> {

    private ArrayList<T> List = new ArrayList<T>();

    /**
     * Puts an item on to the top of the stack.
     * @param item is what is put on the top of the stack.
     */
    public void push(T item){
        List.add(item);
    }

    /**
     * Takes of the item that is on the top on the stack
     * @return returns the top item on the stack.
     */
    public T pop(){
        T item = peek();
        List.remove(List.size()-1);
        return item;
    }

    /**
     * Checks what the top item is on the stack.
     * @return the top item on the stack is returned
     */
    public T peek(){
        if(List.size()==0){
            throw new EmptyStackException();
        }

        T item = List.get(List.size()-1);
        return item;
    }

    /**
     * Checks if the stack is empty
     * @return true is returned if the stack is empty and false is returned if it is not empty.
     */
    public boolean empty(){
        if (List.size()==0)
            return true;
        else return false;
    }

    /**
     * Displays every item in the stack.
     */
    public void display(){
        for (T obj:List) {
            System.out.println(obj);
        }
    }

}
