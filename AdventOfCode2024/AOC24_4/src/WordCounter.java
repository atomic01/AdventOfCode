public class WordCounter {
    private static String[] input;
    private static String word;
    private static int cnt;

    public WordCounter(String[] inputData) {
        input = inputData;
        cnt = 0;
    }

    public int countWords(String targetWord){
        word = targetWord;
        resetCnt();

        for (int row = 0; row < input.length ; row++) {
            for (int column = 0; column < input[0].length(); column++){
                if (input(row,column) != targetWord.charAt(0)) {continue;}

                checkLeft(row, column);
                checkLeftUp(row, column);
                checkUp(row, column);
                checkRightUp(row, column);
                checkRight(row, column);
                checkRightDown(row, column);
                checkDown(row, column);
                checkLeftDown(row, column);
            }
        }

        return cnt;
    }

    public int countWords_2(String targetWord){
        word = targetWord;
        resetCnt();

        char M = 'M', A = 'A', S = 'S';

        for (int row = 1; row < input.length - 1 ; row++) {
            for (int column = 1; column < input[0].length() - 1; column++){
                if (input(row, column) != A) {continue;}

                // M M
                //  A
                // S S
                if (input(row-1, column-1) == M && input(row+1,column+1) == S &&
                    input(row-1, column+1) == M && input(row+1,column-1) == S){
                    cnt++;
                }
                // S S
                //  A
                // M M
                else if(input(row-1,column-1) == S && input(row+1,column+1) == M &&
                        input(row-1,column+1) == S && input(row+1,column-1) == M){
                    cnt++;
                }
                // M S
                //  A
                // M S
                else if(input(row-1,column-1) == M && input(row+1,column+1) == S &&
                        input(row-1,column+1) == S && input(row+1,column-1) == M){
                    cnt++;
                }
                // S M
                //  A
                // S M
                else if(input(row-1,column-1) == S && input(row+1,column+1) == M &&
                        input(row-1,column+1) == M && input(row+1,column-1) == S){
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private void resetCnt(){
        cnt = 0;
    }

    private char input(int r, int c){
        return input[r].charAt(c);
    }

    // CHECKERS
    private void checkLeft(int row_index, int column_index) {
        if (hitsLeftBorder(column_index)){return;}

        for (int i = 0; i < word.length(); i++){
            if (input(row_index,column_index - i) != word.charAt(i)){return;}
        }
        cnt++;
    }
    private void checkRight(int row_index, int column_index) {
        if (hitsRightBorder(column_index)){return;}

        for (int i = 0; i < word.length(); i++){
            if (input(row_index,column_index + i) != word.charAt(i)){return;}
        }
        cnt++;
    }
    private void checkUp(int row_index, int column_index) {
        if (hitsUpperBorder(row_index)){return;}

        for (int i = 0; i < word.length(); i++){
            if (input(row_index - i, column_index) != word.charAt(i)){return;}
        }
        cnt++;
    }
    private void checkDown(int row_index, int column_index) {
        if (hitsBottomBorder(row_index)){return;}

        for (int i = 0; i < word.length(); i++){
            if (input(row_index + i, column_index) != word.charAt(i)){return;}
        }
        cnt++;
    }
    private void checkLeftUp(int row_index, int column_index) {
        if (hitsLeftBorder(column_index) || hitsUpperBorder(row_index)){return;}

        for (int i = 0; i < word.length(); i++){
            if (input(row_index - i,column_index - i) != word.charAt(i)){return;}
        }
        cnt++;
    }
    private void checkRightUp(int row_index, int column_index) {
        if (hitsUpperBorder(row_index) || hitsRightBorder(column_index)){return;}

        for (int i = 0; i < word.length(); i++){
            if (input(row_index - i,column_index + i) != word.charAt(i)){return;}
        }
        cnt++;
    }
    private void checkRightDown(int row_index, int column_index) {
        if (hitsRightBorder(column_index) || hitsBottomBorder(row_index)){return;}

        for (int i = 0; i < word.length(); i++){
            if (input(row_index + i,column_index + i) != word.charAt(i)){return;}
        }
        cnt++;
    }
    private void checkLeftDown(int row_index, int column_index) {
        if (hitsLeftBorder(column_index) || hitsBottomBorder(row_index)){return;}

        for (int i = 0; i < word.length(); i++){
            if (input(row_index + i,column_index - i) != word.charAt(i)){return;}
        }
        cnt++;
    }


    // BORDER HELPERS
    private boolean hitsLeftBorder(int column_index){
        return (column_index - word.length() + 1) < 0;
    }
    private boolean hitsRightBorder(int column_index){
        return (column_index + word.length()) > input[0].length();
    }
    private boolean hitsUpperBorder(int row_index){
        return (row_index - word.length() + 1) < 0;
    }
    private boolean hitsBottomBorder(int row_index){
        return (row_index + word.length()) > input.length;
    }
}
