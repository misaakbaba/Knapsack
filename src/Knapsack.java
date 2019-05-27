import java.util.ArrayList;

public class Knapsack {
    private ArrayList<Double> coreValue; //data type değişebilir
    private ArrayList<Keys> bag;

    public Knapsack() {
        coreValue = new ArrayList<>(); // value / weight value
        bag = new ArrayList<>(); //bag object list
    }

    void bagFiller(Long capacity, ArrayList<Keys> items) { //fill the bag with most valuable items
        Long currentCapacity = capacity;
        short i = 0, size = (short) items.size();
        while (currentCapacity > 0 && i < size) {
            if (items.get(i).getWeight() < currentCapacity) {
                bag.add(items.get(i));
                currentCapacity -= items.get(i).getWeight();
            }
            i++;
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

