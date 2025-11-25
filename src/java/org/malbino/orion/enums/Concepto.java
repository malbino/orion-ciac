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
public enum Concepto {
    MATRICULA("MATRICULA", "MA", 0),
    CUOTA1_SEMESTRAL("CUOTA 1", "C1", 1),
    CUOTA2_SEMESTRAL("CUOTA 2", "C2", 2),
    CUOTA3_SEMESTRAL("CUOTA 3", "C3", 3),
    CUOTA4_SEMESTRAL("CUOTA 4", "C4", 4),
    CUOTA5_SEMESTRAL("CUOTA 5", "C5", 5),
    CUOTA1_ANUAL("CUOTA 1", "C1", 1),
    CUOTA2_ANUAL("CUOTA 2", "C2", 2),
    CUOTA3_ANUAL("CUOTA 3", "C3", 3),
    CUOTA4_ANUAL("CUOTA 4", "C4", 4),
    CUOTA5_ANUAL("CUOTA 5", "C5", 5),
    CUOTA6_ANUAL("CUOTA 6", "C6", 6),
    CUOTA7_ANUAL("CUOTA 7", "C7", 7),
    CUOTA8_ANUAL("CUOTA 8", "C8", 8),
    CUOTA9_ANUAL("CUOTA 9", "C9", 9),
    CUOTA10_ANUAL("CUOTA 10", "C10", 10),
    ADMISION("ADMISIÓN", "AD", 0),;

    private String nombre;
    private String codigo;
    private Integer numero;

    private Concepto(String nombre, String abreviatura, Integer numero) {
        this.nombre = nombre;
        this.codigo = abreviatura;
        this.numero = numero;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the numero
     */
    public Integer getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
