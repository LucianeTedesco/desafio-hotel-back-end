package com.hotel.previsao;

import java.util.Date;

import com.hotel.entity.CheckinEntity;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class Diaria {

	private static Double DIARIA_DURANTE_SEMANA = 120D;
	private static Double DIARIA_FINAL_SEMANA = 150D;
	private static Double CARRO_DURANTE_SEMANA = 15D;
	private static Double CARRO_FINAL_SEMANA = 20D;

	public static Double getValor(CheckinEntity check) {
		return getValor(check.getDataEntrada(), check.getDataSaida(), check.getAdicionalVeiculo());
	}

	public static Double getValor(Date dataEntrada, Date dataSaida, boolean veiculo) {
		Double valorTotal = 0D;
		LocalDateTime auxDataSaida = toDateTime(dataSaida);
		LocalDateTime auxDataEntrada = toDateTime(dataEntrada);
		if ((auxDataSaida.getHour() * 60 + auxDataSaida.getMinute()) / 60 >= 16.5) {
			auxDataSaida = auxDataSaida.plusDays(1);
		}

		while (auxDataSaida.toLocalDate().isAfter(auxDataEntrada.toLocalDate())) {
			valorTotal += calcularDiaria(auxDataEntrada, veiculo);
			auxDataEntrada = auxDataEntrada.plusDays(1);
		}
		return valorTotal;
	}

	private static Double calcularDiaria(LocalDateTime dia, boolean veiculo) {
		Double valor = 0D;
		if (dia.getDayOfWeek().getValue() != 5 && (dia.getDayOfWeek().getValue() != 6)) {
			valor += DIARIA_DURANTE_SEMANA;
			if (veiculo) {
				valor += CARRO_DURANTE_SEMANA;
			}
		} else {
			valor += DIARIA_FINAL_SEMANA;
			if (veiculo) {
				valor += CARRO_FINAL_SEMANA;
			}
		}
		return valor;
	}

	private static LocalDateTime toDateTime(Date date) {
		return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
	}

}
