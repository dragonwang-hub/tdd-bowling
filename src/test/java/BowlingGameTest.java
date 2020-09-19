import BowlingScore.BowlingScore;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BowlingGameTest {
    @Test
    void should_throw_exception_when_not_finish_competition() {
        assertThrows(Exception.class, () -> {
            BowlingScore bowlingScore = new BowlingScore();
            int[][] eachTimeScoreOfNotFinishCompetition = {{1, 0}, {2, 0}, {3, 0}, {4, 0}, {5, 0}, {6, 0}, {7, 0}, {8, 0}};
            bowlingScore.calculationScore(eachTimeScoreOfNotFinishCompetition);
        });
    }

    @Test
    void should_return_0_when_No_knock_down_bowling() {
        //given
        BowlingScore bowlingScore = new BowlingScore();
        int[][] eachTimeScoreOfNoKnockDownBowling = {{0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}};
        //when
        int result = bowlingScore.calculationScore(eachTimeScoreOfNoKnockDownBowling);
        //then
        assertEquals(0, result);
    }

    @Test
    void should_return_300_when_knock_down_all_bowling_each_frame_first_throw() {
        //given
        BowlingScore bowlingScore = new BowlingScore();
        int[][] eachTimeScoreOfKnockDownAllBowlingEachFrameFirstThrow = {{10, 0}, {10, 0}, {10, 0}, {10, 0}, {10, 0}, {10, 0}, {10, 0}, {10, 0}, {10, 0}, {10, 0}, {10, 0}, {10, 0}};
        //when
        int result = bowlingScore.calculationScore(eachTimeScoreOfKnockDownAllBowlingEachFrameFirstThrow);
        //then
        assertEquals(300, result);
    }

    @Test
    void should_return_cumulative_value_when_each_frame_score_less_than_10() {
        //given
        BowlingScore bowlingScore = new BowlingScore();
        int[][] eachTimeScoreOfEachFrameScoreLessThan10 = {{6, 3}, {8, 1}, {5, 4}, {4, 5}, {1, 8}, {7, 2}, {3, 6}, {5, 4}, {2, 7}, {1, 8}};
        //when
        int result = bowlingScore.calculationScore(eachTimeScoreOfEachFrameScoreLessThan10);
        //then
        assertEquals(90, result);
    }

}
