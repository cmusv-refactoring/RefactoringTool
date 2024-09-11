package cmu.detector.metrics;

public enum MetricName {
    CLOC("ClassLinesOfCode"),
    MLOC("MethodLinesOfCode"),
    CC("CyclomaticComplexity"),
    IsAbstract,
    MaxCallChain,
    ParameterCount,
    OverrideRatio,
    PublicFieldCount,
    TCC("TightClassCohesion"),
    MaxNesting,
    NOAV("NumberOfAccessedVariables"),
    NOAM("NumberOfAccessorMethods"),
    WMC("WeightedMethodCount"),
    WOC("WeighOfClass"),
    CINT("CouplingIntensity"),
    CDISP("CouplingDispersion"),
    ChangingClasses("ChangingClasses"),
    ChangingMethods("ChangingMethods"),
    LCOM1("LackOfCohesionOfMethods1"),
    LCOM2("LackOfCohesionOfMethods2"),
    LCOM3("LackOfCohesionOfMethods3"),
    LCOM4("LackOfCohesionOfMethods4");

    private String label;

    MetricName() {
        this.label = name();
    }

    MetricName(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return label;
    }


}
