package leetcode.byNumber;

public class p278_FirstBadVersion_递归 {
    public boolean isBadVersion(int version) {
        return false;
    }


    public int firstBadVersion(int n) {
        return getResult(1, n, -2, -2);
    }

    public int getResult(int start, int end, int isLastBad, int lastLoc) {
        if (start > end) {
            return start;
        }
        int loc = (end - start) / 2 + start;
        if (isBadVersion(loc)) {
            if (isLastBad == -1 && lastLoc == loc - 1) {
                return loc;
            }
            return getResult(start, loc - 1, 1, loc);
        } else {
            if (isLastBad == 1 && lastLoc == loc + 1) {
                return loc + 1;
            }
            return getResult(loc + 1, end, -1, loc);
        }
    }
}
