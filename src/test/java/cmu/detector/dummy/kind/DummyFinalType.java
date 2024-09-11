package cmu.detector.dummy.kind;

/**
 * This class has 15 methods: 5 declared here plus 10 defined in DummyType
 */
public final class DummyFinalType extends DummyType {
    public boolean value;

    public DummyFinalType() {
        super();
    }

    private void anotherMethod(){}

    @Override
    public int getValue() {
        return super.getValue();
    }

    @Override
    public void setValue(int value) {
        super.setValue(value);
    }

    public boolean isValue() {
        return value;
    }
}
