package br.com.serasa.exerciciossb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	@GetMapping(path = {"/ola", "/retorna"})
	public String ola() {
		return "Olá !";
	}
}
