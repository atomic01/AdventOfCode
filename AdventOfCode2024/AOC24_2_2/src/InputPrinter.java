import java.util.List;

public class InputPrinter {
    public static void printInputData(List<List<Integer>> reports){
        for (List<Integer> report: reports)
            System.out.println(report);
    }
    public static void printInputDataSize(List<List<Integer>> reports){
        System.out.println("Number of reports: " + reports.size());
    }
}
