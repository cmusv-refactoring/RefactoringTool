package cmu.detector.dummy.metrics.cohesion;

/**
 * This class demonstrates the calculation of Tight Class Cohesion (TCC).
 * <p>
 * TCC measures the cohesion of a class by evaluating the ratio of the number of actual direct connections
 * between methods to the maximum number of possible connections.
 * </p>
 * <p>
 * For the class {@code Simple1}, we have the following analysis:
 * </p>
 * <ul>
 *   <li>Instance Variables:
 *     <ul>
 *       <li>{@code private int a}</li>
 *       <li>{@code private int b}</li>
 *     </ul>
 *   </li>
 *   <li>Public Methods:
 *     <ul>
 *       <li>{@code public void m1()}</li>
 *       <li>{@code public void m2()}</li>
 *       <li>{@code public void m3()}</li>
 *       <li>{@code public void m4()}</li>
 *       <li>{@code public void m5(int b)}</li>
 *       <li>{@code public void n1()} (in {@code Complex2})</li>
 *     </ul>
 *   </li>
 * </ul>
 * <p>
 * Direct connections are established through shared instance variables. In this class, the instance variables {@code a} and {@code b}
 * are accessed by the following methods:
 * </p>
 * <ul>
 *   <li>{@code m1}: Accesses instance variable {@code a}.</li>
 *   <li>{@code m2}: Accesses instance variable {@code a}.</li>
 *   <li>{@code m3}: Accesses instance variable {@code b}.</li>
 *   <li>{@code m4}: Does not access any instance variables directly.</li>
 *   <li>{@code m5}: Does not access any instance variables directly.</li>
 * </ul>
 * <p>
 * Notice that the inner class methods were not considered  because they don't access any outer class variable.
 * From these connections, we can derive the following pairs of methods that interact through the instance variables:
 * </p>
 * <ul>
 *   <li>({@code m1}, {@code m2}) through {@code a}</li>
 * </ul>
 * <p>
 * Therefore, the number of direct connections (NDC) is 1.
 * </p>
 * <p>
 * The maximum number of possible connections (NP) between the methods is calculated as follows:
 * </p>
 * <pre>
 * NP = N * (N - 1) / 2
 * </pre>
 * <p>
 * Where {@code N} is the number of public methods in the class. Here, {@code N = 5} (m1, m2, m3, m4, m5).
 * </p>
 * <pre>
 * NP = 5 * (5 - 1) / 2 = 10
 * </pre>
 * <p>
 * TCC is given by:
 * </p>
 * <pre>
 * TCC = NDC / NP = 1 / 10 = 0.1
 * </pre>
 * <p>
 * This indicates that the class has a TCC value of 0.1, meaning it has low cohesion, as there are very few direct
 * connections between the methods based on shared instance variables.
 * </p>
 * <p>
 *     The inner class Complex2 has its own methods and instance variable n. However, for the TCC calculation of the
 *     outer class Simple1, we do not consider the inner class methods and fields unless they interact with the outer
 *     class's instance variables. In this case, they do not.
 * <p/>
 * <p>
 *  Another metric used for cohesion is the Lack of Cohesion. The inner class Complex2 has its own methods and instance
 *  variable n. However, for the LCOM calculation of the outer class Simple1, we do not consider the inner class methods
 *  and fields.
 * <table>
 *   <tr>
 *     <th>LCOM Metric</th>
 *     <th>Value</th>
 *   </tr>
 *   <tr>
 *     <td>LCOM1</td>
 *     <td>8</td>
 *   </tr>
 *   <tr>
 *     <td>LCOM2</td>
 *     <td>0.7</td>
 *   </tr>
 *   <tr>
 *     <td>LCOM3</td>
 *     <td>0.875</td>
 *   </tr>
 *   <tr>
 *     <td>LCOM4</td>
 *     <td>3</td>
 *   </tr>
 * </table>
 * <p>
 *  <p>
 * Test example adapted from <a href="https://www.aivosto.com/project/help/pm-oo-cohesion.html#TCC_LCC">Aivosto</a> and
 * <a href="https://github.com/mauricioaniche/ck/tree/master/fixtures/ClassCohesion">GitHub</a>.
 * </p>
 */
class Simple1 {
	private int a = 10;

	private int b = 10;

	public void m1() {
		a = 10;
	}

	public void m2() {
		a = 10;
	}

	public void m3() {
		b = 10;
	}

	public void m4() {
		int b = 10;

		java.util.List<String> stringList = new java.util.ArrayList<>();
		m5(b);
	}

	public void m5(int b) {
		int a = b;
	}

	/**
	 * Inner class, it has no access to outer class attributes
	 */
	class Complex2 {
		String n = "";

		public void n1() {
			n2("Hello world");
		}

		private void n2(String in) {
			n = in;
			System.out.println(n);
		}
	}
}