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
public enum Periodo {
    I("I", 1),
    II("II", 2),
    III("III", 3),
    IV("IV", 4),
    V("V", 5),
    VI("VI", 6),
    VII("VII", 7),
    VIII("VIII", 8),
    IX("IX", 9),
    X("X", 10),
    XI("XI", 11),
    XII("XII", 12);

    private String periodoRomano;
    private Integer periodoEntero;

    private Periodo(String periodoRomano, Integer periodoEntero) {
        this.periodoRomano = periodoRomano;
        this.periodoEntero = periodoEntero;
    }

    /**
     * @return the periodoRomano
     */
    public String getPeriodoRomano() {
        return periodoRomano;
    }

    /**
     * @param periodoRomano the periodoRomano to set
     */
    public void setPeriodoRomano(String periodoRomano) {
        this.periodoRomano = periodoRomano;
    }

    /**
     * @return the periodoEntero
     */
    public Integer getPeriodoEntero() {
        return periodoEntero;
    }

    /**
     * @param periodoEntero the periodoEntero to set
     */
    public void setPeriodoEntero(Integer periodoEntero) {
        this.periodoEntero = periodoEntero;
    }

    @Override
    public String toString() {
        return periodoRomano;
    }

}
