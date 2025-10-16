import java.util.List;

public class SafetyAnalyzer {
    public static boolean analyzeReport(List<Integer> report){
        return ASCSafeCheck(report) || DESCSafeCheck(report);
    }

    public static boolean ASCSafeCheck(List<Integer> report){
        for(int i = 0; i < report.size()-1; i++){
            int ASCDiff =  report.get(i+1) - report.get(i);
            if (ASCDiff < 1 || ASCDiff > 3)
                return false;
        }

        return true;
    }

    public static boolean DESCSafeCheck(List<Integer> report){
        for(int i = 0; i < report.size()-1; i++){
            int ASCDiff =  report.get(i) - report.get(i+1);
            if (ASCDiff < 1 || ASCDiff > 3)
                return false;
        }

        return true;
    }
}
