package leetcode.byNumber;

import java.util.Iterator;

public class p284_PeekingIterator implements Iterator<Integer> {

    Iterator<Integer> iterator;
    Integer curNext = null;

    public p284_PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
        if (iterator.hasNext()) {
            curNext = iterator.next();
        }
    }

    public Integer peek() {
        return curNext;
    }

    @Override
    public Integer next() {
        int tmp = curNext;
        if (iterator.hasNext()) {
            curNext = iterator.next();
        } else {
            curNext = null;
        }
        return tmp;
    }

    @Override
    public boolean hasNext() {
        return curNext != null;
    }
}
