package si.algorithms.backtracker.subset_sums;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import si.algorithms.backtracker.Configuration;

public class SubsetSumConfiguration implements Configuration<SubsetSumConfiguration> {
    private int[] nums;
    private int target;
    private List<Integer> subset;

    public SubsetSumConfiguration(int[] nums, int target, List<Integer> subset) {
        this.nums = nums;
        this.target = target;
        this.subset = subset;
    }

    public List<Integer> getSubset() {
        return subset;
    }

    @Override
    public Collection<SubsetSumConfiguration> getSuccessors() {
        List<SubsetSumConfiguration> successors = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!subset.contains(nums[i])) {
                List<Integer> newSubset = new ArrayList<>(subset);
                newSubset.add(nums[i]);
                successors.add(new SubsetSumConfiguration(nums, target, newSubset));
            }
        }
        return successors;
    }

    @Override
    public boolean isValid() {
        int sum = subset.stream().mapToInt(Integer::intValue).sum();
        return sum <= target;
    }

    @Override
    public boolean isGoal() {
        int sum = subset.stream().mapToInt(Integer::intValue).sum();
        return sum == target;
    }

    @Override
    public String toString() {
        return subset.toString();
    }
}