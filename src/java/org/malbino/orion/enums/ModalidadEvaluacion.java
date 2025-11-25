/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.malbino.orion.enums;

/**
 *
 * @author Martin
 */
public enum ModalidadEvaluacion {
    MODULAR_2P(1, 2, 80, 40),
    SEMESTRAL_2P(2, 2, 61, 40),
    SEMESTRAL_3P(2, 3, 61, 40),
    ANUAL_4P(3, 4, 61, 40);

    private Integer cantidadMaximaReprobaciones;
    private Integer cantidadParciales;
    private Integer notaMinimaAprobacion;
    private Integer notaMinimmaPruebaRecuperacion;

    private ModalidadEvaluacion(Integer cantidadMaximaReprobaciones, Integer cantidadParciales, Integer notaMinimaAprobacion, Integer notaMinimmaPruebaRecuperacion) {
        this.cantidadMaximaReprobaciones = cantidadMaximaReprobaciones;
        this.cantidadParciales = cantidadParciales;
        this.notaMinimaAprobacion = notaMinimaAprobacion;
        this.notaMinimmaPruebaRecuperacion = notaMinimmaPruebaRecuperacion;
    }

    @Override
    public String toString() {
        return " [" + cantidadParciales + " PARCIALES]";
    }

    public Integer getCantidadMaximaReprobaciones() {
        return cantidadMaximaReprobaciones;
    }

    public void setCantidadMaximaReprobaciones(Integer cantidadMaximaReprobaciones) {
        this.cantidadMaximaReprobaciones = cantidadMaximaReprobaciones;
    }

    public Integer getCantidadParciales() {
        return cantidadParciales;
    }

    public void setCantidadParciales(Integer cantidadParciales) {
        this.cantidadParciales = cantidadParciales;
    }

    public Integer getNotaMinimaAprobacion() {
        return notaMinimaAprobacion;
    }

    public void setNotaMinimaAprobacion(Integer notaMinimaAprobacion) {
        this.notaMinimaAprobacion = notaMinimaAprobacion;
    }

    public Integer getNotaMinimmaPruebaRecuperacion() {
        return notaMinimmaPruebaRecuperacion;
    }

    public void setNotaMinimmaPruebaRecuperacion(Integer notaMinimmaPruebaRecuperacion) {
        this.notaMinimmaPruebaRecuperacion = notaMinimmaPruebaRecuperacion;
    }

}
