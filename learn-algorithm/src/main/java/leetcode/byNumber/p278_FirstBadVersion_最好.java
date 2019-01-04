package leetcode.byNumber;

public class p278_FirstBadVersion_最好 {
    public boolean isBadVersion(int version) {
        return false;
    }

    public int firstBadVersion(int n) {
        int start = 1, end = n;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (!isBadVersion(mid)) start = mid + 1;
            else end = mid;
        }
        return start;
    }
}
