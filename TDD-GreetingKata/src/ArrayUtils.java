import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ArrayUtils {

    public static String[] getElementsThatMeetCondition(String[] elements, Predicate<String> condition){
        List<String> resultElements = new ArrayList<>();
        for (String element : elements) {
            if (condition.test(element)) {
                resultElements.add(element);
            }
        }

        return resultElements.toArray(new String[0]);
    }
}
