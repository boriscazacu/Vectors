package md.unifun;

import com.unifun.Main;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class GenericMethodTest {
    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static < E > void printArray( E[] inputArray ) {
        // Display array elements
        for(E element : inputArray) {
            System.out.printf("%s ", element);
        }
    }


    public static void main(String args[]) {
        PropertyConfigurator.configure("log4j.properties");

        Integer[] intArray = { 1, 4, 2, 3, 5 };
        Double[] doubleArray = { 1.1, 3.3, 4.4, 2.2 };
        Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };
        Double[] arrayOfDoubles = {0.35, 0.02, 0.36, 0.82, 0.27, 0.49, 0.41, 0.17, 0.30, 0.89, 0.37, 0.66, 0.82,
                0.17, 0.20, 0.96, 0.18, 0.25, 0.37, 0.52};

        BubbleSortGeneric<Double> bubbleSortGeneric = new BubbleSortGeneric<>(arrayOfDoubles);
        BubbleSortGeneric<Character> string = new BubbleSortGeneric<>(charArray);


        bubbleSortGeneric.bubbleSort();
        LOGGER.info(bubbleSortGeneric.toString());
        LOGGER.info(bubbleSortGeneric.sumOfArray());

        string.bubbleSort();
        LOGGER.info(string.toString());
        string.sumOfArray();


    }
}