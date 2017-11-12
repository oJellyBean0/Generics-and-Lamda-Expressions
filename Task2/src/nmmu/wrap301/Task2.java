package nmmu.wrap301;

import java.util.Scanner;

/**
 * Created by s2133 on 2017/02/16.
 */
public class Task2 {

    static MeanCalculator newMeanCalculator = new MeanCalculator();
    static String[] listOfNumbers;
    static Scanner scanner = new Scanner(System.in);

     /**
     * An entry point into the program
     * @param args
     */
    public static void main(String[] args) {
        Menu mainMenu = buildMenu();

        mainMenu.run();
    }

    /**
     * The submenu passed through is run from here.
     * @param newMenu the submenu needed to be run
     */
    public static void runSubMenu(Menu newMenu){
        newMenu.run();
    }

    /**
     * The menu is built here with all the functionality (Main menu and the sub-menu is added)
     * @return The whole menu is returned
     */
    private static Menu buildMenu(){
        Menu mainMenu = new Menu("Main menu:", false);
        Menu subMenuSetMean = new Menu("Set mean (sub-menu)", true);
        Menu subMenu = new Menu("Array options (sub-menu)", true);

        mainMenu.addChoice(new Pair<>("Set mean (sub-menu)", () -> runSubMenu(subMenuSetMean)));
        mainMenu.addChoice(new Pair<>("Array options (sub-menu)", () -> runSubMenu(subMenu)));

        Pair<String,Runnable>  setToArithmetic = new Pair<>("Set type to Arithmetic", Task2::setToArithmetic);// task 2 refers to the object containing the method we want to call
        //and then setToArithmetic calls the method.
        subMenuSetMean.addChoice(setToArithmetic);

        Pair<String,Runnable> setToGeometric = new Pair<>("Set type to Geometric", () -> setToGeometric());
        subMenuSetMean.addChoice(setToGeometric);

        Pair<String,Runnable>  setToHarmonic = new Pair<>("Set type to Harmonic",() -> setToHarmonic());
        subMenuSetMean.addChoice(setToHarmonic);

        Pair<String,Runnable>  addValues = new Pair<>("Add a value/values to the set",() -> addValues());
        subMenu.addChoice(addValues);

        Pair<String,Runnable>  clearSet = new Pair<>("Clear the set",() -> clearSet());
        subMenu.addChoice(clearSet);

        Pair<String,Runnable>  removeNumbers = new Pair<>("Remove the last n numbers",() -> removeNumbers());
        subMenu.addChoice(removeNumbers);

        Pair<String,Runnable>  displaySet = new Pair<>("Display the set",() -> displaySet());
        subMenu.addChoice(displaySet);

        Pair<String,Runnable>  calculateMean = new Pair<>("Calculate the mean",() -> calculateMean());
        mainMenu.addChoice(calculateMean);


        return  mainMenu;
    }

    /**
     * Sets the mean type to Arithmetic
     */
    public static void setToArithmetic(){
        newMeanCalculator.setType(MeanCalculator.ARITHMETIC);
    }

    /**
     * Sets the mean type to Geometric
     */
    public static void setToGeometric(){
        newMeanCalculator.setType(MeanCalculator.GEOMETRIC);
    }

    /**
     * Sets the mean type to Harmonic
     */
    public static void setToHarmonic(){newMeanCalculator.setType(MeanCalculator.HARMONIC);}

    /**
     * Receives the values from the user, checks if they are valid and then adds them into the meanCalculator data structure
     */
    public static void addValues() {
        boolean continu = true;
        while (continu) {
            System.out.println("Enter the values to add to the set: ");
            System.out.println("Use . to indicate decimals and , to separate each value in the set");
            String numbers = scanner.nextLine();
            listOfNumbers = numbers.split(",");
            Boolean allNumbersValid = true;
            for (int ii = 0; ii < listOfNumbers.length; ii++) {
                if (isDouble(listOfNumbers[ii]) == false) {
                    allNumbersValid = false;
                }
            }
            if (allNumbersValid == true)
                break;
            else {
                System.out.println("Some invalid numbers entered. Re-enter all numbers. ");
            }
        }
        for (int i = 0; i < listOfNumbers.length; i++) {

            newMeanCalculator.addValuesToSet(Double.parseDouble(listOfNumbers[i]));
        }
    }

    /**
     * Calls the method that removes the last n numbers from the list
     */
    public static void removeNumbers(){
        System.out.println("Enter the number of last numbers to remove");
        int num = scanner.nextInt();
        newMeanCalculator.removeValues(num);
    }

    /**
     * Calls the method that clears the set
     */
    public static void clearSet(){

        newMeanCalculator.clear();
    }

    /**
     * Calls the method that displays the set
     */
    public static void displaySet(){
        newMeanCalculator.display();
    }

    public static void calculateMean(){
        System.out.println(newMeanCalculator.toString());
        System.out.println();
    }

    /**
     * Checks if the string is a double.
     * @param str is the value passed to be checked
     * @return A boolean is return to identify whether the given string is a double or not
     */
    private static boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (Exception e) {}
        return false;
    }


    }


