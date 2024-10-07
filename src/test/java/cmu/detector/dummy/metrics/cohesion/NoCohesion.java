package cmu.detector.dummy.metrics.cohesion;

/**
 * METRICS
 * <p>
 * TCC: 0
 * </p>
 * <ul>
 *     <li>NDC = 0</li>
 *     <li>NP = 2</li>
 * </ul>
 * <p>
 * Direct connections are established through shared instance variables. Since <code>a</code> is a static variable, it is not considered
 * an instance variable for the purposes of TCC, which focuses on instance variables shared between non-static methods.
 * </p>
 * <p>
 * In this class, all accesses are to the static variable <code>a</code>. Therefore, we need to check connections between non-static
 * methods (<code>m1</code>, <code>m2</code>, and <code>m4</code>) through this static variable. However, since <code>a</code> is static, it does not contribute to
 * instance-based direct connections. Thus, there are no direct connections between instance methods based on shared
 * instance variables.
 * </p>
 * <ul>
 *     <li><code>m1</code>: Does not connect to <code>a</code> in the context of instance variables.</li>
 *     <li><code>m2</code>: Connects to <code>a</code>, but <code>a</code> is static.</li>
 *     <li><code>m3</code>: Static method, does not contribute to instance-based connections.</li>
 *     <li><code>m4</code>: Connects to <code>a</code>, but <code>a</code> is static.</li>
 * </ul>
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