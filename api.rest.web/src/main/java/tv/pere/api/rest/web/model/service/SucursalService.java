package tv.pere.api.rest.web.model.service;

import java.util.List;

import tv.pere.api.rest.web.model.dto.SucursalDTO;

public interface SucursalService {
	
	SucursalDTO addSucursal(SucursalDTO dto);
	SucursalDTO updateSucursal(SucursalDTO dto);
	void deleteSucursalById(int id);
	SucursalDTO getSucursalById(int id);
	List<SucursalDTO> getAllSucursal();

}