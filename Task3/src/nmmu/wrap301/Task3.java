package nmmu.wrap301;

import java.util.Random;

/**
 * Created by s2133 on 2017/02/20.
 */
public class Task3 {
    public static void main(String[] args) {
        SimpleSet<Integer> a = new SimpleSet<>();
        SimpleSet<Integer> b = new SimpleSet<>();
        SimpleSet<Integer> c = new SimpleSet<>();
        // add a maximum of 20 unique random numbers from 0..99
        Random rand = new Random();
        for (int i = 0; i < 20; i++) {
            a.add(rand.nextInt(100));
            b.add(rand.nextInt(100));
        }
        //Note: there should be no duplicate values in the console printed list of c
        c.add(new Integer[]{1,2,3,4,1,2,3,15,26,87,52,24,32,29,41,20,36,16,15,24});
        // display initial simple sets (should have no duplicates)
        System.out.print("a = {");
        a.foreach(value -> System.out.print(value + " "));
        System.out.println("}");
        // display set b as well (similar to code above)
        System.out.print("b = {");
        b.foreach(value -> System.out.print(value + " "));
        System.out.println("}");
        // display set c as well (similar to code above)
        System.out.print("c = {");
        c.foreach(value -> System.out.print(value + " "));
        System.out.println("}");

        // select all the even integers from set greater than 10 and less than 50,
        // then union them with all integers in set b less than 20, and then
        // display the resulting set, BTW this style of stringing operations
        // together is known as “method chaining1”
        System.out.println("\nTesting for set a with set b");
        a.select(value -> (value % 2) == 0) //Returning a set containing all the even numbers in a
                .select(value -> value < 50) //Returning a set containing all the numbers less than 50 from set a
                .select(value -> value > 10) //Returning a set containing all the numbers greater than 10 from set a
                .union(b.select(value -> value < 20))//combining all values from set b, that are less than 20, with set a
                .foreach(value -> System.out.println(value));
        System.out.println("\nTesting for set c with set b");
        c.select(value -> (value % 2) == 0) //Returning a set containing all the even numbers in c
                .select(value -> value < 50) //Returning a set containing all the numbers less than 50 from set c
                .select(value -> value > 10) //Returning a set containing all the numbers greater than 10 from set c
                .union(b.select(value -> value < 20)) //combining all values from set b, that are less than 20, with set c
                .foreach(value -> System.out.println(value));

    }
}
