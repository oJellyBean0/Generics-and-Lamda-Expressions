package nmmu.wrap301;


import java.util.ArrayList;


/**
 * Created by s2133 on 2017/02/06.
 */
public class MeanCalculator {

    private ArrayList<Double> ArrayX = new ArrayList<>();

    public static int ARITHMETIC = 0;
    public static int GEOMETRIC = 1;
    public static int HARMONIC = 2;

    private int selected=0;

    /**
     * Sets the method for calculating the mean to either Arithmetic,
     * Geometric or Harmonic.
     * @param num The number relating to the selected type. Either Arithmetic,
     *            Geometric or Harmonic.
     */
    public void setType(int num){
        selected = num;
        if (num>2||num<0)
            System.out.println(getType());
        else
            System.out.println("Mean type is set to "+getType());
        System.out.println();
    }

    /**
     * Gets the type of mean to be calculated.
     * @return A string is returned with the name of the type of mean.
     */
    public String getType(){
        if (selected == ARITHMETIC)
            return "Arithmetic";
        else if (selected == GEOMETRIC)
            return "Geometric";
        else if (selected== HARMONIC)
            return "Harmonic";
        else return "Invalid type";

    }

    /**
     * Calculates the Arithmetic mean.
     * @return The Arithmetic mean is returned of the values.
     */
    private double getArithmetic(){
        double sum = 0;
        for (int ii = 0; ii<ArrayX.size();ii++)
        {
            sum+= ArrayX.get(ii);
        }
        return sum/(ArrayX.size());

    }

    /**
     * Calculates the Geometric mean.
     * @return The Geometric mean is returned of the values.
     */
    private double getGeometric(){
        double sum = 1;
        for (int ii = 0; ii<ArrayX.size();ii++)
        {
            sum= sum*ArrayX.get(ii);
        }
        return Math.pow(sum,(1/(1.0*ArrayX.size())));
    }

    /**
     * Calculates the Harmonic mean.
     * @return The Harmonic mean is returned of the values.
     */
    private double getHarmonic(){
        double sum = 0;
        for (int ii = 0; ii<ArrayX.size();ii++)
        {
            sum= sum+(1.0/ArrayX.get(ii));
        }
        return (ArrayX.size())*Math.pow(sum,-1);
    }

    /**
     * Finds the mean of the selected type.
     * @return Returns the mean of the selected type depending on if
     * it is Arithmetic, Geometric or Harmonic.
     */
    public double getMean(){
        //checks what type of mean is needed to be calculated
        if (selected == ARITHMETIC)
            return getArithmetic();
        else if (selected == GEOMETRIC)
            return getGeometric();
        else if (selected== HARMONIC)
            return getHarmonic();
        else return 0;
    }

    /**
     * Allows an additional value to be appended to the current values in the set
     * (called neumorous times from Task 1 if multiple values need to be added)
     * @param value is the number being added to the set
     */
    public void addValuesToSet(double value){
            ArrayX.add(value);
    }



    /**
     * Returns a report including the listing of all the current values ing the set and the mean value
     * of the selected method.
     * @return A string is returned with all values listed and the mean (if mean type is not set then
     * the default is Arithmetic.
     */
    @Override
    public String toString(){
        String valuesList ="";


        if (ArrayX.size()==0)
            return "No values in the set \n";

        //Finding the mean of the Merge array
        for (int ii= 0;ii<ArrayX.size();ii++){
            if (ii == 0)
                valuesList+= "Default type is Arithmetic \nThe "+getType()+" Mean value of {"+ ArrayX.get(ii)+", ";
            else if(ii==ArrayX.size()-1)
                valuesList+= ArrayX.get(ii)+"} ";
            else valuesList+= ArrayX.get(ii)+", ";

        }
        valuesList+= "is "+ getMean();
        return valuesList;
    }

    /**
     * Clears all the values in the set
     */
    public void clear(){
        ArrayX.clear();
    }

    /**
     * Displays all the values in the set.
     */
    public void display(){
        if(ArrayX.size()==0)
            System.out.println("No values in the set \n");
        else {
            String values = "The values in the set are: ";
            for (int ii = 0; ii < ArrayX.size(); ii++) {
                if (ii == ArrayX.size() - 1)
                    values += (Double.toString(ArrayX.get(ii)));
                else
                    values += (Double.toString(ArrayX.get(ii)) + ", ");
            }
            System.out.println(values +"\n");
        }
    }

    /**
     * Removes a set number of values from the end of the set.
     * @param num is the number of values that are removed from the set.
     */
    public void removeValues(int num){
        if (num>=ArrayX.size())
            clear();
        else {
            for (int ii = 0; ii < num; ii++){
                ArrayX.remove(ArrayX.size()-1);
            }
        }
    }

}
