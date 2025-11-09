public class Main {
    public static void main(String[] args) {
        // Puzzle setup
        String[] inputData = new Input().getInput();
        //String[] inputData = new Input().getTestInput();
        InputPrinter.printInput(inputData);

        // Actual solution
        WordCounter word_counter = new WordCounter(inputData);
        System.out.println(word_counter.countWords("XMAS") + " " + word_counter.countWords_2("MAS"));
    }
}
