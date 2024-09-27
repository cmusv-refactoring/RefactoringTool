package cmu.detector.metrics;

import cmu.detector.metrics.calculators.type.PublicFieldCountCalculator;

public class TypeMetricValueCollector extends MetricValueCollector {

	public TypeMetricValueCollector() {
		addCalculator(new PublicFieldCountCalculator());
	}

}
