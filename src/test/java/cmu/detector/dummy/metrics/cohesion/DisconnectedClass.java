package cmu.detector.dummy.metrics.cohesion;

/**
 * METRICS
 * <p>
 * TCC: 0.2
 * <ul>
 *     <li>NDC: 2</li>
 *     <li>NP: 10</li>
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
