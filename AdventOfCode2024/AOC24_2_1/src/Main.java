import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Puzzle setup
        List<List<Integer>> reports = new Input().getAllReports();
        InputPrinter.printInputData(reports);
        InputPrinter.printInputDataSize(reports);

        // Actual solution
        System.out.println("Number of safe reports: " + ResultProcessor.calculateNumberOfSafeReports(reports));
    }
}