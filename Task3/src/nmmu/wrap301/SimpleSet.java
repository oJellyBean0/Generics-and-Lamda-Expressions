package nmmu.wrap301;


import java.util.HashSet;
import java.util.Set;

/**
 * Created by s2133 on 2017/02/20.
 */
public class SimpleSet<T> {

        Set<T> list = new HashSet<>();

    /**
     * Adds a value to the list
     * @param newValue the value to be added
     */
    public void add(T newValue)
    {
        list.add(newValue);
    }

    public void add(T[] newArray){
        for (int i = 0; i < newArray.length; i++) {
            list.add(newArray[i]);
        }
    }

    /**
     * Accepts a Lambda expression that examines a single value and returns true
     * if the value should be selected or false if not. The select method will create
     * and return a new simple list containing all the selected values
     *
     * @return SimpleSet containing all values that meet the condition.
     */
    public SimpleSet<T> select(FunctionalSelect<T> checkSelected)
    {
        SimpleSet<T> newList = new SimpleSet<>();


        for(T obj:list){
            if(checkSelected.select(obj))
                newList.add(obj);
        }
        return newList;

    }

    /**
     * accepts a Lambda expression that performs an operation on
     * each value in the simple set in turn. Nothing is returned
     */
    public void foreach(Operation<T> operation)
    {
        for (T obj:list) {
            operation.runOperation(obj);
        }

    }

    /**
     * Accepts a simple set, creates a new set that contains the union of both sets,
     * and returns the new set.
     * @param set is the SimpleSet that is sent in to be combined with
     * @return A new set is returned that contains a combination of the two sets
     */
    public SimpleSet<T> union(SimpleSet<T> set){
        SimpleSet<T> tempSimple = new SimpleSet<>();
        Set<T> tempSet = new HashSet<>(list);
        tempSet.addAll(set.list);
        tempSimple.list = tempSet;
        return tempSimple;
    }


}
