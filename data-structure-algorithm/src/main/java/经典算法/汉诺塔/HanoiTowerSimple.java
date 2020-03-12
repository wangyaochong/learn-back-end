package 经典算法.汉诺塔;

/**
 * 拆成两步，非常容易理解，
 * 1.将所有origin的top(除了最底下一个)移动到available上，然后将origin最底下的移动到target
 * 2.把available看成origin重复1
 */
public class HanoiTowerSimple {
    public void solve(int num, char a, char b, char c) {
        if (num == 1) {
            System.out.println("weight=" + num + "," + a + "-->" + c);
        } else {
            solve(num - 1, a, c, b);
            System.out.println("weight=" + num + "," + a + "-->" + c);
            solve(num - 1, b, a, c);
        }
    }
}
