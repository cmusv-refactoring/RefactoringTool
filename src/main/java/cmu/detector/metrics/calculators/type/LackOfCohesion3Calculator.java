package cmu.detector.metrics.calculators.type;

/**
 * Class to calculate the LCOM3 (Lack of Cohesion of Methods) metric.
 *
 * <p>
 * The equation to calculate LCOM3 is:
 * </p>
 * <ul>
 *   <li><code>m = #declaredMethods(C)</code></li>
 *   <li><code>a = #declaredAttributes(C)</code></li>
 *   <li><code>m(A) = # of methods in C that reference attribute A</code></li>
 *   <li><code>s = sum(m(A)) for A in declaredAttributes(C)</code></li>
 *   <li><code>LCOM3(C) = (m - s / a) / (m - 1)</code></li>
 * </ul>
 *
 * <p>
 * <strong>Observation:</strong> <code>timesAccessedAttributes</code> comprises the value of <code>s</code>.
 * </p>
 *
 * <p>
 * The metric definition, as well as its implementation details, are available at:
 * <ul>
 *   <li><a href="http://www.aivosto.com/project/help/pm-oo-cohesion.html">Aivosto - OO Cohesion</a></li>
 *   <li><a href="http://www.cs.sjsu.edu/~pearce/cs251b/DesignMetrics.htm">CS251B Design Metrics</a></li>
 * </ul>
 * </p>
 *
 * @author Leonardo Sousa
 */

public class LackOfCohesion3Calculator {

}
