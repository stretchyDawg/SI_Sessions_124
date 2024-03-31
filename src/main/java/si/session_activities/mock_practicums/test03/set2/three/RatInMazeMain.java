package si.session_activities.mock_practicums.test03.set2.three;

import si.algorithms.backtracker.Backtracker;
import si.data_structures.lists.ArrayList;
import si.data_structures.lists.List;

public class RatInMazeMain {

    /*
    The code below is provided to you. Do NOT change anything.
    It will solve the Rat in a Maze problem if you correctly implemented the Config class.
    
        The correct output should be:
        Maze 1: SOLUTION FOUND
        Maze 2: NO SOLUTION FOUND
        Maze 3: NO SOLUTION FOUND
        Maze 4: SOLUTION FOUND
        Maze 5: SOLUTION FOUND
    */ 
    
    public static void main(String[] args) {
        List<int[][]> mazes = new ArrayList<>();
        
        // Has a solution
        int[][] maze1 = {
            {0, 1, 0, 0, 1},
            {0, 0, 0, 1, 0},
            {1, 1, 0, 0, 0},
            {1, 1, 1, 0, 0}
        };
        mazes.append(maze1);

        // Does not have a solution
        int[][] maze2 = {
            {0, 1, 0, 0, 1},
            {0, 1, 0, 1, 0},
            {1, 1, 0, 0, 0},
            {1, 1, 1, 0, 0}
        };
        mazes.append(maze2);

        // Does not have a solution
        int[][] maze3 = {
            {0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0},
            {1, 1, 1, 0, 0},
            {0, 0, 1, 0, 0}
        };
        mazes.append(maze3);

        // Has a solution
        int[][] maze4 = {
            {0, 0, 1, 1, 1},
            {1, 0, 0, 1, 1},
            {1, 1, 0, 0, 1},
            {1, 1, 1, 0, 0}
        };
        mazes.append(maze4);

        // Has a solution
        int[][] maze5 = {
            {0, 0, 0, 0, 0},
            {1, 1, 1, 1, 0},
            {1, 1, 1, 1, 0},
            {1, 1, 1, 1, 0}
        };
        mazes.append(maze5);

        int count = 1;
        for(int[][] maze : mazes){
            RatInMazeConfig initialConfig = new RatInMazeConfig(maze, 0, 0);
            Backtracker<RatInMazeConfig> backtracker = new Backtracker<>(false);
            RatInMazeConfig solution = backtracker.solve(initialConfig);
    
            System.out.print("\nMaze " + count + ": ");
            if (solution != null) {
                System.out.print("SOLUTION FOUND");
            } else {
                System.out.print("NO SOLUTION FOUND");
            }
            count++;
        }
    }
}
