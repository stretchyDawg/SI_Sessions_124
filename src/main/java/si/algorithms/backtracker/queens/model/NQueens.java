package si.algorithms.backtracker.queens.model;

import java.util.Collection;

import si.algorithms.backtracker.Configuration;

public class NQueens implements Configuration<NQueens>{

    private final Queen[] queens;
    private int n; // Size of board/How many queens need to be found to solve the problem.

    public NQueens(int n){
        this(n, new Queen[0]);
    }
    
    
    public NQueens(int n, Queen[] queens){
        this.n = n;
        if(queens != null){
            this.queens = queens;            
        }
        else{
            this.queens = new Queen[0];
        }
    }
    
    @Override
    public Collection<NQueens> getSuccessors() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSuccessors'");
    }

    @Override
    public boolean isValid() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isValid'");
    }

    @Override
    public boolean isGoal() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isGoal'");
    }
    
    public static void main(String[] args) {
        
    }

    @Override
    public String toString() {
        return "NQueens []";
    }
}
