package com.reges.spring.modelos;

public class livroAluga extends livro {
    private String cartaoFidelidade;
    

    public livroAluga(int id, String titulo, String isbn, 
                String autor, String genero, String nPaginas, String ano,
                 String cartaoFidelidade) {

        super(id, titulo, isbn, autor,genero,nPaginas, ano);
        this.cartaoFidelidade = cartaoFidelidade;
        
    }

   
    

    public String getCartaoFidelidade() {
        return cartaoFidelidade;
    }

    public void setCartaoFidelidade(String cartaoFidelidade) {
        this.cartaoFidelidade = cartaoFidelidade;
    }
    
}
