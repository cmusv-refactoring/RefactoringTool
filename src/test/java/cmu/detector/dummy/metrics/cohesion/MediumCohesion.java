package cmu.detector.dummy.metrics.cohesion;

/**
 * This class demonstrates the calculation of Tight Class Cohesion (TCC).
 * <p>
 * TCC measures the cohesion of a class by evaluating the ratio of the number of actual direct connections
 * between methods to the maximum number of possible connections.
 * </p>
 * <p>
 * For the class {@code MediumCohesion}, we have the following analysis:
 * </p>
 * <ul>
 *   <li>Instance Variable: {@code private String a}</li>
 *   <li>Methods:
 *     <ul>
 *       <li>{@code public void m1()}</li>
 *       <li>{@code public void m2()}</li>
 *       <li>{@code public void m3()}</li>
 *       <li>{@code private void m4()}</li>
 *     </ul>
 *   </li>
 * </ul>
 * <p>
 * Direct connections are established through shared instance variables. In this class, the instance variable {@code a}
 * is accessed by several methods, leading to the following connections:
 * </p>
 * <ul>
 *   <li>{@code m2} connects to {@code a}.</li>
 *   <li>{@code m3} connects to {@code a} and calls {@code m4}.</li>
 *   <li>{@code m4} connects to {@code a} and calls {@code m1}.</li>
 * </ul>
 * <p>
 * From these connections, we can derive the following pairs of methods that interact through the class variable {@code a}:
 * </p>
 * <ul>
 *   <li>({@code m2}, {@code m3})</li>
 *   <li>({@code m2}, {@code m4})</li>
 *   <li>({@code m3}, {@code m4})</li>
 * </ul>
 * <p>
 * Therefore, the number of direct connections (NDC) is 3.
 * </p>
 * <p>
 * The maximum number of possible connections (NP) between the methods is calculated as follows:
 * </p>
 * <pre>
 * NP = N * (N - 1) / 2
 * </pre>
 * <p>
 * Where {@code N} is the number of public methods in the class. Here, {@code N = 3} (m1, m2, m3).
 * </p>
 * <pre>
 * NP = 3 * (3 - 1) / 2 = 3
 * </pre>
 * <p>
 * TCC is given by:
 * </p>
 * <pre>
 * TCC = NDC / NP = 3 / 3 = 1.0
 * </pre>
 * <p>
 * This indicates that the class has a TCC value of 1.0, meaning it is highly cohesive, as all methods interact with the instance variable {@code a}.
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