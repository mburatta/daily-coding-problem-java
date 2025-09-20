package it.mburatta.ex001;

import java.util.HashMap;
import java.util.Map;

public final class TwoSum {

    private TwoSum() {
        // Empty private constructor to prevent instantiation
    }

  public static int[] solve(int[] nums, int target) {
    Map<Integer, Integer> seen = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int need = target - nums[i];
      if (seen.containsKey(need)) {
        return new int[] {seen.get(need), i};
      }
      seen.put(nums[i], i);
    }
    return new int[] {-1, -1};
  }
}
