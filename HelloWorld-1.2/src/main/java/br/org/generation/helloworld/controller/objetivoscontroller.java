package br.org.generation.helloworld.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/objetivos")
public class objetivoscontroller {
	
		@GetMapping
			public String objetivos() {
				return "Espero dominar o SpringBoot e todas as funções para desenvolver um CRUD com o mesmo.";
			}
	}