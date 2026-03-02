package scenario;

import java.util.*;

/**
 * OrderedStream stores values and returns them in order when possible.
 */
class OrderedStream {

    private String[] stream;
    private int ptr;

    /**
     * Constructor initializes the stream with size n.
     *
     * @param n size of stream
     */
    public OrderedStream(int n) {
        stream = new String[n + 1]; // 1-indexed, because values comes with value 1 instead of 0. so to avoid exception
        ptr = 1;
    }

    /**
     * Inserts value at given id and returns the largest ordered chunk
     * starting from current pointer.
     *
     * @param idKey index to insert
     * @param value value to insert
     * @return ordered list of values
     */
    public List<String> insert(int idKey, String value) {
        stream[idKey] = value;
        List<String> result = new ArrayList<>();

        while (ptr < stream.length && stream[ptr] != null) {
            result.add(stream[ptr]);
            ptr++;
        }

        return result;
    }
}

/**
 * Driver program to test OrderedStream
 */
public class OrderedStreamDemo {

    public static void main(String[] args) {

        OrderedStream os = new OrderedStream(5);

        System.out.println(os.insert(3, "ccccc"));
        System.out.println(os.insert(1, "aaaaa"));
        System.out.println(os.insert(2, "bbbbb"));
        System.out.println(os.insert(5, "eeeee"));
        System.out.println(os.insert(4, "ddddd"));
    }
}

/*
Problem: Ordered Stream

You are asked to implement a class called OrderedStream that stores values at given positions and returns them in order whenever possible.

Think of it as a stream of data that can arrive out of order, but you want to read it in order.

1️⃣ What the class looks like
class OrderedStream {
    public OrderedStream(int n) { ... }
    public List<String> insert(int id, String value) { ... }
}

n = total number of values expected

id = position (1-based) where this value belongs

value = the actual value to store

insert() → returns all values from the current position onward in order

2️⃣ Example to make it concrete

Suppose n = 5:

ids: 1 2 3 4 5
values: null null null null null  (initially empty)
Insert 3
insert(3, "ccccc")

Value 3 is inserted

Current pointer is at 1

Since 1 is empty → nothing can be returned yet

Returns: []

Insert 1
insert(1, "aaaaa")

Pointer at 1 → has value → start collecting in order

Pointer moves forward until the first missing value

We have: 1 → "aaaaa"

Next is 2 → missing → stop

Returns: ["aaaaa"]

Pointer now at 2

Insert 2
insert(2, "bbbbb")

Pointer at 2 → has value → start collecting

2 → "bbbbb", 3 → "ccccc", 4 → missing → stop

Returns: ["bbbbb", "ccccc"]

Pointer now at 4

Insert 5
insert(5, "eeeee")

Pointer at 4 → missing → nothing to return

Returns: []

Pointer still at 4

Insert 4
insert(4, "ddddd")

Pointer at 4 → has value → start collecting

4 → "ddddd", 5 → "eeeee" → stop

Returns: ["ddddd", "eeeee"]

Pointer now at 6 (past end)
 */
