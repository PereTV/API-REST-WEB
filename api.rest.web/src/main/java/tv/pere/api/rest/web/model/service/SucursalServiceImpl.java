package tv.pere.api.rest.web.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tv.pere.api.rest.web.model.domain.Sucursal;
import tv.pere.api.rest.web.model.dto.SucursalDTO;
import tv.pere.api.rest.web.model.repository.SucursalRepository;



@Service
public class SucursalServiceImpl implements SucursalService {
	
	@Autowired
	private SucursalRepository sucursalRepository;
	
	
	//Entity to DTO
	public SucursalDTO toSucursalDTO(Sucursal sucursal) {
		SucursalDTO dto = new SucursalDTO();
		dto.setIdSucursal(sucursal.getIdSucursal());
		dto.setNomSucursal(sucursal.getNomSucursal());
		dto.setPaisSucursal(sucursal.getPaisSucursal());
		dto.setTipusSucursal(sucursal.getPaisSucursal());
		return dto;
	}
	
	//DTO to Entity
	public Sucursal toSucursal(SucursalDTO dto) {
		Sucursal sucursal = new Sucursal();
		sucursal.setIdSucursal(dto.getIdSucursal());
		sucursal.setNomSucursal(dto.getNomSucursal());
		sucursal.setPaisSucursal(dto.getPaisSucursal());
		return sucursal;
	}
	

	@Override
	public SucursalDTO addSucursal(SucursalDTO dto) {
		Sucursal sucursal = toSucursal(dto);
		return toSucursalDTO(sucursalRepository.save(sucursal));
	}

	@Override
	public SucursalDTO updateSucursal(SucursalDTO dto) {
		Optional<Sucursal> sucursalOptional = sucursalRepository.findById(dto.getIdSucursal());
		Sucursal sucursalUpdated = null;
		if (sucursalOptional.isPresent()) {
			sucursalUpdated = sucursalOptional.get();
			sucursalUpdated.setNomSucursal(dto.getNomSucursal());
			sucursalUpdated.setPaisSucursal(dto.getPaisSucursal());
		}
		return toSucursalDTO(sucursalRepository.save(sucursalUpdated));
	}

	@Override
	public void deleteSucursalById(int id) {
		sucursalRepository.deleteById(id);
	}

	@Override
	public SucursalDTO getSucursalById(int id) {
		Optional<Sucursal> sucursalOptional = sucursalRepository.findById(id);
		Sucursal sucursal = null;
		if (sucursalOptional.isPresent()) {
			sucursal = sucursalOptional.get();
		}
		return toSucursalDTO(sucursal);
	}

	@Override
	public List<SucursalDTO> getAllSucursal() {
		List<SucursalDTO> listDTO = new ArrayList<>();
		for (Sucursal sucursal : sucursalRepository.findAll()) {
			listDTO.add(toSucursalDTO(sucursal));
		}
		return listDTO;
	}

}