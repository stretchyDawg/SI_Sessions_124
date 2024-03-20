package si.session_activities.unit08.Backtracking_Maze;
public class Maze {
  public char[][] map;
  public final int rows;
  public final int cols;

  public int currRow;
  public int currCol;

  public Maze(Maze m) {
    this.rows = m.rows;
    this.cols = m.cols;
    map = new char[rows][cols];
    for(int i = 0; i < m.map.length; i++)
      this.map[i] = m.map[i].clone();
  }

  public Maze(int rows, int cols, String s) {
    this.rows = rows;
    this.cols = cols;
    this.currRow = 0;
    this.currCol = 0;
    map = new char[rows][cols];
    String[] lines = s.split("\n");
    for(int row = 0; row < rows; row++) {
      char[] cs = lines[row].toCharArray();
      for(int col = 0; col < cols; col++) {
        map[row][col] = cs[col];
      }
    }
  }

  public boolean inBounds(int r, int c) {
    if(r < 0) return false;
    if(c < 0) return false;
    if(r >= rows) return false;
    if(c >= cols) return false;
    return true;
  }

  public String toString() {
    String s = "";
    for(int row = 0; row < rows; row++) {
      for(int col = 0; col < cols; col++) {
        s += map[row][col];
      }
      s += "\n";
    }
    return s;
  }
}