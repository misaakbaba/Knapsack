import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        String path = "out/production/knapsackProblemJava/sample1b.dat"; //input file
        FileIO FileIO = new FileIO();
        FileIO.reader(path);
        Knapsack knapsack = new Knapsack();
        ArrayList<Keys> items = FileIO.getItems();
        short size = (short) items.size();
        System.out.println("before");
        System.out.println("val   W   core");
        for (int i = 0; i < size; i++) {
            System.out.println(items.get(i).getValue() + "    " + items.get(i).getWeight() + "    " + items.get(i).getCoreValue());
        }
        System.out.println("after");
        System.out.println("val   W   core");
        Collections.sort(items); //after sorting most valueable items on top
        for (int i = 0; i < size; i++) {
            System.out.println(items.get(i).getValue() + "    " + items.get(i).getWeight() + "    " + items.get(i).getCoreValue());
        }
        knapsack.bagFiller(FileIO.getCapacity(), items);
        System.out.println("bags is");
        System.out.println("val   W   core");
        ArrayList<Keys> bags = knapsack.getBag();
        short size2 = (short) bags.size();
        for (int i = 0; i < size2; i++) {
            System.out.println(bags.get(i).getValue() + "    " + bags.get(i).getWeight() + "    " + bags.get(i).getCoreValue());
        }
        System.out.println("knapsack capacity is: " + FileIO.getCapacity());
        System.out.println("knapsack weight is: " + knapsack.bagWeight(bags));
        System.out.println("knapsack value is: " + knapsack.bagValue(bags));
    }
}
