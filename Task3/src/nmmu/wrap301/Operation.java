package nmmu.wrap301;

/**
 * Created by s2133 on 2017/02/24.
 */
@FunctionalInterface
public interface Operation<T> {
    public void runOperation(T value);
}
