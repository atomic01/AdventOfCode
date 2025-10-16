import java.util.List;
import java.util.Iterator;

public class InputPrinter {
    public static void printInputData(List<Integer> firstList, List<Integer> secondList) {
        Iterator<Integer> firstListIterator = firstList.iterator();
        Iterator<Integer> secondListIterator = secondList.iterator();

        while (firstListIterator.hasNext() && secondListIterator.hasNext()) {
            System.out.println(firstListIterator.next() + " " + secondListIterator.next());
        }
    }

    public static void printInputDataSize(List<Integer> firstList, List<Integer> secondList) {
        System.out.println("Input Data Size: " + firstList.size() + " " + secondList.size());
    }
}
