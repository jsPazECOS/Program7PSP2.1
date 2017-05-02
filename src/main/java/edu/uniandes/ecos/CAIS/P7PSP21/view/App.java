/**
 * Programa: Programa 7 - PSP 2.1
 *
 * @author Juan Sebastian Paz Prieto
 * @date 01/05/2017 Clase: App Descripcion: Clase que inicia el programa
 *
 */
package edu.uniandes.ecos.CAIS.P7PSP21.view;

import edu.uniandes.ecos.CAIS.P7PSP21.controller.Program;
import edu.uniandes.ecos.CAIS.P7PSP21.model.Calculation;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static spark.Spark.*;
import static spark.SparkBase.port;
import static spark.SparkBase.staticFileLocation;

public class App {

    public static void main(String[] args) {

        try {
            Program program7 = new Program();
            String path = System.getProperty("user.dir");
            path += "/src/resources/files";
            program7.readFiles(path);

            System.out.println("Test 1");
            Calculation caseOne = program7.createCase(2, 0, 386.0);
            System.out.println("Rxy " + caseOne.getRxy());
            System.out.println("R2 " + caseOne.getR2());
            System.out.println("Significance " + caseOne.getSignificance());
            System.out.println("B0 " + caseOne.getB0());
            System.out.println("B1 " + caseOne.getB1());
            System.out.println("Yk " + caseOne.getYk());
            System.out.println("Range " + caseOne.getRange());
            System.out.println("UPI " + caseOne.getUPI());
            System.out.println("LPI " + caseOne.getLPI());

            System.out.println("Test 2");
            Calculation caseTwo = program7.createCase(2, 1, 386.0);
            System.out.println("Rxy " + caseTwo.getRxy());
            System.out.println("R2 " + caseTwo.getR2());
            System.out.println("Significance " + caseTwo.getSignificance());
            System.out.println("B0 " + caseTwo.getB0());
            System.out.println("B1 " + caseTwo.getB1());
            System.out.println("Yk " + caseTwo.getYk());
            System.out.println("Range " + caseTwo.getRange());
            System.out.println("UPI " + caseTwo.getUPI());
            System.out.println("LPI " + caseTwo.getLPI());

            System.out.println("Test 3");
            Calculation caseThree = program7.createCase(6, 4, 110.0);
            System.out.println("Rxy " + caseThree.getRxy());
            System.out.println("R2 " + caseThree.getR2());
            System.out.println("Significance " + caseThree.getSignificance());
            System.out.println("B0 " + caseThree.getB0());
            System.out.println("B1 " + caseThree.getB1());
            System.out.println("Yk " + caseThree.getYk());
            System.out.println("Range " + caseThree.getRange());
            System.out.println("UPI " + caseThree.getUPI());
            System.out.println("LPI " + caseThree.getLPI());

            System.out.println("Test 4");
            Calculation caseFour = program7.createCase(6, 5, 110.0);
            System.out.println("Rxy " + caseFour.getRxy());
            System.out.println("R2 " + caseFour.getR2());
            System.out.println("Significance " + caseFour.getSignificance());
            System.out.println("B0 " + caseFour.getB0());
            System.out.println("B1 " + caseFour.getB1());
            System.out.println("Yk " + caseFour.getYk());
            System.out.println("Range " + caseFour.getRange());
            System.out.println("UPI " + caseFour.getUPI());
            System.out.println("LPI " + caseFour.getLPI());
/*
            port(Integer.valueOf(System.getenv("PORT")));
            get("/", (req, res) -> {
                String response = "";
                response += "<br>Caso Uno";
                response += "<br>Rxy: " + caseOne.getRxy();
                response += "<br>R2: " + caseOne.getR2();
                response += "<br>Significance: " + caseOne.getSignificance();
                response += "<br>B0: " + caseOne.getB0();
                response += "<br>B1: " + caseOne.getB1();
                response += "<br>Yk: " + caseOne.getYk();
                response += "<br>Range: " + caseOne.getRange();
                response += "<br>UPI: " + caseOne.getUPI();
                response += "<br>LPI: " + caseOne.getLPI();

                response += "<br>Caso Dos";
                response += "<br>Rxy: " + caseTwo.getRxy();
                response += "<br>R2: " + caseTwo.getR2();
                response += "<br>Significance: " + caseTwo.getSignificance();
                response += "<br>B0: " + caseTwo.getB0();
                response += "<br>B1: " + caseTwo.getB1();
                response += "<br>Yk: " + caseTwo.getYk();
                response += "<br>Range: " + caseTwo.getRange();
                response += "<br>UPI: " + caseTwo.getUPI();
                response += "<br>LPI: " + caseTwo.getLPI();

                response += "<br>Caso Tres";
                response += "<br>Rxy: " + caseThree.getRxy();
                response += "<br>R2: " + caseThree.getR2();
                response += "<br>Significance: " + caseThree.getSignificance();
                response += "<br>B0: " + caseThree.getB0();
                response += "<br>B1: " + caseThree.getB1();
                response += "<br>Yk: " + caseThree.getYk();
                response += "<br>Range: " + caseThree.getRange();
                response += "<br>UPI: " + caseThree.getUPI();
                response += "<br>LPI: " + caseThree.getLPI();

                response += "<br>Caso Cuatro";
                response += "<br>Rxy: " + caseFour.getRxy();
                response += "<br>R2: " + caseFour.getR2();
                response += "<br>Significance: " + caseFour.getSignificance();
                response += "<br>B0: " + caseFour.getB0();
                response += "<br>B1: " + caseFour.getB1();
                response += "<br>Yk: " + caseFour.getYk();
                response += "<br>Range: " + caseFour.getRange();
                response += "<br>UPI: " + caseFour.getUPI();
                response += "<br>LPI: " + caseFour.getLPI();

                return response;
            });*/

        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
