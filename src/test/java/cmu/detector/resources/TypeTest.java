package cmu.detector.resources;

import cmu.detector.util.TypeLoader;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.File;
import java.io.IOException;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TypeTest {

    @BeforeAll
    public void setUp() throws IOException {
        File dir = new File("src/test/java/cmu/detector/dummy/kind");
        TypeLoader.loadAllFromDir(dir);
    }

    @Test
    public void identifyKindType() {
        Type typeClass = TypeLoader.findTypeByName("DummyAbstractType");

        Assertions.assertEquals("public abstract class", typeClass.getKind());
    }

    @ParameterizedTest
    @CsvSource({
            "DummyFinalType, public final class",
            "DummyInterface, public interface",
            "DummyType, public class"
    })
    public void identifyKindMultipleTypes(String input, String expected) {
        Type typeClass = TypeLoader.findTypeByName(input);
        Assertions.assertEquals(expected, typeClass.getKind());
    }

    @ParameterizedTest
    @CsvSource({
            "publicMethod, public method",
            "protectedMethod, protected method",
            "privateMethod, private method",
            "packagePrivateMethod, package-private method",
            "publicStaticMethod, public static method",
            "packagePrivateStaticMethod, package-private static method",
            "privateFinalMethod, private final method",
            "packagePrivateFinalMethod, package-private final method",
            "publicAbstractMethod, public abstract method",
            "protectedAbstractMethod, package-private abstract method"

    })
    public void identifyMethodMultipleTypes(String input, String expected) {
        Type typeClass = TypeLoader.findTypeByName("DummyAbstractType");
        List<Method> methods = typeClass.getMethods();
        Assertions.assertEquals(10, methods.size());


        for (Method method : methods) {
            MethodDeclaration dc = (MethodDeclaration) method.getNode();
            if (input.equals(dc.getName().toString())) {
                Assertions.assertEquals(expected, method.getKind());
            }
        }

    }
}