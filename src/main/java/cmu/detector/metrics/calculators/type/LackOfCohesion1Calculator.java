package cmu.detector.metrics.calculators.type;


/**
 * Class to calculate the LCOM1 (Lack of Cohesion of Methods) metric.
 *
 * <p>
 * LCOM1 was introduced in the <a href="https://www.aivosto.com/project/help/pm-oo-ck.html">Chidamber & Kemerer</a> metrics suite. It is also known as LCOM or LOCOM, and is calculated as follows:
 * </p>
 * <ul>
 *   <li>Take each pair of instance methods in the class (we don't consider static methods because they belong to the class rather than the instance).</li>
 *   <li>If they access disjoint sets of instance variables (i.e., non-static variables), we increase the <code>P</code> by one.</li>
 *   <li>If they share at least one variable access, increase <code>Q</code> by one.</li>
 *   <li><code>LCOM1 = P − Q</code>, if <code>P > Q</code></li>
 *   <li><code>LCOM1 = 0</code> otherwise</li>
 * </ul>
 *
 * <p>
 * Interpretation:
 * </p>
 * <ul>
 *   <li><code>LCOM1 = 0</code> indicates a cohesive class.</li>
 *   <li><code>LCOM1 > 0</code> indicates that the class could benefit from being split into two or more classes, as its variables belong in disjoint sets.</li>
 * </ul>
 *
 * <p>
 * Classes with a high LCOM1 value have been found to be fault-prone.
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
public class LackOfCohesion1Calculator {

}
