package org.example;
import java.util.List;


public class Result {
    public List<Integer> itemIndices;
    public int totalValue;
    public int totalWeight;

    public Result(List<Integer> itemIndices, int totalValue, int totalWeight) {
        this.itemIndices = itemIndices;
        this.totalValue = totalValue;
        this.totalWeight = totalWeight;
    }

    @Override
    public String toString() {
        return "Item indices: " + itemIndices +
                ", Total value: " + totalValue +
                ", Total weight: " + totalWeight;
    }
}