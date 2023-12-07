package DAO;

import DTO.CuotaDTO;
import entidades.Cuota;

public class CuotaDAOImp implements CuotaDAO {

	@Override
	public Cuota crearCuota(CuotaDTO cuotaDTO) {
		Cuota cuota = new Cuota();
		cuota.setOrden(cuotaDTO.getOrden());
		cuota.setEstado(cuotaDTO.getEstado());
		cuota.setFechaInicio(cuotaDTO.getFechaInicio());
		cuota.setFechaVencimiento(cuotaDTO.getFechaVencimiento());
		cuota.setValorOriginal(cuotaDTO.getValorOriginal());
	    return cuota;
	}

}
