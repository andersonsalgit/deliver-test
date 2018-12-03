package br.com.compasso.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.compasso.model.VotoModel;
import br.com.compasso.service.VotoService;

@RestController
public class VotoController {

	@Autowired
	VotoService votoService;

	@GetMapping("/voto")
	public Iterable<VotoModel> getALL() {
		return votoService.listAll();
	}

	@PostMapping("/voto")
	public HttpStatus insert(@Valid @RequestBody VotoModel votoModel) {
		votoService.insert(votoModel);
		return HttpStatus.OK;
	}

}
