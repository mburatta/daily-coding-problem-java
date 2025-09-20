package it.mburatta.ex001;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class TwoSumTest {
  @Test
  void findsIndices() {
    int[] res = TwoSum.solve(new int[] {2, 7, 11, 15}, 9);
    assertThat(res).containsExactly(0, 1);
  }

  @Test
  void returnsMinusOneWhenNotFound() {
    int[] res = TwoSum.solve(new int[] {1, 2, 3}, 100);
    assertThat(res).containsExactly(-1, -1);
  }
}
