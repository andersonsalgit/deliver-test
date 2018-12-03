package br.com.compasso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.compasso.model.VotoModel;
import br.com.compasso.repository.VotoRepository;

@Service
public class VotoService {

	@Autowired
	VotoRepository votoRepository;

	public Iterable<VotoModel> listAll() {
		return votoRepository.findAll();
	}

	public void insert(VotoModel votoModel) {
		
		votoRepository.save(votoModel);
	}
}
