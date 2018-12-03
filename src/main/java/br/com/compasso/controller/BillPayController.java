package br.com.deliver.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.deliver.model.BillsPayModel;
import br.com.deliver.service.BillsPayService;

@RestController
@RequestMapping("/bills")
public class BillPayController {

	@Autowired
	BillsPayService payService;

	@GetMapping("/pay")
	public Iterable<BillsPayModel> getALL() {
		return payService.listAll();
	}

	@PostMapping("/pay")
	public HttpStatus insert(@Valid @RequestBody BillsPayModel billsPayModel) {
		payService.insert(billsPayModel);
		return HttpStatus.OK;
	}

}
