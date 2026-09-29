package lab04;

import java.util.Iterator;
import java.util.List;

public class FindMaxMinUtils {
    public static void findMaxMin(List<Float> scoreList) {
        int numberOfScores = 0; //float maxScore
        float maxScore = Float.NEGATIVE_INFINITY; //float minScore
        float minScore = Float.POSITIVE_INFINITY; //float
        float nextScore;

        Iterator<Float> iterator = scoreList.iterator();

        while (iterator.hasNext()){
            nextScore = iterator.next();

            if (nextScore > maxScore) {
                maxScore = nextScore;
            }

            if (nextScore < minScore) {
                minScore = nextScore;
            }
            numberOfScores++;
        }

        if (numberOfScores < 1) {
            System.out.println("No scores found in score list");
        } else {
            System.out.println(numberOfScores + " total scores found in score list");
            System.out.println("The maximum score is " + maxScore);
            System.out.println("The minimum score is " + minScore);
        }
    }
}
