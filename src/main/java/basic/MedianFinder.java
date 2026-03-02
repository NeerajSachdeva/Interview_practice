package basic;

import java.util.*;

public class MedianFinder {

    // TreeMap stores number → count
    private TreeMap<Integer, Integer> map = new TreeMap<>();
    private int size = 0;

    // Add number
    public void add(int num) {
        map.put(num, map.getOrDefault(num, 0) + 1);
        size++;
    }

    // Remove number
    public boolean remove(int num) {
        if (!map.containsKey(num)) return false;
        if (map.get(num) == 1) map.remove(num);
        else map.put(num, map.get(num) - 1);
        size--;
        return true;
    }

    // Find median
    public double findMedian() {
        if (size == 0) throw new NoSuchElementException();

        int mid1 = (size + 1) / 2; // 1-based index
        int mid2 = (size % 2 == 0) ? mid1 + 1 : mid1;

        int count = 0;
        int median1 = 0, median2 = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            count += entry.getValue();
            if (count >= mid1 && median1 == 0) median1 = entry.getKey();
            if (count >= mid2) {
                median2 = entry.getKey();
                break;
            }
        }

        return (median1 + median2) / 2.0;
    }

    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.add(10);
        mf.add(20);
        mf.add(30);
        System.out.println("Median: " + mf.findMedian()); // 20.0
        mf.remove(20);
        System.out.println("Median: " + mf.findMedian()); // 20.0 (10+30)/2
    }
}