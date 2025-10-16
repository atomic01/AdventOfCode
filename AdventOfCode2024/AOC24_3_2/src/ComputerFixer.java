import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ComputerFixer {
    public static int calculateCoruptedMemory(String memory) {
        int sum = 0;
        boolean enableFlag = true;

        // Construct regex
        final Pattern pattern = Pattern.compile("(?:mul\\([0-9]{1,3},[0-9]{1,3}\\)|do\\(\\)|don't\\(\\))");
        final Matcher matcher = pattern.matcher(memory);

        // Extract each positive match
        while (matcher.find()) {
            String instruction = matcher.group();
            if (instruction.equals("do()")){
                enableFlag = true;
            }
            else if(instruction.equals("don't()")){
                enableFlag = false;
            }
            else if(enableFlag){
                // Construct second regex to extract numbers from a string
                Pattern pattern2 = Pattern.compile("[0-9]{1,3}");
                Matcher matcher2 = pattern2.matcher(instruction);

                // Extract numbers and convert them from string to int
                matcher2.find();
                int x = Integer.parseInt(matcher2.group());

                matcher2.find();
                int y = Integer.parseInt(matcher2.group());

                sum += x * y;
            }
        }

        return sum;
    }
}
