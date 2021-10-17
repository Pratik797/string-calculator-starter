package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class StringCalculatorShould {

    @Test
    void empty_string_should_return_0() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    void string_with_single_number_should_return_number_as_int() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(1, stringCalculator.add("1"));
    }

    private StringCalculator stringCalculator;

    @Before
    public void setUp() {
        stringCalculator = new StringCalculator();
    }

    @Test
    public void return_0_if_string_is_empty() {
        assertEquals(stringCalculator.add(""), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_IllegalArgumentException_if_string_is_not_a_number() {
        stringCalculator.add("1,s,3");
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_IllegalArgumentException_if_string_has_comma_as_a_first_character() {
        stringCalculator.add(",1,2,3");
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_IllegalArgumentException_if_string_has_duplicated_commas() {
        stringCalculator.add("1,,3");
    }

    @Test
    public void should_return_sum_when_passed_string_has_comma_as_last_character() {
        assertEquals(stringCalculator.add("1,2,3,"),6);
    }
}
