import java.util.List;

public class SafetyAnalyzer {
    public static boolean analyzeReport(List<Integer> report){
        if (ASCSafeCheck(report) || DESCSafeCheck(report))
            return true;
        else{
            List<List<Integer>> dampenedReports = ReportDampener.generateDampenedReports(report);
            for(List<Integer> dampenedReport: dampenedReports)
                if (ASCSafeCheck(dampenedReport) || DESCSafeCheck(dampenedReport))
                    return true;
        }

        return false;
    }

    private static boolean ASCSafeCheck(List<Integer> report){
        for(int i = 0; i < report.size()-1; i++){
            int ASCDiff =  report.get(i+1) - report.get(i);
            if (ASCDiff < 1 || ASCDiff > 3)
                return false;
        }

        return true;
    }

    private static boolean DESCSafeCheck(List<Integer> report){
        for(int i = 0; i < report.size()-1; i++){
            int ASCDiff =  report.get(i) - report.get(i+1);
            if (ASCDiff < 1 || ASCDiff > 3)
                return false;
        }

        return true;
    }
}
