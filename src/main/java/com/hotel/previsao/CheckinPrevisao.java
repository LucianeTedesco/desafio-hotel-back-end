package com.hotel.previsao;

import com.hotel.entity.CheckinEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckinPrevisao {

	private CheckinEntity checkin;
	private Double valorGasto;

}
