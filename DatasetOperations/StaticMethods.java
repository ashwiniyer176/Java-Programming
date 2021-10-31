package DatasetOperations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class StaticMethods {
    void Q1(List<RegionStats> df) {
        System.out.println("---------QUESTION_1------------");
        System.out.println(
                "Q.Identify the numbers of births in particular region from the given input file named \"births-deaths-by-region\".");
        int answer = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Region name:- ");
        String Region = input.nextLine();
        for (RegionStats d : df) {
            if (d.region.equals(Region)) {
                if (d.birth) {
                    answer = answer + d.count;
                }
            }
        }
        if (answer == 0) {
            System.out.println("Region Not Found");
        } else {
            System.out.println("Answer:- " + answer);
        }
        System.out.println("---------END QUESTION_1------------");
        input.close();
    }

    void Q2(List<RegionStats> df) {
        System.out.println("---------QUESTION_2------------");
        System.out.println("Q.identify the number of death during the period 2020.");
        int answer = 0;
        for (RegionStats d : df) {
            if (d.period == 2020) {
                if (!d.birth) {
                    answer = answer + d.count;
                }
            }
        }
        if (answer == 0) {
            System.out.println("Region Not Found");
        } else {
            System.out.println("Answer:- " + answer);
        }
        System.out.println("---------END QUESTION_2------------");
    }

    void Q3(List<RegionStats> df) {
        System.out.println("---------QUESTION_3------------");
        System.out.println("Q.Identify the total number of regions.");
        int answer = 0;
        ArrayList<String> ArrList = new ArrayList<String>();
        for (RegionStats d : df) {
            ArrList.add(d.region);
        }
        HashSet<String> hset = new HashSet<String>(ArrList);
        answer = hset.size();
        if (answer == 0) {
            System.out.println("Region Not Found");
        } else {
            System.out.println("Answer:- " + answer);
        }
        System.out.println("---------END QUESTION_3------------");
    }

    void Q4(List<RegionStats> df) {
        System.out.println("---------QUESTION_4------------");
        System.out.println("Q.Identify the year which has more birth counts.");
        int answer = 0;
        int BestTotal = 0;
        int currentTotal = 0;
        int currentYear = 2000;
        for (RegionStats d : df) {
            if (currentYear == d.period) {
                if (d.birth) {
                    currentTotal = currentTotal + d.count;
                }
            } else {
                if (currentTotal > BestTotal) {
                    answer = currentYear;
                    BestTotal = currentTotal;
                }
                currentTotal = 0;
                currentYear = d.period;
                if (d.birth) {
                    currentTotal = currentTotal + d.count;
                }
            }
        }
        System.out.println("Answer:- " + answer);
        System.out.println("---------END QUESTION_4------------");
    }
}
