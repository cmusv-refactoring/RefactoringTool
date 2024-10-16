package cmu.detector.metrics.cohesion;

import cmu.detector.util.TypeLoader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.File;
import java.io.IOException;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LCOMTest {

    @BeforeAll
    public void setUp() throws IOException {
        File dir = new File("src/test/java/cmu/detector/dummy/metrics/cohesion");
        TypeLoader.loadAllFromDir(dir);
    }

    @ParameterizedTest
    @CsvSource({
            "ConnectedClass, 6",
            "DisconnectedClass, 8",
            "HighCohesion, 0",
            "MediumCohesion, 0",
            "NoCohesion, 3",
            "Simple1, 8",
            "Simple1Inner, 8",
            "SimpleClass, 2",

    })
    public void checkLCOM1(String input, double expected) {
        Assertions.fail();
    }

    @ParameterizedTest
    @CsvSource({
            "ConnectedClass, 0.6",
            "DisconnectedClass, 0.7",
            "HighCohesion, 0",
            "MediumCohesion, 0.25",
            "NoCohesion, 0",
            "Simple1, 0.7",
            "Simple1Inner, 0.7",
            "SimpleClass, 0.5",

    })
    public void checkLCOM2(String input, double expected) {
        Assertions.fail();
    }

    @ParameterizedTest
    @CsvSource({
            "ConnectedClass, 0.75",
            "DisconnectedClass, 0.875",
            "HighCohesion, 0",
            "MediumCohesion, 0.33333333",
            "NoCohesion, 0",
            "Simple1, 0.875",
            "Simple1Inner, 0.875",
            "SimpleClass, 0.625",

    })
    public void checkLCOM3(String input, double expected) {
        Assertions.fail();
    }

    @ParameterizedTest
    @CsvSource({
            "ConnectedClass, 1",
            "DisconnectedClass, 2",
            "HighCohesion, 2",
            "MediumCohesion, 1",
            "NoCohesion, 2",
            "Simple1, 3",
            "Simple1Inner, 3",
            "SimpleClass, 1"
    })
    public void checkLCOM4(String input, double expected) {
        Assertions.fail();
    }

}
