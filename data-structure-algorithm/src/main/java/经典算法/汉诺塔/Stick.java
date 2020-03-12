package 经典算法.汉诺塔;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stick {
    Character stickName;
    List<Integer> trayList;
    List<Integer> setList;

    public Integer moveToTray(Stick target) {
        Integer remove = trayList.remove(trayList.size() - 1);
        target.getTrayList().add(remove);
        return remove;
    }

    public Integer moveToSet(Stick target) {
        Integer remove = trayList.remove(trayList.size() - 1);
        target.getSetList().add(remove);
        return remove;
    }

    @Override
    public Stick clone() {
        return new Stick(stickName, new ArrayList<>(trayList), new ArrayList<>(setList));
    }

}
