package cmu.detector.dummy.metrics.cohesion;

/**
 * METRICS
 * <p>
 * TCC: 1
 * <ul>
 *     <li>NDC: 3</li>
 *     <li>NP: 3</li>
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
 *     <td>0</td>
 *   </tr>
 *   <tr>
 *     <td>LCOM3</td>
 *     <td>0</td>
 *   </tr>
 *   <tr>
 *     <td>LCOM4</td>
 *     <td>1</td>
 *   </tr>
 * </table>
 * <p>
 * Test example extracted from <a href="https://www.aivosto.com/project/help/pm-oo-cohesion.html#TCC_LCC">Aivosto</a> and
 * <a href="https://github.com/mauricioaniche/ck/tree/master/fixtures/ClassCohesion">GitHub</a>.
 * </p>
 */

class HighCohesion {
	private static int a = 10;

	public void m1() {
		a = 10;
	}

	static void m2() {
		a = 10;
	}

	void m3() {
		a = 10;
	}
}