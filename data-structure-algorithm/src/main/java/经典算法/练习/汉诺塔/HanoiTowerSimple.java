package 经典算法.练习.汉诺塔;

/**
 * 拆成两步，非常容易理解，
 * 1.将所有origin的top(除了最底下一个)移动到available上，然后将origin最底下的移动到target
 * 2.把available看成origin重复1
 */
public class HanoiTowerSimple {
    public void solve(int num, char from, char cache, char to) {
        if (num == 1) {
            System.out.println("weight=" + num + "," + from + "-->" + to);
        } else {
            solve(num - 1, from, to, cache);
            System.out.println("weight=" + num + "," + from + "-->" + to);
            solve(num - 1, cache, from, to);
        }
    }
}
