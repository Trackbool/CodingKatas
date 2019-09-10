import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.function.Predicate;

public class ArrayUtilsTest {

    @Test
    public void getElementsThatMeetConditionTest() {
        String[] elements = {"ADRI", "irene", "Jesucristo", "ERNESTO", "Maria"};
        String[] resultElements = ArrayUtils.getElementsThatMeetCondition(
                elements, string -> string.equals(string.toUpperCase()));

        Assertions.assertEquals("[ADRI, ERNESTO]", Arrays.toString(resultElements));
    }
}
