import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        // Puzzle setup
        List<Integer> leftList = new Input().getLeftList();
        List<Integer> rightList = new Input().getRightList();

        InputValidator.ValidateInputData(leftList, rightList);
        InputPrinter.printInputData(leftList, rightList);
        InputPrinter.printInputDataSize(leftList, rightList);

        // Actual solution
         System.out.print("Similarity score: " + ResultProcessor.calculateSimilarityScore(leftList, rightList));
    }
}