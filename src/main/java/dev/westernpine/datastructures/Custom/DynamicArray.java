package dev.westernpine.datastructures.Custom;

public class DynamicArray<T> {
    private static final double THRESHOLD = 0.33;
    private static final double DENOMINATOR = 2.0;
    private static final double FACTOR = 1.5;
    private static final int DEFAULT_CAPACITY = 5;

    private int size = 0;
    private Object[] array;


    public DynamicArray() {
        array = new Object[DEFAULT_CAPACITY];
    }

    public DynamicArray(int capacity) {
        array = new Object[capacity];
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return array.length;
    }

    public void add(T item) {

        if(size >= capacity())
            grow();

        array[size] = item;

        size++;

    }

    public void insert(int index, T item) {

        if(index >= size) {
            add(item);
            return;
        }

        if(size >= capacity())
            grow();

        for(int i = size; i > index; i--)
            array[i] = array[i-1];

        array[index] = item;
        size++;

    }

    public void delete(T item) {
        for(int i = 0; i < size; i++) { // Go through each element from the left.
            if(array[i] == item) { // Once item is found...
                for(int j = 0; j < ((size-1) - i); j++) {   // Generate a number that when combined with i, will not exceed the index of the last element.
                                                            // If it's the last element, don't process it since we're setting it to null, and because we can hit a IndexOutOfBoundsException on the next line if our array is full.
                    array[i+j] = array[i+j+1]; // Then set each element to it's next element value. (Move remaining elements to left)
                }
                array[size-1] = null; // And finally reset the last element.
                size--;

                if(size <= capacity() * THRESHOLD)
                    shrink();

                break;
            }
        }
    }

    public int search(T item) {
        for(int i = 0; i < size; i++)
            if(array[i] == item)
                return i;
       return -1;
    }

    private void grow() {
        int newCapacity = capacity() * 2;
        Object[] newArray = new Object[newCapacity];
        if (size >= 0)
            System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    private void shrink() {
        int newCapacity = (int) (capacity() * THRESHOLD);
        Object[] newArray = new Object[newCapacity];
        if (size >= 0)
            System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        for(int i = 0; i < size; i++) {
            stringBuilder.append(array[i]);
            if(i != size-1)
                stringBuilder.append(", ");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    private T cast(Object object) throws ClassCastException {
        return (T)object;
    }

}
