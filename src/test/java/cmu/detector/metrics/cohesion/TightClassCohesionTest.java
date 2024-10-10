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
public class TightClassCohesionTest {

    @BeforeAll
    public void setUp() throws IOException {
        File dir = new File("src/test/java/cmu/detector/dummy/metrics/cohesion");
        TypeLoader.loadAllFromDir(dir);
    }

    @ParameterizedTest
    @CsvSource({
            "ConnectedClass, 0.4",
            "DisconnectedClass, 0.2",
            "HighCohesion, 1.0",
            "MediumCohesion, 0.33333333",
            "NoCohesion, 0",
            "Simple1, 0.1",
            "Simple1Inner, 0.1",
            "SimpleClass, 0.4",
    })
    public void checkTCC(String input, double expected) {
        Assertions.fail();
    }

}
