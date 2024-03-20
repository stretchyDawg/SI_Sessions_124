package si.session_activities.unit08.Backtracking_Maze;
class Main {
    // Driver Code
    public static void main(String args[])
    {
      String m = "XXX\n"
               + "0X0\n" 
               + "0XE";
      Maze maze = new Maze(3,3,m);
      Backtrack b = new Backtrack();
      System.out.println(maze);
      MazeConf solution = b.solve(new MazeConf(maze));
      System.out.println(solution.maze);
    }
}