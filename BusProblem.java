import java.util.*;

public class BusProblem {
    public static void main(String[] args) {
        String[] busStops = new String[] { "EGMORE", " PANTHION_ROAD", " STERLING_ROAD", "VALLUVARKOTTAM", " POTHYS",
                " MAMBALAM", " GUINDY", "GST_ROAD", "TAMBARAM", "VANDALUR" };
        int[] passengers = new int[10];
        for (int i = 0; i < passengers.length; ++i) {
            if (i == 0)
                passengers[i] = (int) 2 * 3 / 2;
            else
                passengers[i] = (int) passengers[i - 1] * 3 / 2;
            System.out.println(busStops[i] + " - " + passengers[i]);
        }
    }
}
