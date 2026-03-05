package basic;

import java.util.*;

class MedianFinder {

    private Map<Integer, Integer> intContainerMap = null;
    int containerSize;

    public MedianFinder() {
        intContainerMap = new TreeMap<>();
    }

    public int add(int value) {
        Integer mapValue = intContainerMap.get(value);

        if (mapValue == null) {
            intContainerMap.putIfAbsent(value, 1);
        } else {
            intContainerMap.put(value, ++mapValue);
        }

        ++containerSize;
        return containerSize;
    }

    public boolean delete(int value) {
        Integer mapValue = intContainerMap.get(value);
        if (mapValue == null) {
            return false;
        } else if (mapValue == 1) {
            intContainerMap.remove(value);
        } else {
            intContainerMap.put(value, mapValue - 1);

        }
        --containerSize;
        return true;
    }

    public Optional<Integer> getMedian() {
        if (containerSize == 0) {
            return Optional.empty();
        }

        int medianIndex = 0;
        if ((containerSize % 2 == 0)) {
            medianIndex = containerSize / 2;
        } else {
            medianIndex = (containerSize + 1) / 2;
        }

        int count = 0;
        int result = 0;

        for (Map.Entry<Integer, Integer> entry : intContainerMap.entrySet()) {
            count += entry.getValue();

            if (count >= medianIndex) {
                result = entry.getKey();
                break;
            }
        }


        return Optional.of(result);
    }
}
