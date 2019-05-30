public class Keys implements Comparable<Keys> {
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
