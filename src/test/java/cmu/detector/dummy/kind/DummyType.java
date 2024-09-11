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
    private void twoCallChain() {
        String string = new String("1");
        StringBuffer buffer = new StringBuffer();

        buffer.append(string.toString());
    }

    /**
     * Concatenation breaks the chain.
     * For example buffer.append(string.toString() + ""); breaks the chain,
     * leading to 1 method call only
     */
    public void anotherOneCallChain() {
        String string = new String("Concatenation breaks the call chain");
        StringBuffer buffer = new StringBuffer();

        buffer.append(string.toString() + "");
    }

    /**
     * The "buffer.append("1").append("2").append("3");" creates three method calls in a sequence
     */
    public void threeCallChain() {
        StringBuffer buffer = new StringBuffer();

        buffer.append("1").append("2").append("3");
    }

    public void alsoThreeCallChain() {
        String string = new String("");
        StringBuffer buffer = new StringBuffer();


        buffer.append(string.toString()).append(string.toString());
    }

    /**
     * Concatenation breaks the chain.
     * For example buffer.append(string.toString() + "").append(); breaks the chain into two parts
     */
    public void anotherTwoCallChain() {
        String string = new String("");
        StringBuffer buffer = new StringBuffer();

        buffer.append(string.toString() + "").append(string.toString());
    }

    public void forCallChain() {
        String string = new String("");
        StringBuffer buffer = new StringBuffer();

        buffer.append(string.toString()).append(string.toString()).append("one more");
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
