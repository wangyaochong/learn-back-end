package src.designPattern.adapter.composite;

public class AdapterImpl implements Adapter {
    private AdapteeClass adapteeClass;

    public AdapterImpl(AdapteeClass adapteeClass) {
        this.adapteeClass = adapteeClass;
    }

    @Override
    public void handle() {
        adapteeClass.handleMethod();
    }
}
