package 经典算法.汉诺塔;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 拆成两步，非常容易理解，
 * 1.将所有origin的top(除了最底下一个)移动到available上，然后将origin最底下的移动到target
 * 2.把available看成origin重复1
 * <p>
 * <p>
 * 由于递归时引用同一个对象，所以使用Stick对象的版本会更复杂一些
 */


public class HanoiTowerRecordPath {
    public List<Integer> toBeSetList;

    public void moveAllTo(Stick origin, Stick available, Stick target) {
        if (origin.getTrayList().size() == 1) {
            moveToTrayOrSet(origin, target);
        } else {
            List<Integer> trayList = new ArrayList<>(origin.getTrayList());
            origin.getTrayList().clear();
            origin.getTrayList().add(trayList.remove(0));
            Stick top = new Stick(origin.getStickName(), trayList, origin.getSetList());
            //available可以理解成移动中转平台，但是在中转的过程中，以前摆好的数字不应该再动了
            // 把上面的所有盘子移动到available，注意，以前有部分是非调动中的，只应该把available的缓存部分移动
            List<Integer> cache = new ArrayList<>(available.getTrayList());
            available.getTrayList().clear();
            moveAllTo(top, target, available);
            moveToTrayOrSet(origin, target);
            moveAllTo(available, origin, target);
            available.getTrayList().addAll(cache);
        }
    }

    //移动调动中的或已经摆放好的
    public void moveToTrayOrSet(Stick origin, Stick target) {
        if (target.getStickName() == 'C' && origin.getTrayList().get(0).equals(toBeSetList.get(0))) {
            toBeSetList.remove(0);
            Integer integer = origin.moveToSet(target);
            System.out.println(origin.getStickName() + "-->" + target.getStickName() + "=" + integer);
        } else {
            Integer integer = origin.moveToTray(target);
            System.out.println(origin.getStickName() + "-->" + target.getStickName() + "=" + integer);
        }
        System.out.println(target);
    }


    @Test
    public void test() {
        Stick a = new Stick('A', new ArrayList<>(), new ArrayList<>());
        toBeSetList = new ArrayList<>();
        toBeSetList.add(6);
        toBeSetList.add(5);
        toBeSetList.add(4);
        toBeSetList.add(3);
        toBeSetList.add(2);
        toBeSetList.add(1);
        for (Integer integer : toBeSetList) {
            a.getTrayList().add(integer);
        }
        moveAllTo(a, new Stick('B', new ArrayList<>(), new ArrayList<>()), new Stick('C', new ArrayList<>(), new ArrayList<>()));
    }

}
