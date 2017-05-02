/**
 * Programa: Programa 7 - PSP 2.1
 *
 * @author Juan Sebastian Paz Prieto
 * @date 01/05/2017 Clase: Program Descripcion: Clase que lee los archivos de
 * datos de un path, para calcular los valores
 *
 */
package edu.uniandes.ecos.CAIS.P7PSP21.controller;

import edu.uniandes.ecos.CAIS.P7PSP21.model.Calculation;
import edu.uniandes.ecos.CAIS.P7PSP21.model.Data;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class Program {

    private LinkedList<Data> data;

    /**
     * Metodo que permite acceder al valor de Functions
     *
     * @return un valor <code>LinkedList</code> de las funciones.
     */
    public LinkedList<Data> getData() {
        return data;
    }

    /**
     * Metodo que lee los archivos localizados en path para instanciar objetos
     * de tipo Data
     *
     * @param path
     * @throws IOException
     */
    public void readFiles(String path) throws IOException {
        this.data = new LinkedList<>();

        File[] files = new File(path).listFiles();

        for (File file : files) {
            if (this.checkFileExist(file)) {
                BufferedReader content = this.getFileContent(file.getPath());
                LinkedList<Double> data = new LinkedList<>();
                String sCurrentLine;
                while ((sCurrentLine = content.readLine()) != null) {
                    sCurrentLine = sCurrentLine.trim();
                    if (checkContentIsValid(sCurrentLine)) {
                        data.add(Double.parseDouble(sCurrentLine));
                    } else {
                        throw new UnknownError("El contenido es invalido");
                    }
                }
                this.data.add(new Data(data));
            } else {
                throw new UnknownError("El archivo no existe");
            }

        }
    }

    /**
     * Metodo que permite obtener el contenido de un archivo
     *
     * @param path
     */
    private BufferedReader getFileContent(String path) {
        BufferedReader br = null;
        FileReader fr = null;
        try {
            fr = new FileReader(path);
            br = new BufferedReader(fr);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return br;
    }

    /**
     * Metodo que permite comprobar si el archivo existe
     *
     * @param file
     * @return un valor <code>Boolean</code> que representa si el archivo existe
     */
    public Boolean checkFileExist(File file) {
        return file.isFile();
    }

    /**
     * Metodo que permite comprobar si el contenido del archivo es valido
     *
     * @param line
     * @return un valor <code>Boolean</code> que representa si el contenido de
     * un archivo es válido
     */
    public Boolean checkContentIsValid(String line) {
        try {
            double d = Double.parseDouble(line);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    /**
     * Método que permite crear los casos de prueba apartir de los datos de los
     * archivos
     *
     * @param x
     * @param y
     * @param Xk
     * @return calculation
     */
    public Calculation createCase(int x, int y, Double Xk) {
        Data X = this.data.get(x);
        Data Y = this.data.get(y);

        if (!this.checkContentIsValid(Xk + "")) {
            throw new UnknownError("Xk es inválido");
        }
        Calculation calculation = new Calculation(X, Y, Xk);
        calculation.calculate();

        return calculation;
    }
}
