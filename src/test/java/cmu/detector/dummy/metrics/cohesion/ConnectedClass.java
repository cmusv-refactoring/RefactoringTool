package cmu.detector.dummy.metrics.cohesion;

/**
 * METRICS
 * <p>
 * TCC: 1
 * <ul>
 *     <li>NDC: 4</li>
 *     <li>NP: 10</li>
 * </ul>
 * <p>
 * Another metric used for cohesion is the Lack of Cohesion:
 * <p>
 * <table>
 *   <tr>
 *     <th>LCOM Metric</th>
 *     <th>Value</th>
 *   </tr>
 *   <tr>
 *     <td>LCOM1</td>
 *     <td>6</td>
 *   </tr>
 *   <tr>
 *     <td>LCOM2</td>
 *     <td>0.6</td>
 *   </tr>
 *   <tr>
 *     <td>LCOM3</td>
 *     <td>0.75</td>
 *   </tr>
 *   <tr>
 *     <td>LCOM4</td>
 *     <td>1</td>
 *   </tr>
 * </table>
 * <p>
 * <p>
 * Test example extracted from <a href="https://www.aivosto.com/project/help/pm-oo-cohesion.html#TCC_LCC">Aivosto</a> and
 * <a href="https://github.com/mauricioaniche/ck/tree/master/fixtures/ClassCohesion">GitHub</a>.
 * </p>
 *
 */

public class ConnectedClass {
    private int x;
    private int y;

    public void A() {
        B();
    }

    public void B() {
        System.out.println(x);
    }

    public void C() {
        System.out.println(x);
        System.out.println(y);
    }

    public void D() {
        System.out.println(y);
        E();
    }

    public void E() {
        System.out.println("no field access");
    }
}
