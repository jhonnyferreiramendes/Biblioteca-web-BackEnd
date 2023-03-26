package edu.com.fafic.ppi.bibliotecaWeb.enums;

public enum Periodo {

    PRIMEIRO("1°"),
    SEGUNDO("2°"),
    TERCEIRO("3°"),
    QUARTO("4°"),
    QUINTO("5°"),
    SEXTO("6°"),
    SETIMO("7°"),
    OITAVO("8°"),
    NONO("9°"),
    DECIMO("10°");

    private String periodo;

    Periodo(String periodo){
        this.periodo = periodo;
    }
}
