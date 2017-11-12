# Generics-and-Lamda-Expressions
## Objectives:

```
 Generics
 Lambda Expressions
```
## Task 1 : Stack <T>

In the WRA201/2 modules you learnt about the stack data structure. Implement a simple stack data
structure that uses generics to allow any data type to be added into the stack.

Note: you may not use the existing built-in queue data structure, at most you may internally use an
ArrayList.

Make appropriate use of inner classes, generics, etc. when implementing the data structure.

Provide a simple test application to demonstrate how your data structure functions and that it
functions in an appropriate manner.

## Task 2 : Console Menu App version 2.

Last week you were required to implement the Menu class and MenuChoice interface. Now you
must rewrite/modify them in the following manner:

1. The MenuChoice interface was used to store the _title_ **and** _behaviour_ of a menu choice and
    was not a functional interface. This interface will no longer be used and should be deleted
    from the solution. Instead the Runnable interface will be used that has a single method
    called run(). The Runnable functional interface will provide the _behaviour_ of a menu
    choice (the _title_ will be stored elsewhere – see #2).
2. The Menu must store the menu choices in (String text, Runnable action) pairs. The
    text is displayed for each choice when the menu is displayed and the action is run when that
    choice is selected by the user. Make use of the Pairs class discussed in class to store the
    menu choice pairs (make modifications to allow access by index number and to obtain a
    count of how many pairs there are).
3. Move the implementation of the menu choices that are actions, such as mean, display, etc.
    into individual methods in your main class (that contains the public static void
    main(String[] args) method). Change the inner class implementations of the
    MenuChoice interfaces to call these methods using Lambda expressions instead. In other
    words, the main class should have a method per menu choice action and the Lambda
    expressions should call the appropriate one where necessary.

Use the same example menu created for Task 2 in last week’s assignment to demonstrate that the
new implementation still works as before.


## Task 3 : Simple Set

Create a simple list-like generic data structure, called SimpleSet, that has the following features:

```
 The internal representation must use a basic array to store the values, i.e. Integer[] etc.
 Create a set using an appropriate constructor.
 Unique values are stored. Use the .equals method inherited from the Object class to
compare values in the set;
 Provide methods that process values in the set:
o select accepts a Lambda expression that examines a single value and returns true
if the value should be selected or false if not. The select method will create and
return a new simple set containing all the selected values;
o union accepts a simple set, create a new set that contains the union of both sets,
and returns the new set;
o foreach accepts a Lambda expression that performs an operation on each value in
the simple set in turn. Nothing is returned.
```
Then write an example application that demonstrates that the simple list data structure is
functioning correctly. Additionally, the following code should work as well:

```
SimpleSet<Integer> a = new SimpleSet<>();
SimpleSet<Integer> b = new SimpleSet<>();
```
```
// add a maximum of 20 unique random numbers from 0..99
Random rand = new Random();
for(int i=0; i<20; i++) {
a.add(rand.nextInt(100));
b.add(rand.nextInt(100));
}
```
```
// display initial simple sets (should have no duplicates)
System.out.print(“a = {“);
a.foreach(value -> System.out.print(value + “ “));
System.out.println(“}“);
```
```
// display set b as well (similar to code above)
System.out.print(“b = {“);
b.foreach(value -> System.out.print(value + “ “));
System.out.println(“}“);
```

```
// select all the even integers from set greater than 10 and less than 50,
// then union them with all integers in set b less than 20, and then
// display the resulting set, BTW this style of stringing operations
// together is known as “method chaining^1 ”
a.select(value -> (value % 2) == 0)
.select(value -> value < 50)
.select(value -> value > 10)
.union(b.select(value -> value < 20))
.foreach(value -> System.out.println(value));
```
