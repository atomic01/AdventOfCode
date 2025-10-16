import java.util.ArrayList;
import java.util.List;

public class ReportDampener {
    public static List<List<Integer>> generateDampenedReports(List<Integer> report) {
        List<List<Integer>> dampenedReports = new ArrayList<List<Integer>>();

        for (int i = 0; i < report.size(); i++){
            List<Integer> dampenedReport = new ArrayList<Integer>(report);
            dampenedReport.remove(i);
            dampenedReports.add(dampenedReport);
        }

        return dampenedReports;
    }
}
