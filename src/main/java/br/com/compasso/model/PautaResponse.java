package br.com.compasso.model;

import java.util.Date;

import lombok.Data;

@Data
public class PautaResponse {

	private String titulo;
	private String assunto;
	private long votoSim;
	private long votoNao;
	private Date dataCriacao;
	
}
