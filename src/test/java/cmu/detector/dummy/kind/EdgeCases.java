package cmu.
        detector.
        // should ignore this comment
        dummy.
        /*
        should ignore this comment
         */
        kind;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.Serial;import java.util.stream.Stream;

public class/* should ignore this comment*/
EdgeCases {

    // LOC = 5
    public void method1(int x,
                        int y)
    {
        System.out.println("method1(" + x + "," + y + ")");
    }

    // LOC = 9
    public void method2(int x,

                        int y,
                        int z)
    {
        int a =
                x +
                        y +
                        z;
    }

    // LOC = 6
    private void method3(
            int x)
    {

        System.out /*
         ignore
         this
         block
        */        .println("expected: private final method");
    }


    // LOC = 10
    @Serial

    public String method4() {
        return
                "User{" +
                        "id=" + 1 +

                        ", username='" + "leo" + '\'' +
                        ", age=" + 10 +

                        ", salary=" + 100 +
                        '}';
    }

    // LOC = 8
    @ParameterizedTest
    @MethodSource({
            "provideTestArgumentsForClassNames",
            "provideTestArgumentsForInterfaceNames"
    })
    void testMultipleAnnotation(String className, String declaration) {
        System.out.println("Class/Interface Name: " + className + " | Declaration: " + declaration);
    }

    // LOC = 6
    static Stream<Arguments> provideTestArgumentsForClassNames() {
        return Stream.of(
                Arguments.of("DummyFinalType", "public final class"),
                Arguments.of("DummyType", "public class")
        );
    }

    // LOC = 5
    static Stream<Arguments> provideTestArgumentsForInterfaceNames() {
        return Stream.of(
                Arguments.of("DummyInterface", "public interface")
        );
    }
}
// Class LOC = 60