package lab01;

import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArrayUtilsTest {
    @Test
    void sayHi() {
        System.out.println("Hello from the test.");
    }

    // A sorted array
    @Test
    void sortedAAA() {
        int[] someArray = {1,2,3,4};       // arrange
        boolean someArraySorted = ArrayUtils.isSorted(someArray);  // act
        assertTrue(someArraySorted);       // assert
    }

    // Empty arrays are sorted by definition
    @Test
    void emptySorted() {
        int[] someEmtpyArray = { };          // arrange
        boolean emptyArraySorted = ArrayUtils.isSorted(someEmtpyArray);  // act
        assertTrue(emptyArraySorted);   // assert
    }
    // Arrays of one element are sorted by definition
    @Test
    void oneElementArraySorted() {
        int[] oneElementArray = {1};        // arrange
        boolean oneElementArraySorted = ArrayUtils.isSorted(oneElementArray);   // act
        assertTrue(oneElementArraySorted);   // assert
    }
    // A partially sorted array (some elements are in sorted order, but some aren't)
    @Test
    void partiallySortedArray() {
        int[] partiallyElements = {1, 3, 5, 6, 10, 7, 2};     // arrange
        boolean partiallySortedArray = ArrayUtils.isSorted(partiallyElements);    // act
        assertFalse(partiallySortedArray);   // assert
    }
    // A completely unsorted array (no elements are in sorted order)
    @Test
    void unsortedArray() {
        int[] unsortedElements = {4, 2, 5, 7, 11, 1, 9};    // arrange
        boolean unsortedArray = ArrayUtils.isSorted(unsortedElements);  // act
        assertFalse(unsortedArray);     // assert
    }
    // An array with duplicate values (may be sorted or not depending on the values chosen)
    @Test
    void arrayWithDuplicateValues1() {
        int[] sortedDuplicates = {1, 3, 4, 5, 5, 6, 7};     // arrange
        boolean arrayWithSortedDuplicates = ArrayUtils.isSorted(sortedDuplicates);     // act
        assertTrue(arrayWithSortedDuplicates); // assert
    }
    @Test
    void arrayWithDuplicateValues2() {
        int[] unsortedDuplicates = {1, 3, 4, 1, 6, 5};  // arrange
        boolean arrayWithUnsortedDuplicates = ArrayUtils.isSorted(unsortedDuplicates);  // act
        assertFalse(arrayWithUnsortedDuplicates);  // assert
    }

}



