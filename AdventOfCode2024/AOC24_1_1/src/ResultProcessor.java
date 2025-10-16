import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ResultProcessor {
    public static int calculateTotalDistance(List<Integer> leftList, List<Integer> rightList)
    {
        int totalDistance = 0;

        Collections.sort(leftList);
        Collections.sort(rightList);

        Iterator<Integer> leftListIterator = leftList.iterator();
        Iterator<Integer> rightListIterator = rightList.iterator();

        while (leftListIterator.hasNext() && rightListIterator.hasNext()) {
            totalDistance += Math.abs(leftListIterator.next() - rightListIterator.next());
        }

        return totalDistance;
    }

}
