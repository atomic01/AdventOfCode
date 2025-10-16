import java.util.List;

public class InputValidator {
    public static void ValidateInputData(List<Integer> firstList, List<Integer> secondList) throws Exception {
        if (firstList.size()!=secondList.size())
            throw new Exception("Input Data Invalid. Lists are not the same size!");
    }
}
