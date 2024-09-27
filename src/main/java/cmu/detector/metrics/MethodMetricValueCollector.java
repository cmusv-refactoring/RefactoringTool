package cmu.detector.metrics;

import cmu.detector.metrics.calculators.method.MaxCallChainCalculator;

public class MethodMetricValueCollector extends MetricValueCollector{

    public MethodMetricValueCollector() {
        addCalculator(new MaxCallChainCalculator());

    }
}
