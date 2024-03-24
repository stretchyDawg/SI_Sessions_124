package si.algorithms.backtracker.word_search;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import si.algorithms.backtracker.Configuration;

public class WordSearchConfiguration implements Configuration<WordSearchConfiguration> {
    private char[][] board;
    private String word;
    private int row;
    private int col;
    private int index;

    public WordSearchConfiguration(char[][] board, String word, int row, int col, int index) {
        this.board = board;
        this.word = word;
        this.row = row;
        this.col = col;
        this.index = index;
    }

    @Override
    public Collection<WordSearchConfiguration> getSuccessors() {
        List<WordSearchConfiguration> successors = new ArrayList<>();
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // Up, Down, Left, Right
        for (int[] dir : dirs) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (isValid(newRow, newCol)) {
                successors.add(new WordSearchConfiguration(board, word, newRow, newCol, index + 1));
            }
        }
        return successors;
    }

    private boolean isValid(int r, int c) {
        return r >= 0 && r < board.length && c >= 0 && c < board[0].length && board[r][c] == word.charAt(index);
    }

    @Override
    public boolean isValid() {
        return index < word.length() && isValid(row, col);
    }

    @Override
    public boolean isGoal() {
        return index == word.length() - 1 && isValid(row, col);
    }

    @Override
    public String toString() {
        return "(" + row + ", " + col + ")";
    }
}
