import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        problem1();
//        problem2();
    }

    public static void problem1() throws FileNotFoundException, UnsupportedEncodingException {
        String path = "test/knapsack_big.dat"; //input file
        String name = "out/output-" + "knapsack_big.dat"; //output file
        FileIO FileIO = new FileIO();
        FileIO.reader(path);
        Calculation calculation = new Calculation();
        ArrayList<Keys> items = FileIO.getItems(); //get read items
        ArrayList<Keys> originalItems = (ArrayList<Keys>) items.clone(); //clone original items for not lose original order
        Collections.sort(items); //after sorting most valueable items on top
        ArrayList<Keys> bags = calculation.bagFiller(FileIO.getCapacity(), items, calculation.getBag()); //fill bag with most valuable items
        writeSingle(name, originalItems, bags); // create output file
//        for (int i = 0; i < originalItems.size(); i++) {
//            System.out.println(calculation.comparator(originalItems.get(i), bags));
//        }
        //for test cases
//        System.out.println("knapsack capacity is: " + FileIO.getCapacity());
//        System.out.println("knapsack weight is: " + calculation.bagWeight(bags));
//        System.out.println("knapsack value is: " + calculation.bagValue(bags));
    }

    public static void problem2() throws FileNotFoundException, UnsupportedEncodingException {
        String path = "test/test2d.dat"; //input file
        String name = "out/output-" + "test2d.dat"; //output file
        FileIO fileIO = new FileIO();
        fileIO.multiReader(path);
        Calculation calculation = new Calculation();
        ArrayList<Keys> multiItems = fileIO.getMultiItems(); //get read items
        ArrayList<Keys> originalItems = (ArrayList<Keys>) multiItems.clone(); //clone items for not lose its original order
        Collections.sort(multiItems); //after sorting most valueable items on top
        Knapsack knapsack[] = fileIO.knapsack; //get knapsacks
        Knapsack originalKnapsack[] = knapsack.clone(); //clone knapsacks array for not lose its original order
        Arrays.sort(knapsack); // sort the knapsack object array
        calculation.multiBagFiller(knapsack, multiItems); //fill the multiple knapsacks
        writeMulti(name, originalKnapsack, originalItems); // create output file
        //for test cases
//        System.out.println(originalKnapsack[0].getSize());
//        for (int i = 0; i < originalKnapsack[0].getItems().size(); i++) {
//            System.out.println(originalKnapsack[0].getItems().get(i).getValue());
//        }

//        for (int i = 0; i < originalItems.size(); i++) {
//            System.out.print(originalItems.get(i).getValue()+" "+originalItems.get(i).getWeight()+" ");
//            for (int j = 0; j < originalKnapsack.length; j++) {
//                System.out.print(calculation.comparator(originalItems.get(i),originalKnapsack[j].getItems())+" ");
//            }
//            System.out.println();
//        }

//        for (int i = 0; i < knapsack.length; i++) {
//            for (int j = 0; j < originalItems.size(); j++) {
//                System.out.println(calculation.comparator(originalItems.get(j),knapsack[i].getItems()));
//            }
//            System.out.println();
//        }
//        int total = 0;
//        for (int i = 0; i < knapsack.length; i++) {
//            total += calculation.bagValue(knapsack[i].getItems());
//            System.out.println((i + 1) + ".bag: capacity is: " + knapsack[i].getSize() + " weight is: " + calculation.bagWeight(knapsack[i].getItems()) + " value is: " + calculation.bagValue(knapsack[i].getItems()));
//        }
//        System.out.println("total is:" + total);

    }

    static void printInfo(ArrayList<Keys> items) {
        System.out.println("val    W    core");
        short size = (short) items.size();
        for (int i = 0; i < size; i++) {
            System.out.println(items.get(i).getValue() + "    " + items.get(i).getWeight() + "    " + items.get(i).getCoreValue());
        }
    }

    static void writeSingle(String name, ArrayList<Keys> originalList, ArrayList<Keys> bagContent) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter printWriter = new PrintWriter(name, "UTF-8");
        Calculation calculation = new Calculation();
        printWriter.println(calculation.bagValue(bagContent));
        for (int i = 0; i < originalList.size(); i++) {
            printWriter.println(calculation.comparator(originalList.get(i), bagContent));
        }
        printWriter.close();
    }

    static void writeMulti(String name, Knapsack[] originalKnapsack, ArrayList<Keys> originalList) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter printWriter = new PrintWriter(name, "UTF-8");
        Calculation calculation = new Calculation();
        int total = 0;
        for (int i = 0; i < originalKnapsack.length; i++) {
            total += calculation.bagValue(originalKnapsack[i].getItems());
        }
        printWriter.println(total);
        for (int i = 0; i < originalList.size(); i++) {
            for (int j = 0; j < originalKnapsack.length; j++) {
                printWriter.print(calculation.comparator(originalList.get(i), originalKnapsack[j].getItems()) + " ");
            }
            printWriter.println();
        }
        printWriter.close();
    }
}
