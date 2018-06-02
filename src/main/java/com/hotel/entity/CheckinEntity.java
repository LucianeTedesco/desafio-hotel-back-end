package com.hotel.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
@Table(name = "checkin")
public class CheckinEntity implements Serializable {

	private static final long serialVersionUID = 7535024457035000853L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "hospede_id")
	private HospedeEntity hospede;

	@NotNull
	@Column(name = "data_entrada")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataEntrada;

	@NotNull
	@Column(name = "data_saida")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataSaida;

	@NotNull
	@Column(name = "adicional_veiculo")
	private Boolean adicionalVeiculo;

}
