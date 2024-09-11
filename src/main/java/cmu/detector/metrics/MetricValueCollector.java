package cmu.detector.metrics;

import cmu.detector.metrics.calculators.MetricValueCalculator;
import cmu.detector.resources.Resource;
import org.eclipse.jdt.core.dom.ASTNode;

import java.util.ArrayList;
import java.util.List;

public abstract class MetricValueCollector {

    private List<MetricValueCalculator> calculators;

    public MetricValueCollector() {
        this.calculators = new ArrayList<>();
    }

    protected void addCalculator(MetricValueCalculator calculator) {
        this.calculators.add(calculator);
    }

    public void collect(Resource resource) {
        for (MetricValueCalculator calculator : this.calculators) {
            ASTNode node = resource.getNode();
            Double value = calculator.getValue(node);
            resource.addMetricValue(calculator.getMetricName(), value);
        }
    }
}
