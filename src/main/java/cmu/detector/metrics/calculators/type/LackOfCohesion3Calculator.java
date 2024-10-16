package cmu.detector.metrics.calculators.type;

/**
 * Class to calculate the LCOM3 (Lack of Cohesion of Methods 3) metric.
 *
 * <p>
 * The equation to calculate LCOM3 is:
 * </p>
 * <ul>
 *   <li><code>m = #declaredInstanceMethods(C)</code></li>
 *   <li><code>a = #declaredInstanceAttributes(C)</code></li>
 *   <li><code>m(A) = # of instance methods in C that reference instance attribute A</code></li>
 *   <li><code>s = sum(m(A)) for A in declaredInstanceAttributes(C)</code></li>
 *   <li><code>LCOM3(C) = (m - s / a) / (m - 1)</code></li>
 * </ul>
 *
 * <p>
 * <strong>Observation:</strong> We ignore static variables and methods. If the class has no attributes or 1 method, calculating LCOM3 is impossible due to division by zero, so we assign it a value of 0.
 * </p>
 *
 * <p>
 * The metric definition, as well as its implementation details, are available at:
 * <ul>
 *   <li><a href="https://www.cs.sjsu.edu/~pearce/cs251b/DesignMetrics.htm">LCOM1, LCOM2 and LCOM3</a></li>
 *   <li><a href="http://www.aivosto.com/project/help/pm-oo-cohesion.html">Aivosto - OO Cohesion</a></li>
 * </ul>
 * </p>
 *
 * @author Leonardo Sousa
 */
public class LackOfCohesion3Calculator {

}
