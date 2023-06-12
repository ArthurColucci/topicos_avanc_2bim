package com.reges.spring.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import com.reges.spring.modelos.livroAluga;
import com.reges.spring.rdn.livroAlugaRdn;

public class livroAlugaController {
    @GetMapping("/livroAluga")
    public List<livroAluga> Get() {

        livroAlugaRdn rdn = new livroAlugaRdn();
        return rdn.obterTodos();
    }

    @GetMapping("/livroAluga/{id}")
    public livroAluga GetById(@PathVariable("id") int id) {

        livroAlugaRdn rdn = new livroAlugaRdn();
        return rdn.obterPorId(id);
    }

    @PostMapping("/livroAluga")
    public int Post(@RequestBody livroAluga LivroAluga) {
        livroAlugaRdn rdn = new livroAlugaRdn();
        return rdn.inserirlivroAluga(LivroAluga);

    }

    @PutMapping("/livroAluga/{id}")
    public int Put(@PathVariable("id") int id, @RequestBody livroAluga LivroAluga) {
        livroAlugaRdn rdn = new livroAlugaRdn();
        int retorno = 0;

        if (rdn.obterPorId(id).getId() > 0) {
            retorno = rdn.alterarlivroAluga(LivroAluga);

        } else {

            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluguel não encontrado");
        }
        return retorno;
    }

    @DeleteMapping("/livroAluga/{id}")
    public int Delete(@PathVariable("id") int id) {
        
        livroAlugaRdn rdn = new livroAlugaRdn();
        int retorno = 0;

        if (rdn.obterPorId(id).getId() > 0) {
            retorno = rdn.deletarlivroAluga(id);

        } else {

            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluguel não encontrado");
        }
        return retorno;
    }
    
}
