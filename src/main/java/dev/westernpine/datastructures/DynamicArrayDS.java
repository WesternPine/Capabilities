package dev.westernpine.datastructures;

import dev.westernpine.datastructures.Custom.DynamicArray;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DynamicArrayDS {

    public static void main() {
        // FIFO
        // ArrayList<String> arrayList = new ArrayList<>();

        DynamicArray<String> da = new DynamicArray<>();

        assert da.isEmpty();

        da.add("Test1");
        da.add("Test2");
        assert !da.isEmpty();
        assert da.size() == 2;
        assert da.capacity() == 5;

        da.insert(0, "Testing");
        assert da.size() == 3;
        assert da.search("Testing") == 0;
        assert da.search("Test2") == 2;

        da.delete("Testing");
        assert da.size() == 2;
        assert da.search("Test2") == 1;

        da.add("Test3");
        da.add("Test4");
        da.add("Test5");
        da.add("Test6");
        assert da.capacity() == 10;


        da.delete("Test3");
        da.delete("Test4");
        da.delete("Test5");
        da.delete("Test6");
        assert da.capacity() == 3;
    }

}
