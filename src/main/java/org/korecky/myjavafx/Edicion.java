package org.korecky.myjavafx;

public class Edicion {

    private Integer numero;
    private Integer ano;
    private String mes;


    public Edicion(Integer numero, Integer ano, String mes) {
        this.numero = numero;
        this.ano = ano;
        this.mes = mes;
    }


    public Integer getNumero() {
        return numero;
    }

    public Integer getAno() {
        return ano;
    }

    public String getMes() {
        return mes;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    @Override
    public String toString() {
        return numero + "," + mes + "-" +ano + " ";
                //"Edicion{" +
                //"numero=" + numero +
                //", ano=" + ano +
                //", mes='" + mes + '\'' +
                //'}';
    }
}
