package dev.westernpine.datastructures;

import java.util.Hashtable;

public class HashTableDS {

    public static void main() {

        /*
         * Hash tables work by serializing the key with the capacity of the table to get its position in the map.
         * This is why they have a constant run-time O(1) and are commonly used to store and search data.
         * Their capacity is also easily modifiable just like a dynamic array.
         *
         * Because of this, the best case of time complexity is O(1),
         * but the worst case is O(n) is all entries are collisions. This would be the complexity of a linked list.
         */

        int aKey = 0;
        assert 0 == Integer.hashCode(aKey); // The hashCode of an int is just the int.

        // Great, now for collisions...
        assert "".hashCode() == "".hashCode();

        //Well each bucket in a table is actually a linked list of key -> value pairs.


        Hashtable<String, String> table = new Hashtable<>(10);

        table.put("100", "Gabe");
        table.put("123", "Jared"); // This is in the same bucket as the next item when the capacity is 10.
        table.put("321", "Taylor");
        table.put("555", "Nick");
        table.put("777", "Tonya");

        assert "123".hashCode() % 10 == "321".hashCode() % 10;

    }

}
