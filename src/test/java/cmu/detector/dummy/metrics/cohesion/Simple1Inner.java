package cmu.detector.dummy.metrics.cohesion;

/**
 * This class demonstrates the calculation of Tight Class Cohesion (TCC).
 * <p>
 * TCC measures the cohesion of a class by evaluating the ratio of the number of actual direct connections
 * between methods to the maximum number of possible connections.
 * </p>
 * <p>
 * For the {@code Simple1Inner}, we have the following analysis:
 * </p>
 * <ul>
 *   <li>Instance Variable (we exclude static attributes):
 *      <ul>
 *          <li>{@code private int a}</li>
 *          <li>{@code private int b}</li>
 *      </ul>
 *   <li>Instance Methods (we exclude static and private methods):
 *     <ul>
 *       <li>{@code public void m1() -> a}</li>
 *       <li>{@code public void m2() -> a}</li>
 *       <li>{@code public void m3() -> b}</li>
 *       <li>{@code public void m4()}</li>
 *       <li>{@code public void m5()}</li>
 *     </ul>
 *   </li>
 * </ul>
 * <p>
 * <p>
 * Notice that the inner class methods were ignored.
 * </p>
 * Direct connections are established through shared instance variables, or the call trees starting at A and B access
 * the same class-level variable.From these connections, we can derive the following pairs of methods that interact through the instance variable {@code a}:
 * </p>
 * <ul>
 *   <li>{@code (m1, m2) -> a} (shared variable)) </li>
 * </ul>
 * <p>
 * Therefore, the number of direct connections (NDC) is {@code 1}.
 * </p>
 * <p>
 * The maximum number of possible connections (NP) between the methods is calculated as follows (where N is the number of methods in the class excluding static methods):
 * </p>
 * <pre>
 * {@code NP = N * (N - 1) / 2 = 5 * (5 - 1) / 2 = 10}
 * </pre>
 * <p>
 * TCC is given by:
 * </p>
 * <pre>
 * {@code TCC = NDC / NP = 1 / 10 = 0.1}
 * </pre>
 * <p>
 * <p>
 * <p>
 *     The inner class {@code Complex2} has its own methods and instance variable n. However, for the TCC and LOC calculation of the
 *     outer class, we do not consider the inner class methods.
 * <p/>
 * <p>
 *  Another metric used for cohesion is the Lack of Cohesion.
 *
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

 * </p>
 */
public class Simple1Inner {
    private int a = 10;

    private int b = 10;

    public void m1() {
        a = 10;
    }

    public void m2() {
        a = 20;
    }

    public void m3() {
        b = 30;
    }

    public void m4() {
        int b = 40;
        java.util.List<String> stringList = new java.util.ArrayList<>();
        m5(b);
    }

    public void m5(int b) {
        int a = b;
    }

    /**
     * Inner class, it accesses the outer class attribute "a"
     */
    class Complex2 {
        String n = "";

        public void n1() {
            // Accessing outer class instance variable
            a = 20;
            n2("Hello world");
        }

        private void n2(String in) {
            n = in;
            System.out.println(n);
        }
    }
}
