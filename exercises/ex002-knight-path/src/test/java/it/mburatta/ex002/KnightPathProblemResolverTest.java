package it.mburatta.ex002;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class KnightPathProblemResolverTest {

    @Test
    void pathExistsFrom_1_1() {

        final Cell startingPosition = new Cell(1,1);
        final int boardSize = 5;

        List<Cell> expectedPath = new KnightPathProblemResolver(startingPosition, boardSize).solve();

        assertThat(expectedPath)
                .hasSize(25)
                .doesNotHaveDuplicates();
    }

    @Test
    void noPathExistsFrom_1_2() {
        final Cell startingPosition = new Cell(1,2);
        final int boardSize = 5;

        List<Cell> expectedPath = new KnightPathProblemResolver(startingPosition, boardSize).solve();

        assertThat(expectedPath)
                .hasSize(0)
                .doesNotHaveDuplicates();
    }
}
