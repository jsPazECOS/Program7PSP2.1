/**
 * Programa: Programa 7 - PSP 2
 *
 * @author Juan Sebastian Paz Prieto
 * @date 01/05/2017 Clase: Data Descripción: Clase que tiene los atributos de
 * cada archivo, nombre y datos.
*
 */
package edu.uniandes.ecos.CAIS.P7PSP21.model;

import java.util.LinkedList;

public class Data {

    private LinkedList<Double> data;

    /**
     * M�todo constructor de la clase Data
     *
     * @param name nombre del archivo
     * @param data lista de los datos
     */
    public Data(LinkedList<Double> data) {
        this.data = data;
    }
    /**
     * M�todo que permite acceder a los datos de la data
     *
     * @return un valor <code>LinkedList</code> que representa los datos
     */
    public LinkedList<Double> getData() {
        return data;
    }

}
