package cmu.detector.dummy.kind;

/**
 * This class has 12 methods: 11 declared here plus 1 declared in the interface
 */
public class DummyType implements DummyInterface {
    private int value;

    DummyType() {
        StringBuffer buffer = new StringBuffer();
    }

    private void oneCallChain() {
        StringBuffer buffer = new StringBuffer();

        buffer.append("One method call: .append");
    }

    /**
     * The "buffer.append(string.toString());" creates two method calls in a sequence
     */
    private void oneMoreCallChain() {
        String string = new String("1");
        StringBuffer buffer = new StringBuffer();

        buffer.append(string.toString());
    }

    public void anotherOneCallChain() {
        String string = new String("Concatenation breaks the call chain");
        StringBuffer buffer = new StringBuffer();

        buffer.append(string.toString() + "");
    }

    public void twoCallChain() {
        String string = new String("");
        StringBuffer buffer = new StringBuffer();


        buffer.append(string.toString()).append(string.toString());
    }

    public void anotherTwoCallChain() {
        String string = new String("");
        StringBuffer buffer = new StringBuffer();

        buffer.append(string.toString() + "").append(string.toString());
    }

    /**
     * The "buffer.append("1").append("2").append("3");" creates three method calls in a sequence
     */
    public void threeCallChain() {
        StringBuffer buffer = new StringBuffer();

        buffer.append("1").append("2").append("3");
    }

    public void fourCallChain() {
        String string = new String("");
        StringBuffer buffer = new StringBuffer();

        buffer.append(string.toString()).append("2").append("one more").append("4");
    }

    @Override
    public void dummyInterfaceMethod() {

    }

    public int getValue() {
        return value;
    }

    public int getFakeValue(int parameter) {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
