import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO { // file read object and its instances
    private int capacity;
    private int numberOfItems;
    private ArrayList<Keys> items;
    Knapsack knapsack[];
    //multi
    private int totalVal;
    private short knapsackNumber;
    private ArrayList<Keys> multiItems;

    public FileIO() {
        items = new ArrayList<>();
        multiItems = new ArrayList<>();
    }

    void reader(String path) throws FileNotFoundException { // file reader
        short value, weight;
        double coreValue;
        Calculation calculation = new Calculation();
        Scanner scan = new Scanner(new File(path));
        numberOfItems = scan.nextInt();
        capacity = scan.nextInt();
        while (scan.hasNext()) {
            value = scan.nextShort();
            weight = scan.nextShort();
            coreValue = (double) value / weight;
            items.add(new Keys(value, weight, coreValue));
        }
    }

    void multiReader(String path) throws FileNotFoundException { // file reader
        short value, weight;
        double coreValue;
        Calculation calculation = new Calculation();
        Scanner scan = new Scanner(new File(path));
        totalVal = scan.nextInt();
        knapsackNumber = (short) scan.nextInt();
        knapsack = new Knapsack[knapsackNumber];
        short size = (short) knapsack.length;
        for (int i = 0; i < size; i++) {
            knapsack[i] = new Knapsack(scan.nextInt());
        }
        while (scan.hasNext()) {
            value = scan.nextShort();
            weight = scan.nextShort();
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

    public short getKnapsackNumber() {
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
    private short value;
    private short weight;
    private double coreValue;

    public Keys(Short value, Short weight, double coreValue) {
        this.value = value;
        this.weight = weight;
        this.coreValue = coreValue;
    }

    public Short getValue() {
        return value;
    }

    public Short getWeight() {
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

