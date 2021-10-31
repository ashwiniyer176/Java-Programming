package DatasetOperations;

import java.io.Serializable;

public class RegionStats {
    int period;
    Boolean birth;
    String region;
    int count;

    RegionStats(int period, Boolean birth, String region, int count) {
        this.period = period;
        this.birth = birth;
        this.region = region;
        this.count = count;
    }

    @Override
    public String toString() {
        return "Record [period=" + period + ", birth=" + birth + ", region=" + region + ", count=" + count + "]";
    }

}
