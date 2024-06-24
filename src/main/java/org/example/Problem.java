package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Collections;

public class Problem {
    public int numberOfItems;
    public int lowerBound;
    public int upperBound;
    public List<Item> items;

    public Problem(int n, int seed) {
        numberOfItems = n;
        items = new ArrayList<>();
        lowerBound = 1;
        upperBound = 10;
        Random random = new Random(seed);

        for (int i = 0; i < n; i++) {
            int value = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int weight = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            items.add(new Item(value, weight));
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Item item : items) {
            result.append("Value: ").append(item.value).append(", Weight: ").append(item.weight).append("\n");
        }
        return result.toString();
    }

    public Result solve(int capacity) {
        List<Item> sortedItems = new ArrayList<>(items);
        Collections.sort(sortedItems, (i1, i2) -> Double.compare((double) i2.value / i2.weight, (double) i1.value / i1.weight));

        List<Integer> itemIndices = new ArrayList<>();
        int totalValue = 0;
        int totalWeight = 0;

        while (capacity > 0) {
            Item bestItem = null;
            double bestRatio = 0.0;

            for (Item item : sortedItems) {
                if (item.weight <= capacity) {
                    double ratio = (double) item.value / item.weight;
                    if (ratio > bestRatio) {
                        bestRatio = ratio;
                        bestItem = item;
                    }
                }
            }

            if (bestItem != null) {
                itemIndices.add(items.indexOf(bestItem) + 1);
                totalValue += bestItem.value;
                totalWeight += bestItem.weight;
                capacity -= bestItem.weight;
            } else {
                break;
            }
        }

        return new Result(itemIndices, totalValue, totalWeight);
    }
}