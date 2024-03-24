package si.algorithms.backtracker.word_search;

import si.algorithms.backtracker.Backtracker;

public class WordSearchSolver {
    public static boolean searchWord(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                WordSearchConfiguration initialConfig = new WordSearchConfiguration(board, word, i, j, 0);
                Backtracker<WordSearchConfiguration> backtracker = new Backtracker<>(false);
                WordSearchConfiguration solution = backtracker.solve(initialConfig);
                if (solution != null) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word1 = "ABCCED";
        String word2 = "SEE";
        String word3 = "ABCB";
        System.out.println("Does the board contain the word '" + word1 + "'? " + searchWord(board, word1));
        System.out.println("Does the board contain the word '" + word2 + "'? " + searchWord(board, word2));
        System.out.println("Does the board contain the word '" + word3 + "'? " + searchWord(board, word3));
    }
}