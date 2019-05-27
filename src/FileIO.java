import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO { // file read object and its instances
    private int capacity;
    private int numberOfItems;
    private ArrayList<Short> value; //data type değişebilir
    private ArrayList<Short> weight; //data type değişebilir
    private ArrayList<Keys> items;

    public FileIO() {
        items = new ArrayList<>();
        weight = new ArrayList<>();
        value = new ArrayList<>();
    }

    void reader(String path) throws FileNotFoundException { // file reader
        short value, weight;
        double coreValue;
        Knapsack knapsack = new Knapsack();
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

    void readerMulti(String path) throws FileNotFoundException { // file reader
        short value, weight, NumberOfKnapsack, numberOfItem;
        double coreValue;
        Knapsack knapsack = new Knapsack();
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

    public long getNumberOfItems() {
        return numberOfItems;
    }

    public long getCapacity() {
        return capacity;
    }

    public ArrayList<Short> getValue() {
        return value;
    }

    public ArrayList<Short> getWeight() {
        return weight;
    }

    public ArrayList<Keys> getItems() {
        return items;
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

