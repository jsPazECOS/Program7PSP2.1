/**
 * Programa: Programa 7 - PSP 2
 *
 * @author Juan Sebastian Paz Prieto
 * @date 01/05/2017 Clase: Calculation Descripción: Clase que se encarga de
 * hacer el cálculo de los valores requeridos
 *
 */
package edu.uniandes.ecos.CAIS.P7PSP21.model;

import java.util.Iterator;
import java.util.LinkedList;

public class Calculation {

    private Data X, Y;
    Double XSum, YSum, XAvg, YAvg, XSquaredSum, YSquaredSum, XxY, B0, B1, Rxy, R2;
    Double Yk, Xk, significance, range, UPI, LPI;
    int N;

    /**
     *
     * @param X
     * @param Y
     * @param Xk
     */
    public Calculation(Data X, Data Y, Double Xk) {
        this.X = X;
        this.Y = Y;
        this.Xk = Xk;
    }

    /**
     * Método que permite iniciar el calculo de los valores
     */
    public void calculate() {
        this.N = this.X.getData().size();

        this.XSum = this.calculateSumatory(this.X);
        this.YSum = this.calculateSumatory(this.Y);

        this.XAvg = this.calculateAvg(this.X);
        this.YAvg = this.calculateAvg(this.Y);

        this.XSquaredSum = this.calculateSquaredSumatory(this.X);
        this.YSquaredSum = this.calculateSquaredSumatory(this.Y);

        this.XxY = this.multiplication(this.X, this.Y);

        Double a = this.XxY - (this.N * this.XAvg * this.YAvg);
        Double b = this.XSquaredSum - (this.N * this.XAvg * this.XAvg);
        this.B1 = a / b;

        this.B0 = this.YAvg - (this.B1 * this.XAvg);

        this.Rxy = this.calculateRxy();
        this.R2 = this.calculateR2();
        this.Yk = this.calculateYk();
        this.significance = this.calculateSignificance();
        this.range = this.calculateRange();
        this.UPI = this.calculateUPI();
        this.LPI = this.calculateLPI();
    }

    /**
     * Método que permite acceder al valor de B0
     *
     * @return un valor <code>Double</code> de B0
     */
    public Double getB0() {
        return B0;
    }

    /**
     * Método que permite acceder al valor de B1
     *
     * @return un valor <code>Double</code> de B1
     */
    public Double getB1() {
        return B1;
    }

    /**
     * Método que permite acceder al valor de Rxy
     *
     * @return un valor <code>Double</code> de Rxy
     */
    public Double getRxy() {
        return Rxy;
    }

    /**
     * Método que permite acceder al valor de R2
     *
     * @return un valor <code>Double</code> de R2
     */
    public Double getR2() {
        return R2;
    }

    /**
     * Método que permite acceder al valor de Yk
     *
     * @return un valor <code>Double</code> de Yk
     */
    public Double getYk() {
        return Yk;
    }

    /**
     * Método que permite acceder al valor de significance
     *
     * @return un valor <code>Double</code> de Significance
     */
    public Double getSignificance() {
        return significance;
    }

    /**
     * Método que permite acceder al valor de Range
     *
     * @return un valor <code>Double</code> de Range
     */
    public Double getRange() {
        return range;
    }

    /**
     * Método que permite acceder al valor de UPI
     *
     * @return un valor <code>Double</code> de UPI
     */
    public Double getUPI() {
        return UPI;
    }

    /**
     * Método que permite acceder al valor de LPI
     *
     * @return un valor <code>Double</code> de LPI
     */
    public Double getLPI() {
        return LPI;
    }

    /**
     * Método que permite realizar el calculo de Rxy
     *
     * @return un valor <code>Double</code> de Rxy
     */
    private Double calculateRxy() {

        Double partA = this.N * this.XxY;
        Double partB = this.XSum * this.YSum;

        Double a = partA - partB;

        Double b = (this.N * this.XSquaredSum) - (Math.pow(this.XSum, 2));
        Double c = (this.N * this.YSquaredSum) - (Math.pow(this.YSum, 2));

        Double d = Math.sqrt(b * c);

        return a / d;
    }

    /**
     * Método que permite realizar el calculo de R2
     *
     * @return un valor <code>Double</code> de R2
     */
    private Double calculateR2() {
        return Math.pow(this.getRxy(), 2);
    }

    /**
     * Método que permite realizar el calculo de Yk
     *
     * @return un valor <code>Double</code> de Yk
     */
    private Double calculateYk() {
        return this.B0 + (this.B1 * this.Xk);
    }

    /**
     * Método que permite realizar el calculo de Significance
     *
     * @return un valor <code>Double</code> de Significance
     */
    private Double calculateSignificance() {

        Double a = Math.abs(this.Rxy) * Math.sqrt(this.N - 2);
        Double b = Math.sqrt(1 - this.R2);
        Double x = a / b;

        Function fx = new Function();
        Double P = fx.calculateP(x, (this.N * 1.0 - 2));

        return 1 - (2 * P);
    }

    /**
     * Método que permite realizar el calculo de Range
     *
     * @return un valor <code>Double</code> de Range
     */
    private Double calculateRange() {
        Function fx = new Function();
        Double X = fx.calculateX(0.35, (this.N * 0.1 - 2));
        Double stdDeviation = this.calculateStdDeviation();

        Double a = X * stdDeviation;

        Double b1 = this.Xk - this.XAvg;
        b1 = Math.pow(b1, 2);

        LinkedList<Double> aux = new LinkedList<>();
        for (int i = 0; i < this.N; i++) {
            Double Xi = this.X.getData().get(i);
            Double value = Xi - this.XAvg;
            aux.add(value);
        }
        Data values = new Data(aux);

        Double b2 = this.calculateSquaredSumatory(values);

        Double b = b1 / b2;

        Double c = 1 / (this.N * 1.0);

        Double d = 1 + c + b;
        d = Math.sqrt(d);

        return a * d;
    }

    /**
     * Método que permite realizar el calculo de UPI
     *
     * @return un valor <code>Double</code> de UPI
     */
    private Double calculateUPI() {
        return this.Yk + this.range;
    }

    /**
     * Método que permite realizar el calculo de LPI
     *
     * @return un valor <code>Double</code> de LPI
     */
    private Double calculateLPI() {
        return this.Yk - this.range;
    }

    /**
     * Método que calcula la sumatoria de los datos de una serie de datos
     *
     * @param data
     * @return un valor <code>Double</code> de la sumatoria de una serie de
     * datos
     */
    private Double calculateAvg(Data data) {

        return this.calculateSumatory(data) / this.N;
    }

    /**
     * Método que calcula la sumatoria de los datos de una serie de datos
     *
     * @param data
     * @return un valor <code>Double</code> de la sumatoria de una serie de
     * datos
     */
    private Double calculateSumatory(Data data) {
        Double sumatory = 0.0;
        Iterator it = data.getData().iterator();

        while (it.hasNext()) {
            double number = (Double) it.next();
            sumatory += number;
        }

        return sumatory;
    }

    /**
     * Método que calcula la sumatoria de los datos al cuadrado de una serie de
     * datos
     *
     * @param data
     * @return un valor <code>Double</code> de la sumatoria de los datos al
     * cuadrado una serie de datos
     */
    private Double calculateSquaredSumatory(Data data) {
        Double sumatory = 0.0;
        Iterator it = data.getData().iterator();

        while (it.hasNext()) {
            double number = (Double) it.next();
            number = number * number;
            sumatory += number;
        }

        return sumatory;
    }

    /**
     * Método que calcula la sumatoria de la multiplicación entre los datos de
     * dos series de datos
     *
     * @param X
     * @param Y
     * @return un valor <code>Double</code> de la sumatoria de la multiplicación
     * entre los datos de dos series de datos
     */
    public Double multiplication(Data X, Data Y) {
        Double sumatory = 0.0;
        Iterator it = X.getData().iterator();
        int i = 0;
        while (it.hasNext()) {
            sumatory += X.getData().get(i) * Y.getData().get(i);
            i++;
            it.next();
        }

        return sumatory;
    }

    /**
     * Método que permite realizar el calculo de la desviación estándar según se
     * usa en el script
     *
     * @return un valor <code>Double</code> de la desviación estandar
     */
    private Double calculateStdDeviation() {
        LinkedList<Double> aux = new LinkedList<>();
        for (int i = 0; i < this.N; i++) {
            Double Y = this.Y.getData().get(i);
            Double X = this.X.getData().get(i);
            Double value = Y - this.B0 - (this.B1 * X);
            aux.add(value);
        }
        Data values = new Data(aux);
        Double a = 1 / (this.N * 1.0 - 2);
        Double b = this.calculateSquaredSumatory(values);

        return Math.sqrt(a * b);
    }

}
