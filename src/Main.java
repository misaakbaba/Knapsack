import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        String path = "out/production/knapsackProblemJava/sample1a.dat"; //input file
        fileRead fileRead = new fileRead();
        fileRead.reader(path);
//        System.out.println("values is " + fileRead.getValue());
//        System.out.println("weights is " + fileRead.getWeight());
//        System.out.println("capacity is " + fileRead.getCapacity());
        Knapsack knapsack = new Knapsack();
        knapsack.calculatePerPrice(fileRead.getValue(), fileRead.getWeight());
//        System.out.println(knapsack.getCoreValue());
        knapsack.keyInitializer(fileRead.getValue(), fileRead.getWeight(), knapsack.getCoreValue());
        ArrayList<Keys> items = knapsack.getItems();
        short iteration = (short) items.size();
        System.out.println("before");
        System.out.println("val   W   core");
        for (int i = 0; i < iteration; i++) {
            System.out.println(items.get(i).getValue() + "    " + items.get(i).getWeight() + "    " + items.get(i).getCorePrice());
        }
        System.out.println("after");
        System.out.println("val   W   core");
        Collections.sort(items); //after sorting most valueable items on top
        for (int i = 0; i < iteration; i++) {
            System.out.println(items.get(i).getValue() + "    " + items.get(i).getWeight() + "    " + items.get(i).getCorePrice());
        }
        knapsack.bagFiller(fileRead.getCapacity(), items);
        System.out.println("bags is");
        System.out.println("val   W   core");
        ArrayList<Keys> bags = knapsack.getBag();
        short size = (short) bags.size();
        for (int i = 0; i < size; i++) {
            System.out.println(bags.get(i).getValue() + "    " + bags.get(i).getWeight() + "    " + bags.get(i).getCorePrice());
        }
    }
}
