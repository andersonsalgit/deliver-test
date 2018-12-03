package br.com.compasso.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Data
@Entity
@Table(name = "TB_VOTO")
@EntityListeners(AuditingEntityListener.class)
public class VotoModel {

	@Id
	@Column(name = "voto_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)	
    private Long id;
	
	@NotNull
	@Column
	private boolean voto;
	
	@ManyToOne
    @JoinColumn(name = "pauta_id", nullable = false)
	private PautaModel pautaModel;
	
	@Column(nullable = false, updatable = false, name = "data_voto")
    @Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date dataVoto;
	
}
