package br.com.compasso.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.compasso.model.PautaModel;
import br.com.compasso.model.PautaResponse;
import br.com.compasso.service.PautaService;

@RestController
public class PautaController {

	@Autowired
	PautaService pautaService;

	@PostMapping("/pauta")
	public HttpStatus insert(@Valid @RequestBody PautaModel pautaModel) {
		pautaService.insert(pautaModel);
		return HttpStatus.OK;
	}

	@GetMapping("/pauta")
	public List<PautaModel> getALL() {
		return pautaService.listAll();
	}
	
	@GetMapping("/pauta/{id}")
	public PautaResponse getFinalResult(@PathVariable(value = "id") Long pautaID) {
		return pautaService.listFinalResult(pautaID);
	}
}
