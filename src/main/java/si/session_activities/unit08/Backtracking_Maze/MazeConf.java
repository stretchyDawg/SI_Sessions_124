package si.session_activities.unit08.Backtracking_Maze;
import java.util.ArrayList;
public class MazeConf implements Configuration {
  public Maze maze;
  public boolean[][] visited;

  public MazeConf(Maze m) {
    //DEEP COPY
    maze = new Maze(m);
    visited = new boolean[maze.rows][maze.cols];
    if(isValid()) maze.map[maze.currRow][maze.currCol] = 'S';
  }

  public MazeConf(int row, int col, MazeConf conf) {
    maze = new Maze(conf.maze);
    maze = conf.maze;
    maze.currRow = row;
    maze.currCol = col;
    visited = conf.visited;
    if(isValid() && !isGoal()) maze.map[maze.currRow][maze.currCol] = 'S';
  }

  public boolean isValid() {
    if(maze.map[maze.currRow][maze.currCol] == 'X') return true;
    if(maze.map[maze.currRow][maze.currCol] == 'S') return true;
    if(maze.map[maze.currRow][maze.currCol] == 'E') return true;
    return false;
  }

  public boolean isGoal() {
    return maze.map[maze.currRow][maze.currCol] == 'E';
  }

  public ArrayList<Configuration> getSuccessors() {
    ArrayList<Configuration> succs = new ArrayList<>();
    int[][] signs = { {0,1}, {0,-1}, {1,0}, {-1,0} };
    for(int i = 0; i < signs.length; i++) {
        int r = maze.currRow + signs[i][0];
        int c = maze.currCol + signs[i][1];
        if(maze.inBounds(r,c) && !visited[r][c]) {
          visited[r][c] = true;
          Configuration mc = new MazeConf(r, c, this);
          succs.add(mc);
        }
    }
    return succs;
  }
}