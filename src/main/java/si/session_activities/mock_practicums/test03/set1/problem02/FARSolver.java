package si.session_activities.mock_practicums.test03.set1.problem02;

import java.util.Collection;

import si.algorithms.backtracker.Configuration;

public class FARSolver implements Configuration<FARSolver>{

    @Override
    public Collection<FARSolver> getSuccessors() {
        return null;
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public boolean isGoal() {
        return true;
    }

}
