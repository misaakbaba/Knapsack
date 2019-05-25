import java.util.ArrayList;

public class Knapsack {
    private ArrayList<Double> coreValue; //data type değişebilir
    private ArrayList<Keys> items;
    private ArrayList<Keys> bag;

    public Knapsack() {
        coreValue = new ArrayList<>(); // value / weight value
        items = new ArrayList<>(); // object arraylist which include value,weight and coreValue
        bag = new ArrayList<>(); //bag object list
    }

    void calculatePerPrice(ArrayList<Long> value, ArrayList<Long> weight) { //calculate value / weight value
        short iteration = (short) value.size();
        for (int i = 0; i < iteration; i++) {
            coreValue.add(((double) value.get(i)) / weight.get(i));
        }
    }

    void keyInitializer(ArrayList<Long> value, ArrayList<Long> weight, ArrayList<Double> coreValue) { //initialize items object arraylist
        // which include value, weight and coreValue
        short iteration = (short) coreValue.size();
        for (int i = 0; i < iteration; i++) {
            items.add(new Keys(value.get(i), weight.get(i), coreValue.get(i)));
        }
    }

    void bagFiller(Long capacity, ArrayList<Keys> items) { //fill the bag with most valuable items
        Long currentCapacity = capacity;
        short i = 0, iteration = (short) items.size();
        while (currentCapacity > 0 && i < iteration) {
            if (items.get(i).getWeight() < currentCapacity) {
                bag.add(items.get(i));
                currentCapacity -= items.get(i).getWeight();
            }
            i++;
        }
    }

    public ArrayList<Keys> getBag() {
        return bag;
    }

    public ArrayList<Double> getCoreValue() {
        return coreValue;
    }

    public ArrayList<Keys> getItems() {
        return items;
    }
}

class Keys implements Comparable<Keys> {
    private Long value;
    private Long weight;
    private double corePrice;

    public Keys(Long value, Long weight, double corePrice) {
        this.value = value;
        this.weight = weight;
        this.corePrice = corePrice;
    }

    public Long getValue() {
        return value;
    }

    public Long getWeight() {
        return weight;
    }

    public double getCorePrice() {
        return corePrice;
    }

    @Override
    public int compareTo(Keys o) {
        return Double.compare(o.corePrice, this.corePrice);
    }
}