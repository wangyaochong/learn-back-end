package leetcode.byNumber;

public class p278_FirstBadVersion {
    public boolean isBadVersion(int version) {
        return false;
    }

    public int firstBadVersion(int n) {
        int low = 0;
        int high = n;
        int mid;
        while (low < high) {
            mid = (high - low) / 2 + low;
            if (isBadVersion(mid)) {
                high = mid - 1;
                if (!isBadVersion(high)) {
                    return high + 1;
                }
            } else {
                low = mid + 1;
                if (isBadVersion(low)) {
                    return low;
                }
            }
        }
        return 0;
    }

}
