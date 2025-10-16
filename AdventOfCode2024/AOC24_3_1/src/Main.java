public class Main {
    public static void main(String[] args) {
        // Puzzle setup
        String memory = new Input().getMemory();
        InputPrinter.printMemory(memory);

        // Actual solution
        System.out.println("Corrupted memory: " + ComputerFixer.calculateCoruptedMemory(memory));
    }
}
