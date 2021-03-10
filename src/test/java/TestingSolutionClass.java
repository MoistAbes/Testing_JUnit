import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TestingSolutionClass {

    @Nested
    @DisplayName("Testing Adder class")
    class TestingAdderClass{
        Adder adder = new Adder();

        @Test
        @DisplayName("Testing Arithmetic add method")
        public void testingArithmeticAddMethod(){
            Assertions.assertEquals(5,adder.add(2, 3));
        }
    }

    @Nested
    @DisplayName("Testing MyBook class")
    class TestingMyBookClass{
        MyBook myBook = new MyBook();

        @ParameterizedTest
        @DisplayName("Testing MyBook class overriden setTitle method")
        @ValueSource(strings = {"Krzyzacy"})
        void testingMyBookClassOverridenSetTitleMethod(String expectedTitle){
            myBook.setTitle(expectedTitle);

            Assertions.assertEquals("Krzyzacy", myBook.getTitle());
        }

    }


}
