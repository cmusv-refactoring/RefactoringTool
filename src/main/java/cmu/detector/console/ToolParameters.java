package cmu.detector.console;

import org.apache.commons.cli.*;

public class ToolParameters {

    public static final String SOURCE_FOLDER = "source-folder";
    public static final String OUTPUT_FILE = "output-file";
    public static final String IGNORE_TESTS = "ignore-tests";
    public static final String ONLY_SMELLY = "only-smelly";

    private Options options;

    private CommandLine line;

    private static ToolParameters singleton;

    static {
        singleton = new ToolParameters();
    }

    private ToolParameters() {
        options = new Options();
        createOptions();
    }

    public static ToolParameters getInstance() {
        return singleton;
    }

    public boolean shouldFilterSmelly() {
        return line.hasOption(ONLY_SMELLY);
    }

    private void createOptions() {
        Option smellsFile = Option.builder("out")
                .longOpt(OUTPUT_FILE)
                .desc("File where all the information will be saved in JSON format")
                .hasArg()
                .argName("file")
                .required()
                .build();

        Option sourceFolder = Option.builder("src")
                .longOpt(SOURCE_FOLDER)
                .desc("Folder containing all Java files to be analyzed")
                .required()
                .hasArg()
                .argName("folder")
                .build();

        Option ignoreTests = Option.builder("it")
                .longOpt(IGNORE_TESTS)
                .desc("Ignore all the test classes")
                .build();

        Option ignoreNonSmelly = Option.builder("os")
                .longOpt(ONLY_SMELLY)
                .desc("If this flag is used, only classes and methods containing code smells will be part of the output")
                .build();

        options.addOption(smellsFile);
        options.addOption(sourceFolder);
        options.addOption(ignoreTests);
        options.addOption(ignoreNonSmelly);
    }

    public String getValue(String key) {
        return this.line.getOptionValue(key);
    }

    public void parse(String[] args) throws ParseException {
        CommandLineParser parser = new DefaultParser();
        this.line = parser.parse(getOptions(), args);
    }

    public void printHelp() {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("smell-detector", new ToolParameters().getOptions() );
    }

    public Options getOptions() {
        return options;
    }
}
