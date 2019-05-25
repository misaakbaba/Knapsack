import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class fileRead { // file read object and its instances
private long capacity;
private long numberOfItems;
    private ArrayList<Long> value; //data type değişebilir
    private ArrayList<Long> weight; //data type değişebilir

    public fileRead() {
        weight = new ArrayList<>();
        value = new ArrayList<>();
    }

    void reader(String path) throws FileNotFoundException { // file reader
        Scanner scan=new Scanner(new File(path));
        numberOfItems=Long.parseLong(scan.next());
        capacity=Long.parseLong(scan.next());
        while (scan.hasNext()){
            value.add(Long.parseLong(scan.next()));
            weight.add(Long.parseLong(scan.next()));
        }
    }

    public long getNumberOfItems() {
        return numberOfItems;
    }

    public long getCapacity() {
        return capacity;
    }

    public ArrayList<Long> getValue() {

        return value;
    }

    public ArrayList<Long> getWeight() {
        return weight;
    }
}
