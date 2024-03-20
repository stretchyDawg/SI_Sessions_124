package si.session_activities.unit08.Backtracking_Maze;
public class Backtrack {
 public MazeConf solve(MazeConf config) {
  if(config.isGoal()) {
    return config;
  } else {
    for(Configuration child : config.getSuccessors()) {
      if(child.isValid()) {
        MazeConf sol = solve((MazeConf)child);
        if(sol != null) {
          return sol;
        }
      }
    }
  }
  return null;
 }
}