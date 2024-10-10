package cmu.detector.dummy.metrics.cohesion;

/**
 * This class demonstrates the calculation of Tight Class Cohesion (TCC).
 * <p>
 * TCC measures the cohesion of a class by evaluating the ratio of the number of actual direct connections
 * between methods to the maximum number of possible connections.
 * </p>
 * <p>
 * For the {@code MediumCohesion}, we have the following analysis:
 * </p>
 * <ul>
 *   <li>Instance Variable (we exclude static attributes):
 *      <ul>
 *          <li>{@code private int a}</li>
 *      </ul>
 *   <li>Instance Methods (we exclude static and private methods):
 *     <ul>
 *       <li>{@code public void m1()}</li>
 *       <li>{@code public void m2() -> a}</li>
 *       <li>{@code public void m3() -> a}</li>
 *     </ul>
 *   </li>
 * </ul>
 * <p>
 * Direct connections are established through shared instance variables, or the call trees starting at A and B access
 * the same class-level variable. From these connections, we can derive the following pairs of methods that interact through the instance variable {@code a}:
 * </p>
 * <ul>
 *   <li>{@code (m2, m3) -> a} (shared variable) </li>
 *   <li>{@code (m3, m4) -> a} (call tree) </li>
 * </ul>
 * <p>
 * Notice that both m3 and m4 access variable a. Since, m3 calls m4, they are directly connected via call tree although m4 is private.
 * Therefore, the number of direct connections (NDC) is {@code 2}.
 * </p>
 * <p>
 * The maximum number of possible connections (NP) between the methods is calculated as follows (where N is the number of methods in the class excluding static methods):
 * </p>
 * <pre>
 * {@code NP = N * (N - 1) / 2}
 * {@code NP = 4 * (4 - 1) / 2 = 6}
 * </pre>
 * <p>
 * TCC is given by:
 * </p>
 * <pre>
 * {@code TCC = NDC / NP = 2 / 6 = 0.33333333}
 * </pre>
 * <p>
 * When TCC<1, all existing connections are direct (even though not all methods are connected).
 * </p>
 * <p>
 * </p>
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
 *     <td>1</td>
 *   </tr>
 * </table>
 * <p>
 * Test example adapted from <a href="https://www.aivosto.com/project/help/pm-oo-cohesion.html#TCC_LCC">Aivosto</a> and
 * <a href="https://github.com/mauricioaniche/ck/tree/master/fixtures/ClassCohesion">GitHub</a>.
 * </p>
 */
class MediumCohesion {
	private String a = "";

	public void m1() {
		int a = 10;
	}

	public void m2() { a = "m2"; }

	public void m3() {
		a = "m3";
		m4();
	}

	private void m4() {
		a = "m4";
		m1();
	}
}