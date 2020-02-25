package src.designPattern.adapter.extend;

public class AdapterImpl extends AdapteeClass implements Adapter {


    @Override
    public void handle() {
        handleMethod();
    }
}
