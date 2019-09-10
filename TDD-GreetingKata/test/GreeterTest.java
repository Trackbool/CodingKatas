import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GreeterTest {
    private Greeter greeter;

    public GreeterTest() {
        this.greeter = new Greeter();
    }

    @Test
    public void greetIsReturningResponseWithCorrectName() {
        String name = "Adri";
        String greet = greeter.greet(name);

        Assertions.assertEquals("Hello, Adri.", greet);
    }

    @Test
    public void greetIsReturningDefaultResponseIfNameIsNull() {
        String greet = greeter.greet((String) null);

        Assertions.assertEquals("Hello, my friend.", greet);
    }

    @Test
    public void greetIsReturningUppercaseResponseIfNameIsUppercase() {
        String name = "ADRI";
        String greet = greeter.greet(name);

        Assertions.assertEquals("HELLO, ADRI.", greet);
    }

    @Test
    public void greetIsGreetingOneNameFromArray() {
        String[] names = {"Adri"};
        String greet = greeter.greet(names);

        Assertions.assertEquals("Hello, Adri.", greet);
    }

    @Test
    public void greetIsGreetingTwoNamesFromArray() {
        String[] names = {"Adri", "Irene"};
        String greet = greeter.greet(names);

        Assertions.assertEquals("Hello, Adri and Irene.", greet);
    }

    @Test
    public void greetIsGreetingThreeNamesFromArray() {
        String[] names = {"Adri", "Irene", "Jesucristo"};
        String greet = greeter.greet(names);

        Assertions.assertEquals("Hello, Adri, Irene and Jesucristo.", greet);
    }

    @Test
    public void greetIsGreetingMultipleNamesFromArray() {
        String[] names = {"Adri", "Irene", "Jesucristo", "Turtle"};
        String greet = greeter.greet(names);

        Assertions.assertEquals("Hello, Adri, Irene, Jesucristo and Turtle.", greet);
    }

    @Test
    public void greetIsReturningUppercaseResponseForUpperCaseName() {
        String[] names = {"Adri", "Irene", "JESUCRISTO"};
        String greet = greeter.greet(names);

        Assertions.assertEquals("Hello, Adri and Irene. AND HELLO JESUCRISTO!", greet);
    }

    @Test
    public void greetIsReturningUppercaseResponseForUpperCaseNames() {
        String[] names = {"ADRI", "Irene", "JESUCRISTO"};
        String greet = greeter.greet(names);

        Assertions.assertEquals("Hello, " + names[1] + ". AND HELLO " + names[0] + "! AND HELLO "
                + names[2] + "!", greet);
    }

    @Test
    public void greetIsGreetingNamesSeparatedByCommaFromArray() {
        String[] names = {"Adri", "MANUEL", "Irene, Camila", "Jesucristo"};
        String greet = greeter.greet(names);

        Assertions.assertEquals("Hello, Adri, Irene, Camila and Jesucristo. AND HELLO MANUEL!", greet);
    }

    @Test
    public void greetIsGreetingNamesSeparatedByCommaFromArray_lastElement() {
        String[] names = {"Adri", "MANUEL", "Jesucristo", "Irene, Camila"};
        String greet = greeter.greet(names);

        Assertions.assertEquals("Hello, Adri, Jesucristo, Irene and Camila. AND HELLO MANUEL!", greet);
    }

    @Test
    public void greetIsGreetingNamesSeparatedByCommaEscapedFromArray() {
        String[] names = {"Adri", "MANUEL", "\"Irene, Camila\"", "Jesucristo"};
        String greet = greeter.greet(names);

        Assertions.assertEquals("Hello, Adri, Irene, Camila and Jesucristo. AND HELLO MANUEL!", greet);
    }

    @Test
    public void greetIsGreetingNamesSeparatedByCommaEscapedFromArray_lastElement() {
        String[] names = {"Adri", "MANUEL", "Jesucristo", "\"Irene, Camila\""};
        String greet = greeter.greet(names);

        Assertions.assertEquals("Hello, Adri, Jesucristo and Irene, Camila. AND HELLO MANUEL!", greet);
    }
}
