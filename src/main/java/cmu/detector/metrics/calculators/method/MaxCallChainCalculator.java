package cmu.detector.metrics.calculators.method;

import cmu.detector.ast.visitors.MaxCallChainVisitor;
import cmu.detector.metrics.MetricName;
import cmu.detector.metrics.calculators.MetricValueCalculator;
import org.eclipse.jdt.core.dom.ASTNode;

public class MaxCallChainCalculator extends MetricValueCalculator {

    @Override
    protected Double computeValue(ASTNode target) {
        MaxCallChainVisitor visitor = new MaxCallChainVisitor();
        target.accept(visitor);

        return visitor.getMaxCallChain().doubleValue();
    }

    @Override
    public MetricName getMetricName() {
        return MetricName.MaxCallChain;
    }
}
