package cmu.detector.metrics.calculators.type;

/**
 * Class to calculate the LCOM3 (Lack of Cohesion of Methods 3) metric.
 * <p>
 * LCOM4 is the lack of cohesion metric we adapted from <a href="https://www.aivosto.com/project/help/pm-oo-cohesion.html#LCOM4">Hitz & Montazeri</a>
 *
 * LCOM4 measures the number of "connected components" in a class. A connected component
 * is a set of related methods (and class-level variables). There should be only one
 * such component in each class. If there are 2 or more components, the class should be
 * split into so many smaller classes.
 *</p>
 * <p>Which methods are related? Methods A and B are related if:</p>
 * <ul>
 *   <li>they both access the same class-level variable, or</li>
 *   <li>A calls B or vice versa.</li>
 * </ul>
 *
 * <p>After determining the related methods, we draw a graph linking the related methods
 * to each other. LCOM4 equals the number of connected groups of methods.</p>
 *
 * <p>LCOM4 interpretation:</p>
 * <ul>
 *   <li>LCOM4=1 indicates a cohesive class, which is the "good" class.</li>
 *   <li>LCOM4>=2 indicates a problem. The class should be split into so many smaller classes.</li>
 *   <li>LCOM4=0 happens when there are no methods in a class. This is also a "bad" class.</li>
 * </ul>
 *
 * <strong>Observation:</strong> We DO NOT ignore static variables and methods.
 *
 * @author Leonardo Sousa
 */
public class LackOfCohesion4Calculator {

}
