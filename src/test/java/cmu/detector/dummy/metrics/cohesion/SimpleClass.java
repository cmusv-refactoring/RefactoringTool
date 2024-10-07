package cmu.detector.dummy.metrics.cohesion;

/**
 * METRICS
 * <p>
 * TCC: 0.4
 * <ul>
 *     <li>NDC = 4</li>
 *     <li>NP = 10</li>
 * </ul>
 * Another metric used for cohesion is the Lack of Cohesion:
 * <table>
 *   <tr>
 *     <th>LCOM Metric</th>
 *     <th>Value</th>
 *   </tr>
 *   <tr>
 *     <td>LCOM1</td>
 *     <td>2</td>
 *   </tr>
 *   <tr>
 *     <td>LCOM2</td>
 *     <td>0.5</td>
 *   </tr>
 *   <tr>
 *     <td>LCOM3</td>
 *     <td>0.625</td>
 *   </tr>
 *   <tr>
 *     <td>LCOM4</td>
 *     <td>1</td>
 *   </tr>
 * </table>
 * <p>
 * <p>
 *  <p>
 * Test example adapted from <a href="https://www.aivosto.com/project/help/pm-oo-cohesion.html#TCC_LCC">Aivosto</a> and
 * <a href="https://github.com/mauricioaniche/ck/tree/master/fixtures/ClassCohesion">GitHub</a>.
 * </p>
 */
class SimpleClass {
	private int a = 10;

	private int b = 10;

	public void m1() {
		a = 10;
	}

	public void m2() {
		a = 10;
	}

	public void m3() {
		a = 10;
		b = 10;
	}

	public void m4() {
		b= 10;
		m5();
	}

	public void m5() {
		int a = 10;
	}
}