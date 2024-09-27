package cmu.detector.metrics.calculators.type;

import cmu.detector.ast.visitors.PublicFieldCountVisitor;
import cmu.detector.metrics.MetricName;
import cmu.detector.metrics.calculators.MetricValueCalculator;
import org.eclipse.jdt.core.dom.ASTNode;

public class PublicFieldCountCalculator extends MetricValueCalculator {
    @Override
    protected Double computeValue(ASTNode target) {
        PublicFieldCountVisitor visitor = new PublicFieldCountVisitor();
        target.accept(visitor);

        int count = visitor.getPublicFieldCount();

        return Double.valueOf(count);
    }

    @Override
    public MetricName getMetricName() {
        return MetricName.PublicFieldCount;
    }
}
