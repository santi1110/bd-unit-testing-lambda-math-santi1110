package com.amazon.ata.unittesting.math;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * We're keeping the tests for {@code add()} from the pre-work, and adding new ones for {@code average()}.
 */
public class AtaMathTest {

    // add()

    @Test
    public void add_singleInteger_returnsTheInteger() {
        // GIVEN
        int[] oneInteger = {42};
        AtaMath ataMath = new AtaMath();

        // WHEN
        int result = ataMath.add(oneInteger);

        // THEN
        assertEquals(42, result, "Expected adding a single int to return the int");
    }

    @Test
    public void add_twoIntegers_returnsTheirSum() {
        // GIVEN
        int[] tuple = {6, 9};
        AtaMath ataMath = new AtaMath();

        // WHEN
        int result = ataMath.add(tuple);

        // THEN
        assertEquals(15, result, String.format(
                "Expected adding two ints (%s) to return their sum (15)",
                Arrays.toString(tuple))
        );
    }

    @Test
    public void add_emptyArray_returnsZero() {
        // GIVEN
        int[] emptyArray = {};
        AtaMath ataMath = new AtaMath();

        // WHEN
        int result = ataMath.add(emptyArray);

        // THEN
        assertEquals(0, result, "Expected empty array to sum to zero");
    }

    @Test
    public void add_nullArray_returnsZero() {
        // GIVEN
        int[] nullArray = null;
        AtaMath ataMath = new AtaMath();

        // WHEN
        int result = ataMath.add(nullArray);

        // THEN
        assertEquals(0, result, "Expected null array to sum to zero");
    }

    @Test
    public void add_sumOutOfBounds_throwsArithmeticException() {
        // GIVEN
        int[] values = {Integer.MAX_VALUE - 5, 3, 3};
        AtaMath ataMath = new AtaMath();

        // WHEN - attempt to compute the sum
        // THEN - exception thrown

        // the following syntax is a little fancy, just know that it's
        // asserting that when the second line calls the add()
        // method that we should see an `ArithmeticException` thrown
        assertThrows(ArithmeticException.class,
                () -> ataMath.add(values),
                "Summing above MAX_VALUE should result in ArithmeticException thrown");
    }

    @Test
    public void add_sumOutofBoundsUnderflow_throwsArithmeticException() {
        // GIVEN
        int[] values = {Integer.MIN_VALUE + 5, -3, -3};
        AtaMath ataMath = new AtaMath();

        // WHEN - attempt to compute the sum
        // THEN - exception thrown
        assertThrows(ArithmeticException.class,
                () -> ataMath.add(values),
                "Summing below MIN_VALUE should result in ArithmeticException thrown");
    }

    // average()

    @Test
    public void average_ofSingleInteger_isThatInteger() {
        //GIVEN
        int value = 1;
        int[] values = {value};
        AtaMath ataMath = new AtaMath();

        //WHEN
        Double result = ataMath.average(values);

        //THEN
        assertEquals(Double.valueOf(value),result,  "Expected average of single integer");

    }
    @Test
    public void average_of_SeveralIntegers_isCorrect(){
        //GIVEN

        int[] values = {2,3}; // 2.5
        AtaMath ataMath = new AtaMath();

        //WHEN
        Double result = ataMath.average(values);

        //THEN
        assertEquals(2.5,result,  "Expected average of two integer");


    }
    @Test
    public void average_ofNullArray_throwsIllegalArgumentException(){
        //GIVEN

        int[] values = null;
        AtaMath ataMath = new AtaMath();

        //THEN
        assertThrows(IllegalArgumentException.class,
                () -> ataMath.average(values),
                "Expected avergae(null) to throw IllegalArgumentException");

    }
    @Test
    public void average_ofPositiveAndNegativeIntegers_isCorrect(){
        //GIVEN
        int [] values = {3,-2}; //0.5
        AtaMath ataMath = new AtaMath();

        // WHEN
        Double result = ataMath.average(values);

        //THEN
        assertEquals(0.5, result, "Expected average of positive and negative numbers to be correct");
    }
    // PARTICIPANTS: ADD YOUR NEW TESTS HERE (and you can delete this line while you're at it)
}
