package cmu.detector;

import cmu.detector.console.ToolParameters;
import cmu.detector.console.output.ObservableExclusionStrategy;
import cmu.detector.metrics.MethodMetricValueCollector;
import cmu.detector.metrics.TypeMetricValueCollector;
import cmu.detector.smells.detectors.ClassLevelSmellDetector;
import cmu.detector.smells.detectors.MethodLevelSmellDetector;
import cmu.detector.smells.Smell;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import cmu.detector.resources.Method;
import cmu.detector.resources.Type;
import cmu.detector.resources.loader.JavaFilesFinder;
import cmu.detector.resources.loader.SourceFile;
import cmu.detector.resources.loader.SourceFilesLoader;
import org.apache.commons.cli.ParseException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RefactoringEngine {

    public static void main(String[] args) throws IOException{
        RefactoringEngine instance = new RefactoringEngine();

        instance.start(args);

    }

    private void start(String[] args) throws IOException {
        ToolParameters parameters = ToolParameters.getInstance();

        try {
            parameters.parse(args);
        } catch (ParseException exception) {
            System.out.println(exception.getMessage());
            parameters.printHelp();

            System.exit(-1);
        }

        System.out.println(new Date());

        List<String> sourcePaths = List.of(parameters.getValue(ToolParameters.SOURCE_FOLDER));
        List<Type> allTypes = this.loadAllTypes(sourcePaths);

        collectTypeMetrics(allTypes);

        saveInfoFile(allTypes);

        System.out.println(new Date());

    }

    private List<Type> loadAllTypes(List<String> sourcePaths) throws IOException {
        List<Type> allTypes = new ArrayList<>();

        JavaFilesFinder javaFilesFinder = new JavaFilesFinder(sourcePaths);
        SourceFilesLoader sourceFilesLoader = new SourceFilesLoader(javaFilesFinder);
        List<SourceFile> sourceFiles = sourceFilesLoader.getLoadedSourceFiles();

        for (SourceFile sourceFile : sourceFiles) {
            allTypes.addAll(sourceFile.getTypes());
        }

        return allTypes;
    }

    private void collectTypeMetrics(List<Type> types) {
        for (Type type : types) {
            TypeMetricValueCollector typeCollector = new TypeMetricValueCollector();
            typeCollector.collect(type);

            this.collectMethodMetrics(type);
        }
    }

    private void collectMethodMetrics(Type type) {
        for (Method method: type.getMethods()) {
            MethodMetricValueCollector methodCollector = new MethodMetricValueCollector();
            methodCollector.collect(method);
        }
    }

    private void saveInfoFile(List<Type> smellyTypes) throws IOException {
        ToolParameters parameters = ToolParameters.getInstance();
        File smellsFile = new File(parameters.getValue(ToolParameters.OUTPUT_FILE));
        BufferedWriter writer = new BufferedWriter(new FileWriter(smellsFile));
        System.out.println("\nSaving info in file...");

        GsonBuilder builder = new GsonBuilder();
        builder.addSerializationExclusionStrategy(new ObservableExclusionStrategy());
        builder.disableHtmlEscaping();
        builder.setPrettyPrinting();
        builder.serializeNulls();

        Gson gson = builder.create();
        gson.toJson(smellyTypes, writer);
        writer.close();
    }
}
