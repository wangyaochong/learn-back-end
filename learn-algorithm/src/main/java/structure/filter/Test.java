package structure.filter;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

public class Test {
    public static void main(String[] args) {
        long putSize = 1000000L;
        BloomFilter filter = BloomFilter.create(Funnels.longFunnel(), putSize, 0.01);
        for (long i = 0; i < putSize; i++) {
            filter.put(i);
        }
        int errorCount = 0;
        for (long i = putSize + 1; i < putSize * 2; i++) {
            if (filter.mightContain(i)) {
                errorCount++;
            }
        }
        System.out.println(errorCount);
    }
}
