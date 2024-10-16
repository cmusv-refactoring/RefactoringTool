package cmu.detector.metrics.calculators.type;

/**
 * Class to calculate the LCOM2 (Lack of Cohesion of Methods 2) metric.
 *
 * <p>
 * The equation to calculate LCOM2 is:
 * </p>
 * <ul>
 *   <li><code>m = #declaredInstanceMethods(C)</code></li>
 *   <li><code>a = #declaredInstanceAttributes(C)</code></li>
 *   <li><code>m(A) = # of instance methods in C that reference instance attribute A</code></li>
 *   <li><code>s = sum(m(A)) for A in declaredInstanceAttributes(C)</code></li>
 *   <li><code>LCOM2(C) = 1 - s / (m * a)</code></li>
 * </ul>
 *
 * <p>
 * <strong>Observation:</strong> We ignore static variables and methods. If the class has no attributes or methods, calculating LCOM2 is impossible due to division by zero, so we assign it a value of 0.
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
public class LackOfCohesion2Calculator {

}
