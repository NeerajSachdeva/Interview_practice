package basic;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.TreeMap;

public class MedianFinderImprved {

        private TreeMap<Integer, Integer> map = new TreeMap<>();
        private int size = 0;
        private Integer loKey = null; // left median pointer
        private Integer hiKey = null; // right median pointer

        // Add a number
        public void add(int num) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            size++;
            adjustPointersOnAdd(num);
        }

        // Remove a number
        public boolean remove(int num) {
            if (!map.containsKey(num)) return false;

            int count = map.get(num);
            if (count == 1) map.remove(num);
            else map.put(num, count - 1);
            size--;
            adjustPointersOnRemove(num);
            return true;
        }

        // Get median
        public double findMedian() {
            if (size == 0) throw new NoSuchElementException();
            if (size % 2 == 1) return loKey;
            return (loKey + hiKey) / 2.0;
        }

        // Adjust pointers after adding a number
        private void adjustPointersOnAdd(int num) {
            if (size == 1) {
                loKey = hiKey = num;
                return;
            }

            if (size % 2 == 0) {
                // size becomes even → update hiKey
                if (num < loKey) hiKey = loKey;
                else hiKey = num;
            } else {
                // size becomes odd → update loKey
                if (num >= hiKey) loKey = hiKey;
                else loKey = num;
            }

            // Ensure loKey ≤ hiKey
            if (loKey > hiKey) {
                int tmp = loKey;
                loKey = hiKey;
                hiKey = tmp;
            }
        }

        // Adjust pointers after removing a number
        private void adjustPointersOnRemove(int num) {
            if (size == 0) {
                loKey = hiKey = null;
                return;
            }

            // Simple approximation: recompute loKey and hiKey
            int mid1 = (size + 1) / 2;
            int mid2 = (size % 2 == 0) ? mid1 + 1 : mid1;
            int count = 0;
            loKey = hiKey = null;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                count += entry.getValue();
                if (count >= mid1 && loKey == null) loKey = entry.getKey();
                if (count >= mid2) {
                    hiKey = entry.getKey();
                    break;
                }
            }
        }

        public static void main(String[] args) {
            MedianFinderImprved mf = new MedianFinderImprved();
            mf.add(10);
            mf.add(20);
            mf.add(30);
            System.out.println("Median: " + mf.findMedian()); // 20.0
            mf.remove(20);
            System.out.println("Median: " + mf.findMedian()); // 20.0 (10+30)/2
            mf.add(5);
            System.out.println("Median: " + mf.findMedian()); // 10.0
        }
    }