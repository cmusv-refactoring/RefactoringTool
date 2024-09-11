package cmu.detector.dummy.kind;

/**
 * This class has 11 methods: 9 explicitly defined methods and 1 default constructor
 *
 * TCC = 0.0 None method interact
 */
public abstract class DummyAbstractType {
    public void publicMethod() {
        System.out.println("expected: public method");
    }

    // Protected method
    protected void protectedMethod() {
        System.out.println("expected: protected method");
    }

    // Private method
    private void privateMethod() {
        System.out.println("expected: private method");
    }

    // Package-private method (default)
    void packagePrivateMethod() {
        System.out.println("expected: package-private method");
    }

    // Static methods
    public static void publicStaticMethod() {
        System.out.println("expected: public static method");
    }

    static void packagePrivateStaticMethod() {
        System.out.println("expected: package-private static method");
    }

    // Final methods
    private final void privateFinalMethod() {
        System.out.println("expected: private final method");
    }

    final void packagePrivateFinalMethod() {
        System.out.println("expected: package-private final method");
    }

    public abstract void publicAbstractMethod();

    abstract void packagePrivateAbstractMethod();
}

