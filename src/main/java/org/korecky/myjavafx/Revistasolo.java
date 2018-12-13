package org.korecky.myjavafx;

public class Revistasolo {

    private String title;
    private String author;
    private String genre;
    private String publisher;
    private Integer numero;
    private Integer ano;
    private String mes;

    public Revistasolo(String title, String author, String genre, String publisher, Integer numero, Integer ano, String mes) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publisher = publisher;
        this.numero = numero;
        this.ano = ano;
        this.mes = mes;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

}
