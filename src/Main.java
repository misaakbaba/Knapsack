import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        problem1();
    }

    public static void problem1() throws FileNotFoundException {
        String path = "out/production/knapsackProblemJava/sample1b.dat"; //input file
        FileIO FileIO = new FileIO();
        FileIO.reader(path);
        Calculation calculation = new Calculation();
        ArrayList<Keys> items = FileIO.getItems();
        Collections.sort(items); //after sorting most valueable items on top
        ArrayList<Keys> bags = calculation.bagFiller(FileIO.getCapacity(), items, calculation.getBag());
//        System.out.println("knapsack capacity is: " + FileIO.getCapacity());
//        System.out.println("knapsack weight is: " + calculation.bagWeight(bags));
//        System.out.println("knapsack value is: " + calculation.bagValue(bags));
    }

    public static void problem2() throws FileNotFoundException {
        String path = "out/production/knapsackProblemJava/sample2a.dat";
        FileIO fileIO = new FileIO();
        fileIO.multiReader(path);
        Calculation calculation = new Calculation();
        ArrayList<Keys> multiItems = fileIO.getMultiItems();
        System.out.println(multiItems.get(0).getValue());
        Collections.sort(multiItems);
        Knapsack knapsack[] = fileIO.knapsack;
        Arrays.sort(knapsack); // sort the knapsack object array
        calculation.multiBagFiller(knapsack, multiItems);
//        for (int i = 0; i < knapsack.length; i++) {
//            System.out.println((i + 1) + ".bag: capacity is: " + knapsack[i].getSize() + " weight is: " + calculation.bagWeight(knapsack[i].getItems()) + " value is: " + calculation.bagValue(knapsack[i].getItems()));
//        }
    }

    public static void printInfo(ArrayList<Keys> items) {
        System.out.println("val    W    core");
        short size = (short) items.size();
        for (int i = 0; i < size; i++) {
            System.out.println(items.get(i).getValue() + "    " + items.get(i).getWeight() + "    " + items.get(i).getCoreValue());
        }
    }

}
