package com.hotel.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "hospede")
public class HospedeEntity implements Serializable {

	private static final long serialVersionUID = -659935521768528316L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotNull
	@Column(name = "nome")
	private String nome;

	@NotNull
	@Column(name = "documento")
	private String documento;

	@NotNull
	@Column(name = "telefone")
	private String telefone;

}
