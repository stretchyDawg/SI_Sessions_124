package si.algorithms.backtracker.bricks;

import java.util.ArrayList;
import java.util.Collection;

import si.algorithms.backtracker.Configuration;

public class WallSolver implements Configuration<WallSolver>{

    private BrickWall wall;
    private ArrayList<Integer> list;
    public BrickWall getBrickWall() {
        return wall;
    }

    private boolean added;

    public WallSolver(BrickWall wall, ArrayList<Integer> list){
        this.wall = wall;
        this.list = list;
        added = true;
    }

    public WallSolver(BrickWall wall, ArrayList<Integer> list, int num){
        this.wall = wall.brickWallCopy();
        this.list = list;
        added = this.wall.addBrick(num);
        
    }

    @Override
    public Collection<WallSolver> getSuccessors() {
        ArrayList<WallSolver> succ = new ArrayList<>();
        for (int each: list){
            succ.add(new WallSolver(wall, list, each));
        }

        return succ;
    }

    @Override
    public boolean isValid() {
        return added;
    }

    @Override
    public boolean isGoal() {
        return wall.isComplete();
    }



}