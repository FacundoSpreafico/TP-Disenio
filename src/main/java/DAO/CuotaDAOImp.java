package DAO;

import DTO.CuotaDTO;
import entidades.Cuota;

public class CuotaDAOImp implements CuotaDAO {

	@Override
	public Cuota crearCuota(CuotaDTO cuotaDTO) {
		Cuota cuota = new Cuota();
		cuota.setOrden(cuotaDTO.getOrden());
		cuota.setFechaInicio(cuotaDTO.getFechaInicio());
		cuota.setFechaVencimiento(cuotaDTO.getFechaVencimiento());
		cuota.setBonificacionPagoAdelantado(cuotaDTO.getBonificacionPagoAdelantado());
		cuota.setRecargosMora(cuotaDTO.getRecargosMora());
		cuota.setValorOriginal(cuotaDTO.getValorOriginal());
		cuota.setValorActual(cuotaDTO.getValorActual());
	
	    return cuota;
	}

}
