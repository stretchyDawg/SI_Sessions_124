package si.algorithms.backtracker.subset_sums;

import java.util.ArrayList;
import java.util.List;

import si.algorithms.backtracker.Backtracker;

public class SubsetSumSolver {
    public static List<Integer> findSubset(int[] nums, int target) {
        SubsetSumConfiguration initialConfig = new SubsetSumConfiguration(nums, target, new ArrayList<>());
        Backtracker<SubsetSumConfiguration> backtracker = new Backtracker<>(false);
        SubsetSumConfiguration solution = backtracker.solve(initialConfig);
        if (solution != null) {
            return solution.getSubset();
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int target = 7;
        List<Integer> subset = findSubset(nums, target);
        System.out.println("Subset that sums up to " + target + ": " + subset);
    }
}