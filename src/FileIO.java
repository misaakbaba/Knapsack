import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO { // file read object and its instances
    Knapsack knapsack[];
    private int capacity;
    private int numberOfItems;
    private ArrayList<Keys> items;
    //multi
    private int totalVal;
    private int knapsackNumber;
    private ArrayList<Keys> multiItems;

    public FileIO() {
        items = new ArrayList<>();
        multiItems = new ArrayList<>();
    }

    void reader(String path) throws FileNotFoundException { // file reader for single knapsack problem
        int value, weight;
        double coreValue;
        Calculation calculation = new Calculation();
        Scanner scan = new Scanner(new File(path));
        numberOfItems = scan.nextInt();
        capacity = scan.nextInt();
        while (scan.hasNext()) {
            value = scan.nextInt();
            weight = scan.nextInt();
            coreValue = (double) value / weight;
            items.add(new Keys(value, weight, coreValue));
        }
    }

    void multiReader(String path) throws FileNotFoundException { // file rfor multi knapsack problem
        int value, weight;
        double coreValue;
        Calculation calculation = new Calculation();
        Scanner scan = new Scanner(new File(path));
        totalVal = scan.nextInt();
        knapsackNumber = scan.nextInt();
        knapsack = new Knapsack[knapsackNumber];
        int size = knapsack.length;
        for (int i = 0; i < size; i++) {
            knapsack[i] = new Knapsack(scan.nextInt());
        }
        while (scan.hasNext()) {
            value = scan.nextInt();
            weight = scan.nextInt();
            coreValue = (double) value / weight;
            multiItems.add(new Keys(value, weight, coreValue));
        }
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public int getCapacity() {
        return capacity;
    }

    public ArrayList<Keys> getItems() {
        return items;
    }

    public int getTotalVal() {
        return totalVal;
    }

    public int getKnapsackNumber() {
        return knapsackNumber;
    }

    public ArrayList<Keys> getMultiItems() {
        return multiItems;
    }

    public Knapsack[] getKnapsack() {
        return knapsack;
    }
}

class Keys implements Comparable<Keys> {
    private int value;
    private int weight;
    private double coreValue;

    public Keys(int value, int weight, double coreValue) {
        this.value = value;
        this.weight = weight;
        this.coreValue = coreValue;
    }

    public int getValue() {
        return value;
    }

    public int getWeight() {
        return weight;
    }

    public double getCoreValue() {
        return coreValue;
    }

    @Override
    public int compareTo(Keys o) {
        return Double.compare(o.coreValue, this.coreValue);
    }
}

