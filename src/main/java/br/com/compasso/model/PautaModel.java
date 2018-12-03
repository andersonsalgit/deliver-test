package br.com.compasso.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "TB_PAUTA")
@EntityListeners(AuditingEntityListener.class)
public class PautaModel {

	@Id
	@Column(name = "pauta_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@JsonIgnore
	@OneToMany(mappedBy = "pautaModel", cascade = CascadeType.ALL)
	private List<VotoModel> votos;
	
	@NotNull @NotBlank
	@Column(nullable = false)
	private String titulo;

	@NotNull @NotBlank
	@Column(nullable = false)
	private String assunto;
	
	@Column(nullable = false, updatable = false, name = "data_criacao")
    @Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date dataCriacao;
	
}
