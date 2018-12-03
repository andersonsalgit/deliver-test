package br.com.compasso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.compasso.model.VotoModel;

@Repository
public interface VotoRepository extends JpaRepository<VotoModel, Long>{};
