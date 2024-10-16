package cmu.detector.dummy.metrics.cohesion;

/**
 * This class demonstrates the calculation of Tight Class Cohesion (TCC).
 * <p>
 * TCC measures the cohesion of a class by evaluating the ratio of the number of actual direct connections
 * between methods to the maximum number of possible connections.
 * </p>
 * <p>
 * For the {@code DisconnectedClass}, we have the following analysis:
 * </p>
 * <ul>
 *    <li>Instance Variables (we exclude static attributes):
 *      <ul>
 *          <li>{@code private int x}</li>
 *          <li>{@code private int y}</li>
 *      </ul>
 *   <li>Instance Methods (we exclude static and private methods):
 *     <ul>
 *       <li>{@code public void A()}</li>
 *       <li>{@code public void B() -> x}</li>
 *       <li>{@code public void C() -> y}</li>
 *       <li>{@code public void D() -> y}</li>
 *       <li>{@code public void E()}</li>
 *     </ul>
 *   </li>
 * </ul>
 * <p>
 * Direct connections are established through shared instance variables, or the call trees starting at A and B access
 * the same class-level variable. From these connections, we can derive the following pairs of methods that interact through the instance variables {@code x, y}:
 * </p>
 * <ul>
 *   <li>{@code (A, B) -> x} (call tree) </li>
 *   <li>{@code (C, D) -> y} (shared variable)</li>
 * </ul>
 * <p>
 * Therefore, the number of direct connections (NDC) is {@code 2}.
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
 * {@code TCC = NDC / NP = 2 / 10 = 0.2}
 * </pre>
 * <p>
 * When TCC<1, all existing connections are direct (even though not all methods are connected).
 * </p>
 * <p>
 * Another metric used for cohesion is the Lack of Cohesion:
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
 *     <td>2</td>
 *   </tr>
 * </table>
 * <p>
 * <p>
 * Test example extracted from <a href="https://www.aivosto.com/project/help/pm-oo-cohesion.html#TCC_LCC">Aivosto</a> and
 * <a href="https://github.com/mauricioaniche/ck/tree/master/fixtures/ClassCohesion">GitHub</a>.
 * </p>
 *
 *
 */

public class DisconnectedClass {
    private int x;
    private int y;

    public void A() {
        B();
    }

    public void B() {
        System.out.println(x);
    }

    public void C() {
        System.out.println(y);

        // C is not connected to E
        ConnectedClass test = new ConnectedClass();
        test.B();
    }

    public void D() {
        System.out.println(y);
        E();
    }

    public void E() {
        System.out.println("no field access");

        // C is not connected to E
        ConnectedClass test = new ConnectedClass();
        test.B();
    }
}
