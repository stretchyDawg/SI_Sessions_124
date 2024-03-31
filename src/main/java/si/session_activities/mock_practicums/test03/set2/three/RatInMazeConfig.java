package si.session_activities.mock_practicums.test03.set2.three;

import java.util.ArrayList;
import java.util.Collection;
import si.algorithms.backtracker.Configuration;

public class RatInMazeConfig implements Configuration<RatInMazeConfig> {
    private final int[][] maze;
    private final int row;
    private final int col;

    public RatInMazeConfig(int[][] maze, int row, int col) {
        this.maze = maze;
        this.row = row;
        this.col = col;
    }

    @Override
    public Collection<RatInMazeConfig> getSuccessors() {
        ArrayList<RatInMazeConfig> successors = new ArrayList<>();

        // Try moving down
        if (row + 1 < maze.length && maze[row + 1][col] == 0) {        // if( you are not at the edge of the map AND the thing in front of you is not a wall )
            successors.add(new RatInMazeConfig(maze, row + 1, col));
        }

        // Try moving right
        if (col + 1 < maze[row].length && maze[row][col + 1] == 0) {   // if( you are not at the edge of the map AND the thing in front of you is not a wall )
            successors.add(new RatInMazeConfig(maze, row, col + 1));
        }

        return successors;
    }

    @Override
    public boolean isValid() {
        // Check if the current position (row, col) is within the bounds of the maze
        // and if the cell at the current position is not an obstacle (represented by 1)
        return row >= 0 && row < maze.length && col >= 0 && col < maze[row].length && maze[row][col] == 0;
    }

    @Override
    public boolean isGoal() {
        // Check if the current position (row, col) is at the bottom-right corner of the maze,
        // which corresponds to the goal state where the rat has successfully reached the end of the maze
        return row == maze.length - 1 && col == maze[row].length - 1;
    }
}
