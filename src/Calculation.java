import java.util.ArrayList;

public class Calculation {
    private ArrayList<Double> coreValue; //data type değişebilir
    private ArrayList<Keys> bag;

    public Calculation() {
        coreValue = new ArrayList<>(); // value / weight value
        bag = new ArrayList<>(); //bag object list
    }

    ArrayList<Keys> bagFiller(int capacity, ArrayList<Keys> items, ArrayList<Keys> bag) { //fill the bag with most valuable items
        int currentCapacity = capacity;
        short i = 0;
        while (currentCapacity > 0 && i < items.size()) {
            if (items.get(i).getWeight() < currentCapacity) {
                bag.add(items.get(i));
                currentCapacity -= items.get(i).getWeight();
                items.remove(i);
                continue;
            }
            i++;
        }
        return bag;
    }

    void multiBagFiller(Knapsack knapsack[], ArrayList<Keys> items) {
        short size = (short) knapsack.length;
        for (int i = 0; i < size; i++) {
            bagFiller(knapsack[i].getSize(), items, knapsack[i].getItems());
        }
    }

    int bagValue(ArrayList<Keys> bag) {
        short size = (short) bag.size();
        int value = 0;
        for (int i = 0; i < size; i++) {
            value += bag.get(i).getValue();
        }
        return value;
    }

    int bagWeight(ArrayList<Keys> bag) {
        short size = (short) bag.size();
        int weight = 0;
        for (int i = 0; i < size; i++) {
            weight += bag.get(i).getWeight();
        }
        return weight;
    }

    public ArrayList<Keys> getBag() {
        return bag;
    }

    public ArrayList<Double> getCoreValue() {
        return coreValue;
    }
}