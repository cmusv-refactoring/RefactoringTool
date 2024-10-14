package cmu.detector.dummy.metrics.cohesion;

/**
 * This class demonstrates the calculation of Tight Class Cohesion (TCC).
 * <p>
 * TCC measures the cohesion of a class by evaluating the ratio of the number of actual direct connections
 * between methods to the maximum number of possible connections.
 * </p>
 * <p>
 * For the {@code NoCohesion}, we have the following analysis:
 * </p>
 * <ul>
 *   <li>Instance Variable (we exclude static attributes):
 *      <ul>
 *          <li>{@code null}</li>
 *      </ul>
 *   <li>Instance Methods (we exclude static and private methods):
 *     <ul>
 *       <li>{@code public void m1()}</li>
 *       <li>{@code public void m2()}</li>
 *     </ul>
 *   </li>
 * </ul>
 * <p>
 * Direct connections are established through shared instance variables. This class has zero instances variables.
 * Therefore, this class has NDC {@code 0}.
 * <p>
 * The maximum number of possible connections (NP) between the methods is calculated as follows (where N is the number of methods in the class excluding static methods):
 * </p>
 * <pre>
 * {@code NP = N * (N - 1) / 2}
 * </pre>
 * <p>
 * Where {@code N} is the number of methods in the class.
 * </p>
 * <pre>
 * {@code NP = 3 * (3 - 1) / 2 = 3}
 * </pre>
 * <p>
 * TCC is given by:
 * </p>
 * <pre>
 * {@code TCC = NDC / NP = 0 / 3 = 0}
 * </pre>
 * <p>
 * <p>
 * Another metric used for cohesion is the Lack of Cohesion:
 * <table>
 *   <tr>
 *     <th>LCOM Metric</th>
 *     <th>Value</th>
 *   </tr>
 *   <tr>
 *     <td>LCOM1</td>
 *     <td>0</td>
 *   </tr>
 *   <tr>
 *     <td>LCOM2</td>
 *     <td>0.25</td>
 *   </tr>
 *   <tr>
 *     <td>LCOM3</td>
 *     <td>0.33333333</td>
 *   </tr>
 *   <tr>
 *     <td>LCOM4</td>
 *     <td>2</td>
 *   </tr>
 * </table>
 * <p>
 * <p>
 * Test example extracted from <a href="https://www.aivosto.com/project/help/pm-oo-cohesion.html#TCC_LCC">Aivosto</a> and
 * <a href="https://github.com/mauricioaniche/ck/tree/master/fixtures/ClassCohesion">GitHub</a>.
 * </p>
 */
class NoCohesion {
	private static int a = 10;

	public void m1() {
		int a = 10;

	}

	public void m2() { a = 10; }

	private static void m3() { a = 10; }

	private void m4() { a = 10; }
}