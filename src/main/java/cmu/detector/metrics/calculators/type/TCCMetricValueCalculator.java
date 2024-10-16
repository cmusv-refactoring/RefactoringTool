package cmu.detector.metrics.calculators.type;

/**
 * This class computes the Tight Class Cohesion (TCC) for a given class.
 * The Tight Class Cohesion (TCC) measures the ratio between the actual number of visible directly connected methods (we exclude private and static methods)
 * in a class, NDC(C), divided by the number of maximal possible connections between the methods of
 * a class, NP(C).
 * <p>
 * Two visible methods are directly connected if they are accessing the same instance variables of the class or the call trees starting at A and B access the same variable.
 * </p.
 * <p>
 * TCC is defined as:
 * </p>
 * <ul>
 * <li>NP = maximum number of possible connections</li>
 * <li>NP = N * (N − 1) / 2 where N is the number of methods</li>
 * <li>NDC = number of direct connections (number of edges in the connection graph)</li>
 * <li>Tight class cohesion TCC = NDC / NP</li>
 * </ul>
 * <p>
 * TCC is in the range 0..1. The higher the TCC, the more cohesive the class is.
 * </p>
 * <p>
 * According to the authors, TCC &lt; 0.5 is considered non-cohesive.
 * TCC = 1 indicates a maximally cohesive class where all methods are connected.
 * </p>
 * <p>
 * To calculate the Tight Class Cohesion (TCC) for a given class, we need to follow these steps:
 * </p>
 * <ol>
 * <li>Identify the methods and fields in the class.</li>
 * <li>Determine the number of direct connections (NDC) between methods through shared instance variables.</li>
 * <li>Calculate the maximum number of possible connections (NP) between methods.</li>
 * <li>Compute the TCC value using the formula: TCC = NDC / NP.</li>
 * </ol>
 * <p>
 * Adapted from <a href="https://www.aivosto.com/project/help/pm-oo-cohesion.html#TCC_LCC">Aivosto</a>
 * </p>
 *
 * @author Leonardo Sousa
 */
public class TCCMetricValueCalculator {

}
