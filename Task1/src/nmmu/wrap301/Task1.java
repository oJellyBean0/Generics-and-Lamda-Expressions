package nmmu.wrap301;

/**
 * Created by s2133 on 2017/02/16.
 */
public class Task1 {
    public static void main(String[] args) {

        Stack<Integer> listOfNumbers = new Stack<>();
        Stack<String> listOfStrings = new Stack<>();

        //Testing the stack with integers
        System.out.println("-----Testing the stack by pushing and popping integers-----");
        System.out.println("Is the list empty?");
        System.out.println(listOfNumbers.empty()+"\n");
        listOfNumbers.push(8);
        listOfNumbers.push(6);
        listOfNumbers.push(3);

        System.out.println("Pushed items onto stack");
        System.out.println("Current stack:");
        System.out.println("Bottom of stack");
        listOfNumbers.display();
        System.out.println("Top of stack");
        System.out.println();

        listOfNumbers.pop();
        System.out.println("Is the list empty?");
        System.out.println(listOfNumbers.empty()+"\n");
        System.out.println("Popped last item");
        System.out.println("Current stack:");
        System.out.println("Bottom of stack");
        listOfNumbers.display();
        System.out.println("Top of stack");
        System.out.println();
        System.out.println("Peeking at last item in stack");
        System.out.println(listOfNumbers.peek());
        System.out.println();
        
        //Testing the stack with strings
        System.out.println("-----Testing the stack by pushing and popping strings-----");
        System.out.println("Is the list empty?");
        System.out.println(listOfStrings.empty()+"\n");
        listOfStrings.push("Laptop");
        listOfStrings.push("Charger");
        listOfStrings.push("Monitor");
        System.out.println("Pushed items onto stack");
        System.out.println("Current stack:");
        System.out.println("Bottom of stack");
        listOfStrings.display();
        System.out.println("Top of stack");
        System.out.println();

        listOfStrings.pop();
        System.out.println("Is the list empty?");
        System.out.println(listOfNumbers.empty()+"\n");
        System.out.println("Popped last item");
        System.out.println("Current stack:");
        System.out.println("Bottom of stack");
        listOfStrings.display();
        System.out.println("Top of stack");
        System.out.println();
        System.out.println("Peeking at last item in stack");
        System.out.println(listOfStrings.peek());
        System.out.println();
    }
}
