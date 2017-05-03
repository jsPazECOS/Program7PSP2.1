package edu.uniandes.ecos.CAIS.P7PSP21;

import edu.uniandes.ecos.CAIS.P7PSP21.controller.Program;
import edu.uniandes.ecos.CAIS.P7PSP21.model.Calculation;
import edu.uniandes.ecos.CAIS.P7PSP21.model.Function;
import edu.uniandes.ecos.CAIS.P7PSP21.model.Gamma;
import edu.uniandes.ecos.CAIS.P7PSP21.model.TDistribution;

import java.io.File;
import java.io.IOException;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest
        extends TestCase {

    private Program program7;

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) throws IOException {
        super(testName);
        this.program7 = new Program();
        String path = System.getProperty("user.dir");
        path += "/src/resources/files";
        this.program7.readFiles(path);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    public void testCaseOne() {
        Calculation caseOne = program7.createCase(2, 0, 386.0);
        assertEquals("Rxy debe ser 0.9545", 0.9545, caseOne.getRxy(), 0.01);
        assertEquals("R2 debe ser 0.9111", 0.9111, caseOne.getR2(), 0.01);
        assertEquals("Significance debe ser 1.77517E-05", 1.77517E-05, caseOne.getSignificance(), 0.01);
        assertEquals("B0 debe ser -22.55", -22.55, caseOne.getB0(), 0.01);
        assertEquals("B1 debe ser 1.7279", 1.7279, caseOne.getB1(), 0.01);
        assertEquals("Yk debe ser 644.429", 644.429, caseOne.getYk(), 0.01);
        assertEquals("Range debe ser 230.0017197", 230.0017197, caseOne.getRange(), 0.01);
        assertEquals("UPI debe ser 874.4311035", 874.4311035, caseOne.getUPI(), 0.01);
        assertEquals("LPI debe ser 414.427664", 414.427664, caseOne.getLPI(), 0.01);
    }

    public void testCaseTwo() {
        Calculation caseTwo = this.program7.createCase(2, 1, 386.0);
        assertEquals("Rxy debe ser 0.933306898", 0.933306898, caseTwo.getRxy(), 0.01);
        assertEquals("R2 debe ser 0.871061766", 0.871061766, caseTwo.getR2(), 0.01);
        assertEquals("Significance debe ser 7.98203E-05", 7.98203E-05, caseTwo.getSignificance(), 0.01);
        assertEquals("B0 debe ser -4.038881575", -4.038881575, caseTwo.getB0(), 0.01);
        assertEquals("B1 debe ser 0.16812665", 0.16812665, caseTwo.getB1(), 0.01);
        assertEquals("Yk debe ser 60.85800528", 60.85800528, caseTwo.getYk(), 0.01);
        assertEquals("Range debe ser 27.55764748", 27.55764748, caseTwo.getRange(), 0.01);
        assertEquals("UPI debe ser 88.41565276", 88.41565276, caseTwo.getUPI(), 0.01);
        assertEquals("LPI debe ser 33.3003578", 33.3003578, caseTwo.getLPI(), 0.01);

    }
/*
    public void testCaseThree() {
        Calculation caseThree = this.program7.createCase(6, 4, 110.0);
    }

    public void testCaseFour() {
        Calculation caseFour = this.program7.createCase(6, 5, 110.0);
    }
*/
    public void testContentIsValid() {

        this.program7 = new Program();

        assertTrue(this.program7.checkContentIsValid("4"));
        assertTrue(this.program7.checkContentIsValid("0.4"));
        assertTrue(this.program7.checkContentIsValid("5.2"));
        assertFalse(this.program7.checkContentIsValid("a"));

    }

    public void testFileExist() {
        Program program5 = new Program();
        String path = System.getProperty("user.dir");
        path += "/src/resources/files";
        File file = new File(path + "/ZEstimatedProxySize.txt");
        assertTrue(program5.checkFileExist(file));
        File file2 = new File(path + "/TestCases2");
        assertFalse(program5.checkFileExist(file2));
    }

    public void testCalculateP() {
        Function function = new Function();
        function.calculateP(1.1, 9.0);

        assertEquals("P debe ser 0.35005864", 0.35005864, function.getP(), 0.00001);
    }
    
    public void testCalculateGamma() {
        Gamma gamma = new Gamma();
        assertEquals("El valor de la funcion Gamma de 5 debe ser 24 ", 24, gamma.gamma(5), 0.00001);
        assertEquals("El valor de la funcion Gamma de 9/2 debe ser 11.63173 ", 11.63173, gamma.gamma(4.5), 0.00001);
    }

    public void testCalculateDistribution() {
        TDistribution distribution = new TDistribution();
        assertEquals("El valor de la funcion de Distribucion T debe ser 0.388035", 0.388035, distribution.calculateDistribution(9, 0), 0.00001);
    }
}
