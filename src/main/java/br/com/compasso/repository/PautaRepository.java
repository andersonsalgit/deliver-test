package br.com.compasso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.compasso.model.PautaModel;

@Repository
public interface PautaRepository extends JpaRepository<PautaModel, Long>{};
