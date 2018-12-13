package org.korecky.myjavafx;

import javafx.collections.ObservableList;

public class Revista {

    private String title;
    private String author;
    private String genre;
    private String publisher;
    //private Integer numero;
    //private Integer ano;
    //private String mes;
    private ObservableList<Edicion> edicion;


    public Revista() {
    }

    public Revista(String title, String author, String genre, String publisher, ObservableList<Edicion> edicion) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publisher = publisher;
        this.edicion = edicion;
    }

    /*
    public Revista(String title, String author, String genre, String publisher, Integer numero, Integer ano, String mes) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publisher = publisher;
        this.numero = numero;
        this.ano = ano;
        this.mes = mes;
    }
    */

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
//
//    public void setNumero(Integer numero) {
//        this.numero = numero;
//    }
//
//    public void setAno(Integer ano) {
//        this.ano = ano;
//    }
//
//    public void setMes(String mes) {
//        this.mes = mes;
//    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public String getPublisher() {
        return publisher;
    }

//    public Integer getNumero() {
//        return numero;
//    }
//
//    public Integer getAno() {
//        return ano;
//    }
//
//    public String getMes() {
//        return mes;
//    }
    public ObservableList<Edicion> getEdicion() {
        return edicion;
    }

    public void setEdicion(ObservableList<Edicion> edicion) {
        this.edicion = edicion;
    }

    @Override
    public String toString() {
        return " Title: " + title + " Author: " + author + " Genre: "+ genre + " Publisher: " + publisher + " Ediciones: " + edicion.toString() + "\n";
                //"title='" + title + '\'' +
                //", author='" + author + '\'' +
                //", genre='" + genre + '\'' +
               // ", publisher='" + publisher + '\'' ;
                //", numero=" + numero +
                //", ano=" + ano +
                //", mes='" + mes + '\'';
    }
}
