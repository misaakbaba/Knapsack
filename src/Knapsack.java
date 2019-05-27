import java.util.ArrayList;

public class Knapsack implements Comparable<Knapsack> {
    private int size;
    private ArrayList<Keys> items;

    public Knapsack() {
        items = new ArrayList<>();
    }

    public Knapsack(int size) {
        this.size = size;
        items = new ArrayList<>();
    }

    public ArrayList<Keys> getItems() {
        return items;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void addItems(Keys keys) {
        items.add(keys);
    }

    @Override
    public int compareTo(Knapsack o) {
        return this.size - o.size;
    }
}
