package com.reges.spring.modelos;

public class livro {
    protected int id;
    protected String titulo;    
    protected String isbn;    
    protected String autor;
    protected String genero;
    protected String nPaginas;
    protected String ano;

    public livro(int id, String titulo,  String isbn, 
            String autor, String genero, String nPaginas, String ano)
    {
        this.id = id;
        this.titulo = titulo;        
        this.isbn = isbn;
        this.autor = autor;
        this.genero = genero;
        this.nPaginas = nPaginas;
        this.ano = ano;
               
    }    
    
     public int getId() {
        return id;
    }
    
    public String geTItulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    } 

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNPaginas() {
        return nPaginas;
    }

    public void setNPaginas(String nPaginas) {
        this.nPaginas = nPaginas;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }
}
