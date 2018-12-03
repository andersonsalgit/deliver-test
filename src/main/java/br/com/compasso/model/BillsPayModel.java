package br.com.deliver.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Data
@Entity
@Table(name = "TB_BILL_PAY")
@EntityListeners(AuditingEntityListener.class)
public class BillsPayModel {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)	
    private Long id;
	
	@NotNull @NotBlank
	@Column(nullable = false)
	private String name;

	@NotNull
	@Column(nullable = false)
	private BigDecimal originalValue;
	
	@Column
	private BigDecimal correctedValue;
	
	@NotNull
	@Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
	private Date dueDate;
	
	@NotNull
	@Column(nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
	private Date payDay;
	
	@Column
	private int delayedDays;
	
}
