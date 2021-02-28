package leetcode.byNumber;

public class p896_isMonotonic {
    public boolean isMonotonic(int[] A) {
        int i = 0;
        while (i + 1 < A.length && A[i] <= A[i + 1]) {
            i++;
        }
        if (i + 1 == A.length) {
            return true;
        }

        i = 0;
        while (i + 1 < A.length && A[i] >= A[i + 1]) {
            i++;
        }
        return i + 1 == A.length;
    }

    public boolean isMonotonic2(int[] A) {
        boolean inc=true;
        boolean des=true;
        for (int i = 0; i < A.length-1; i++) {
            if(A[i]<A[i+1]){
                des=false;
            }
            if(A[i]>A[i+1]){
                inc=false;
            }
        }
        return inc||des;
    }
}
