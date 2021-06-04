package com.integracion.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="Libro")
public class Libro {

    @Id // este es el id de mi libro
    @Column(name ="id") //columna en la que se va a guardar el id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //para que id sea incrementable
    private Long id;
    @Column(name = "titulo",nullable = false, length = 50)
    private String titulo;
    @Column(name = "autor",nullable = false, length = 50)
    private String autor;
    @Column(name = "categoria",nullable = false, length = 30)
    private String categoria;
    @Column(name = "idioma",nullable = false, length = 30)
    private String idioma;
    @Column(name = "paginas",nullable = false, length = 4)
    private int paginas;
    @Column(name = "status",nullable = false, length = 20)
    private String estatus;
    
    public Long getId() {
        return id;
    }
    public String getEstatus() {
        return estatus;
    }
    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
    public int getPaginas() {
        return paginas;
    }
    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }
    public String getIdioma() {
        return idioma;
    }
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
}
