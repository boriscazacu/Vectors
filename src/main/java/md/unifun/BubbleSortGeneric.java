package md.unifun;

import java.util.Arrays;

public class BubbleSortGeneric<T extends Comparable<? super T>> {
    private T [] array;

    public BubbleSortGeneric(T[] array){
        this.array = array;
    }

    void bubbleSort() {
        int n = this.array.length;
        while (n > 0) {
            int lastModifiedIndex = 0;
            for (int currentIndex = 1; currentIndex < n; currentIndex++) {
                if (array[currentIndex - 1].compareTo(array[currentIndex]) > 0) {
                    T temp = array[currentIndex - 1];
                    array[currentIndex - 1] = array[currentIndex];
                    array[currentIndex] = temp;
                    lastModifiedIndex = currentIndex;
                }
            }
            n = lastModifiedIndex;
        }
    }


    public <T extends Number>  T sumOfArray(){
        if (array[0] instanceof Double){
            Double sum = 0.0;
            for (int i = 0; i < array.length; i++) {
                Double element = (Double) array[i];
                sum += element;
            }
            return (T) new Double(sum.doubleValue());
        }else
            if (array[0] instanceof Double){
            Integer sum = 0;
            for (int i = 0; i < array.length; i++) {
                sum += (Integer) array[i];
            }
            return (T)new Integer(sum.intValue());
        }else
            if (array[0] instanceof Character){
            System.out.println("\nCharacters cannot be added");
            return null;
        }else {
            throw new IllegalArgumentException("Type  is not supported by this method");
        }
    }

    @Override
    public String toString() {
        return "BubbleSortGeneric{\n" +
                "  array=" + Arrays.toString(array) +
                '}';
    }
}