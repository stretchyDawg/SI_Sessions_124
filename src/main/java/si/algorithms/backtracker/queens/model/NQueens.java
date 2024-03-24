package si.algorithms.backtracker.queens.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

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

    public Queen[] getQueens() {
        return queens;
    }

    @Override
    public Collection<NQueens> getSuccessors() {
        List<NQueens> successorsList = new ArrayList<>();
        int length = queens.length;
        int row = 0;

        if(length > 0){
            row = queens[length-1].getRow()+1;
        }
        if(row < n){
            for(int col = 0; col < n; col++){
                Queen[] copyQueens = Arrays.copyOf(queens, queens.length+1);
                copyQueens[length] = new Queen(row, col);
                successorsList.add(new NQueens(n, copyQueens));
            }
        }

        return successorsList;
    }

    @Override
    public boolean isValid() {
        int length = queens.length;
        if(length < 2){
            return true;
        }
        else{
            Queen last = queens[length - 1];
            for(int i = 0; i < length-1; i++){
                if(last.canAttack(queens[i])){
                    return false;
                }
            }
            return true;
        }
    }

    @Override
    public boolean isGoal() {
        return isValid() && (queens.length == n);
    }
    
    @Override
    public String toString() {
        return "n = " + n + " : Queens = " + Arrays.toString(queens);
    }
    
    public static void main(String[] args) {
        System.out.println();
        
        NQueens nQueens = new NQueens(4);
        System.out.println(nQueens);

        Collection<NQueens> successors = nQueens.getSuccessors();
        for(NQueens successor : successors){
            System.out.println(successor);
            System.out.println("Is Valid: " + nQueens.isValid());
            System.out.println("Is Goal: " + nQueens.isGoal());
            System.out.println();
        }
    }
}
