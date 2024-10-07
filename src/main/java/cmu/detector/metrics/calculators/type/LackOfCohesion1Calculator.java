package cmu.detector.metrics.calculators.type;


/**
 * Class to calculate the LCOM1 (Lack of Cohesion of Methods) metric.
 *
 * <p>
 * LCOM1 was introduced in the <a href="https://www.aivosto.com/project/help/pm-oo-ck.html">Chidamber & Kemerer</a> metrics suite. It is also known as LCOM or LOCOM, and is calculated as follows:
 * </p>
 * <ul>
 *   <li>Take each pair of methods in the class.</li>
 *   <li>If they access disjoint sets of class variables (attributes), increase <code>P</code> by one.</li>
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
 * @author Leonardo Sousa
 */

public class LackOfCohesion1Calculator {

}
