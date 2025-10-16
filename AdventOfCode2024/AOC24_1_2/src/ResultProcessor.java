import java.util.Collections;
import java.util.List;

public class ResultProcessor {
    public static int calculateSimilarityScore(List<Integer> leftList, List<Integer> rightList)
    {
        int similarityScore = 0;

        for (int element : leftList) {
            if (rightList.contains(element)) {
                int frequency = Collections.frequency(rightList, element);
                similarityScore += element * frequency;
            }
        }

        return similarityScore;
    }
}
