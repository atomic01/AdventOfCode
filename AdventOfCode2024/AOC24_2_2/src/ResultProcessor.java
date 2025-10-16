import java.util.List;

public class ResultProcessor {
    public static int calculateNumberOfSafeReport(List<List<Integer>> reports) {
        int safeReportCounter = 0;

        for (List<Integer> report : reports) {
            if (SafetyAnalyzer.analyzeReport(report))
                safeReportCounter++;
        }

        return safeReportCounter;
    }
}
