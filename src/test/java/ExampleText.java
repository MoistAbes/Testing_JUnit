import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.awt.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ExampleText {

    @Test
    void shouldShowSimpleAssertion() {
        Assertions.assertEquals(1, 1);
    }

    @Test
    @Disabled
    void failingTest(){
        fail("a failing test");
    }

    @Test
    @DisplayName("Nazwa testu")
    void displayTestName(){

    }

    // Pierwszy kozak test
    @Test
    @DisplayName("Should check all items in the list")
    void shouldCheckAllItemsInTheList(){
        List<Integer> numbers = List.of(2, 3, 5, 7);
        //po pierwszym nieudanym tescie reszta sie nie sprawdzi
        Assertions.assertEquals(2, numbers.get(0));
        Assertions.assertEquals(3, numbers.get(1));
        Assertions.assertEquals(5, numbers.get(2));
        Assertions.assertEquals(7, numbers.get(3));
        //fail("Not implemented");
    }

    //ulepszenie pierwszego kozak testu

    @Test
    @DisplayName("Should check all items in the list v2")
    void shouldCheckAllItemsInTheListv2() {
        List<Integer> numbers = List.of(2, 4, 7, 9);
        //asserAll pozwala sprawdzic wszystkie elementy nawet jesli ktorys z nich sie nie powiedzie
        Assertions.assertAll(() -> assertEquals(2, numbers.get(0)),
                             () -> assertEquals(4, numbers.get(1)),
                             () -> assertEquals(7, numbers.get(2)),
                             () -> assertEquals(9, numbers.get(3)));
        //fail("not implemented");
    }

    @Test
    @DisplayName("AssumptionsTesting")
    void AssumptionsTesting() {

        // define the range
        int max = 10;
        int min = 1;
        int range = max - min + 1;

        int randomNumber = (int)(Math.random() * range) + min;
        System.out.println("Random number = :" + randomNumber);

        //assumeTrue sprawdza czy dane stwierdzenie jest prawdziwe
        Assumptions.assumeTrue(randomNumber > 5);

        //fail("not implemented");
    }

    /*
        test z parametrami wykona sie tyle razy ile jest parametrów w tym wypadku 2
        @ParameterizedTest mówi o tym ze jest to test z parametrami
        name = {0} jakims cudem sprawia ze nazy testow rownaja sie wartoscia przekazywanych parametrow w tym wypadku
        3 i 4

     */

    @ParameterizedTest (name = "{0}")
    @DisplayName("Testing test with parameters")
    @ValueSource(ints = {3, 4})
    void testingTestWithParameters(int expectedNumber) {

        switch (expectedNumber) {
            case 3: {
                assertEquals(expectedNumber, 3);
                break;
            }
            case 4: {
                 assertEquals(expectedNumber, 4);
            }
         }
    }

    /*
    Testowanie wyrzucania wyjatkow
     */

    @ParameterizedTest
    @DisplayName("Testing AssertThrows")
    @ValueSource(ints = {1, 2, Integer.MAX_VALUE})
    void testingAssertThrows(int expectedNumber) {

        assertThrows(IllegalArgumentException.class, () -> new Shape(expectedNumber));

        //fail("not implemented");
    }


    /*
    Testowanie zagniezdzonych klas do testowania
     */

    @Nested
    @DisplayName("When a shave has been created")
    class WhenShapeExist{
        private final Shape shape = new Shape(4);

        @Nested
        @DisplayName("Should allow")
        class ShouldAllow{
            @Test
            @DisplayName("seeing the number of sides")
            void seeingTheNumberOfSides(){

            }

            @Test
            @DisplayName("seeing the description")
            void seeingTheDescription(){
                assertEquals("Square", shape.description());
            }
        }

        @Nested
        @DisplayName("Should not allow")
        class ShouldNotAllow{
            @Test
            @DisplayName("Be equal to another shape with the same number of sides")
            void beEqualToAnotherShapeWithTheSameNumberOfSides(){
                System.out.println(new Shape(4).equals(new Shape(4)));
                assertNotEquals(new Shape(4), shape);
            }
        }
    }

    @Nested
    @DisplayName("When square exist")
    class WhenSquareExist extends WhenShapeExist{
        private final Square square = new Square();

        @Nested
        @DisplayName("Should allow")
        class ShouldAllow{

            @Test
            @DisplayName("Seeing the description")
            void seeingTheDescription(){
                assertEquals("I'm a square", square.description());
            }

            @Test
            @DisplayName("Seeing the number of sides")
            void seeingTheNumberOfSides(){
                assertEquals(4, square.getNumberOfSides());
            }
        }

        @Nested
        @DisplayName("Should not allow")
        class ShouldNotAllow{

            @Test
            @DisplayName("Two objects of type square are not the same")
            void twoObjectsOfTypeSquareAreNotTheSame(){
                assertNotEquals(new Square(), square);
            }
        }
    }

    @Nested
    @DisplayName("When Triangle is created")
    class WhenTriangleIsCreated{
        Triangle triangle = new Triangle();

        @Nested
        @DisplayName("Should allow")
        class ShouldAllow{

            @Test
            @DisplayName("Seeing the description")
            void seeingTheDesciprion(){
                assertEquals("I'am triangle", triangle.description());
            }

            @Test
            @DisplayName("Seeing the number of sides")
            void seeingTheNumberOfSides(){
                assertEquals(3, triangle.getNumberOfSides());
            }

        }

        @Nested
        @DisplayName("Should not allow")
        class ShouldNotAllow{

            @Test
            @DisplayName("beeing equals to another triangle of the same values")
            void beeingEqualsToAnotherTriangeOfTheSameValues(){
                assertNotEquals(triangle, new Triangle());
            }
        }
    }

}

