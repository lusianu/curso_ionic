package com.luciano.projeto.spring;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.luciano.projeto.spring.domain.Categoria;
import com.luciano.projeto.spring.domain.Produto;
import com.luciano.projeto.spring.repositories.CategoriaRepository;
import com.luciano.projeto.spring.repositories.ProdutoRepository;

@SpringBootApplication
public class ProjetoSpringApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProjetoSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Carro");
		Categoria cat2 = new Categoria(null, "Moto");
		
		Produto p1 = new Produto(null, "Civic", 45000.00);
		Produto p2 = new Produto(null, "Jetta", 45000.00);
		Produto p3 = new Produto(null, "I30", 35000.00);
		Produto p4 = new Produto(null, "XJ6", 20000.00);
		Produto p5 = new Produto(null, "XT600", 20000.00);
		Produto p6 = new Produto(null, "Misto", 20000.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3, p6));
		cat2.getProdutos().addAll(Arrays.asList(p4,p5,p6));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		p4.getCategorias().addAll(Arrays.asList(cat2));
		p5.getCategorias().addAll(Arrays.asList(cat2));
		p5.getCategorias().addAll(Arrays.asList(cat2, cat1));
		
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6));
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
	}
}
