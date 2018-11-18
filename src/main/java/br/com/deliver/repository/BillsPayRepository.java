package br.com.deliver.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.deliver.model.BillsPayModel;

@Transactional
public interface BillsPayRepository extends JpaRepository<BillsPayModel, Long>{};
