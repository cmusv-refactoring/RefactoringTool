package cmu.detector.resources;

import cmu.detector.metrics.MetricName;
import cmu.detector.resources.loader.SourceFile;
import cmu.detector.smells.Smell;
import cmu.detector.smells.SmellName;
import org.eclipse.jdt.core.dom.*;

import java.util.*;

public abstract class Resource {

    private SourceFile sourceFile;

    private String fullyQualifiedName;

    private final Map<MetricName, Double> metricsValues;

    private final transient ASTNode node;

    private String kind;

    private final List<Smell> smells;

    public Resource(SourceFile sourceFile, ASTNode node) {
        this.metricsValues = new HashMap<>();
        this.sourceFile = sourceFile;
        this.node = node;
        this.smells = new ArrayList<>();

        identifyKind();
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public ASTNode getNode() {
        return node;
    }


    /**
     * Line in the source file where node starts (important for code smells)
     * @return line where node starts
     */
    public int getStartLineNumber() {
        CompilationUnit compUnit = sourceFile.getCompilationUnit();
        return compUnit.getLineNumber(node.getStartPosition());
    }

    public int getEndLineNumber() {
        CompilationUnit compUnit = sourceFile.getCompilationUnit();
        return compUnit.getLineNumber(node.getStartPosition() + node.getLength());
    }

    public void addMetricValue(MetricName metricName, Double value) {
        this.metricsValues.put(metricName, value);
    }

    public SourceFile getSourceFile() {
        return sourceFile;
    }

    protected void setSourceFile(SourceFile sourceFile) {
        this.sourceFile = sourceFile;
    }

    public Double getMetricValue(MetricName metricName) {
        return this.metricsValues.get(metricName);
    }

    public String getFullyQualifiedName() {
        return fullyQualifiedName;
    }

    protected void setFullyQualifiedName(String fullyQualifiedName) {
        this.fullyQualifiedName = fullyQualifiedName;
    }

    public void addAllSmells(Collection<Smell> smells) {
        this.smells.addAll(smells);
    }

    public boolean hasSmell(SmellName targetSmell) {
        for (Smell smell : this.smells) {
            if (smell.getName().equals(targetSmell)) {
                return true;
            }
        }
        return false;
    }

    protected abstract void identifyKind();
}
