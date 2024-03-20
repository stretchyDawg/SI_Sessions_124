package si.session_activities.unit08.Backtracking_Maze;
import java.util.ArrayList;
public interface Configuration {
  public boolean isValid();
  public boolean isGoal();
  public ArrayList<Configuration> getSuccessors();
}