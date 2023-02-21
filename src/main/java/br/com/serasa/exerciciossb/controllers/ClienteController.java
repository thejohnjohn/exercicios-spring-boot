package br.com.serasa.exerciciossb.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(path = "/clients")
public class ClienteController {
	@GetMapping(path = "/{id}/{secondId}")
	public String insert(@PathVariable("id") int id,
						 @PathVariable("secondId") int secondId) {
		return String.format("Your First ID is %d and Second ID is %d", id, secondId);
	}
}
