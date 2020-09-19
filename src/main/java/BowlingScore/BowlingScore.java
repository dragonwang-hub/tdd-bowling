package BowlingScore;

import java.util.ArrayList;
import java.util.List;

public class BowlingScore {
    public int calculationScore(int[][] eachTimeScore) throws Exception {
        if (eachTimeScore == null || eachTimeScore.length < 10) {
            throw new Exception();
        }
        List<Integer> eachFrameScore = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            int iTimesFrameCurScore = eachTimeScore[i][0] + eachTimeScore[i][1];
            if (eachTimeScore[i][0] == 10) {
                if (eachTimeScore[i + 1][0] == 10) {
                    iTimesFrameCurScore = iTimesFrameCurScore + eachTimeScore[i + 1][0] + eachTimeScore[i + 2][0];
                } else {
                    iTimesFrameCurScore = iTimesFrameCurScore + eachTimeScore[i + 1][0] + eachTimeScore[i + 1][1];
                }
            } else if (iTimesFrameCurScore == 10) {
                iTimesFrameCurScore = iTimesFrameCurScore + eachTimeScore[i + 1][0];
            }
            eachFrameScore.add(iTimesFrameCurScore);
        }
        int totalScore = eachFrameScore.stream().reduce(0, Integer::sum);
        return totalScore;

    }
}
