/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.malbino.orion.enums;

import java.util.Arrays;

/**
 *
 * @author Martin
 */
public enum Nivel {
    MODUL0_1(0, "MODULO 1", "1M", 1, Regimen.MODULAR, "PRIMERO"),
    MODUL0_2(1, "MODULO 2", "2M", 2, Regimen.MODULAR, "SEGUNDO"),
    MODUL0_3(2, "MODULO 3", "3M", 3, Regimen.MODULAR, "TERCERO"),
    MODUL0_4(3, "MODULO 4", "4M", 4, Regimen.MODULAR, "CUARTO"),
    MODUL0_5(4, "MODULO 5", "5M", 5, Regimen.MODULAR, "QUINTO"),
    MODUL0_6(5, "MODULO 6", "6M", 6, Regimen.MODULAR, "SEXTO"),
    MODUL0_7(6, "MODULO 7", "7M", 7, Regimen.MODULAR, "SÉPTIMO"),
    MODUL0_8(7, "MODULO 8", "8M", 8, Regimen.MODULAR, "OCTAVO"),
    MODUL0_9(8, "MODULO 9", "9M", 9, Regimen.MODULAR, "NOVENO"),
    MODUL0_10(9, "MODULO 10", "10M", 10, Regimen.MODULAR, "DÉCIMO"),
    MODUL0_11(10, "MODULO 11", "11M", 11, Regimen.MODULAR, "UNDÉCIMO"),
    MODUL0_12(11, "MODULO 12", "12M", 12, Regimen.MODULAR, "DUODÉCIMO"),
    MODUL0_13(12, "MODULO 13", "13M", 13, Regimen.MODULAR, "DECIMOTERCERO"),
    MODUL0_14(13, "MODULO 14", "14M", 14, Regimen.MODULAR, "DECIMOCUARTO"),
    MODUL0_15(14, "MODULO 15", "15M", 15, Regimen.MODULAR, "DECIMOQUINTO"),
    MODUL0_16(15, "MODULO 16", "16M", 16, Regimen.MODULAR, "DECIMOSEXTO"),
    MODUL0_17(16, "MODULO 17", "17M", 17, Regimen.MODULAR, "DECIMOSÉPTIMO"),
    MODUL0_18(17, "MODULO 18", "18M", 18, Regimen.MODULAR, "DECIMOCTAVO"),
    MODUL0_19(18, "MODULO 19", "19M", 19, Regimen.MODULAR, "DECIMONOVENO"),
    MODUL0_20(19, "MODULO 20", "20M", 20, Regimen.MODULAR, "VIGÉSIMO"),
    MODUL0_21(20, "MODULO 21", "21M", 21, Regimen.MODULAR, "VIGÉSIMO PRIMERO"),
    MODUL0_22(21, "MODULO 22", "22M", 22, Regimen.MODULAR, "VIGÉSIMO SEGUNDO"),
    MODUL0_23(22, "MODULO 23", "23M", 23, Regimen.MODULAR, "VIGÉSIMO TERCERO"),
    MODUL0_24(23, "MODULO 24", "24M", 24, Regimen.MODULAR, "VIGÉSIMO CUARTO"),
    PRIMER_SEMESTRE(0, "PRIMER SEMESTRE", "1S", 1, Regimen.SEMESTRAL, "PRIMERO"),
    SEGUNDO_SEMESTRE(1, "SEGUNDO SEMESTRE", "2S", 2, Regimen.SEMESTRAL, "SEGUNDO"),
    TERCER_SEMESTRE(2, "TERCER SEMESTRE", "3S", 3, Regimen.SEMESTRAL, "TERCERO"),
    CUARTO_SEMESTRE(3, "CUARTO SEMESTRE", "4S", 4, Regimen.SEMESTRAL, "CUARTO"),
    QUITO_SEMESTRE(4, "QUINTO SEMESTRE", "5S", 5, Regimen.SEMESTRAL, "QUINTO"),
    SEXTO_SEMESTRE(5, "SEXTO SEMESTRE", "6S", 6, Regimen.SEMESTRAL, "SEXTO"),
    PRIMER_AÑO(6, "PRIMER AÑO", "1A", 1, Regimen.ANUAL, "PRIMERO"),
    SEGUNDO_AÑO(7, "SEGUNDO AÑO", "2A", 2, Regimen.ANUAL, "SEGUNDO"),
    TERCER_AÑO(8, "TERCER AÑO", "3A", 3, Regimen.ANUAL, "TERCERO");

    private Integer id;
    private String nombre;
    private String abreviatura;
    private Integer nivel;
    private Regimen regimen;
    private String ordinal;

    private Nivel(Integer id, String nombre, String abreviatura, Integer nivel, Regimen regimen, String ordinal) {
        this.id = id;
        this.nombre = nombre;
        this.abreviatura = abreviatura;
        this.nivel = nivel;
        this.regimen = regimen;
        this.ordinal = ordinal;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
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
     * @return the abreviatura
     */
    public String getAbreviatura() {
        return abreviatura;
    }

    /**
     * @param abreviatura the abreviatura to set
     */
    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    /**
     * @return the nivel
     */
    public Integer getNivel() {
        return nivel;
    }

    /**
     * @param nivel the nivel to set
     */
    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    /**
     * @return the regimen
     */
    public Regimen getRegimen() {
        return regimen;
    }

    /**
     * @param regimen the regimen to set
     */
    public void setRegimen(Regimen regimen) {
        this.regimen = regimen;
    }

    /**
     * @return the ordinal
     */
    public String getOrdinal() {
        return ordinal;
    }

    /**
     * @param ordinal the ordinal to set
     */
    public void setOrdinal(String ordinal) {
        this.ordinal = ordinal;
    }

    @Override
    public String toString() {
        return nombre;
    }

    public static Nivel[] values(Regimen regimen) {
        return Arrays.stream(Nivel.values()).filter(nivel -> nivel.getRegimen().equals(regimen)).toArray(Nivel[]::new);
    }

    public static Nivel getById(Integer id) {
        for (Nivel n : values()) {
            if (n.id.equals(id)) {
                return n;
            }
        }
        return null;
    }
}
