package tv.pere.api.rest.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import tv.pere.api.rest.web.model.dto.SucursalDTO;
import tv.pere.api.rest.web.model.service.SucursalService;

@Controller
public class SucursalController {
	
	@Autowired
	private SucursalService sucursalService;
	
	private ModelAndView formulariSucursalDTO(SucursalDTO sucursalDTO, String nomVista) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("DATA_SucursalsDtoFormulari", sucursalDTO);
		modelAndView.setViewName(nomVista);
		return modelAndView;
	}
	
	
	@GetMapping("/LlistaSucursals")
	public ModelAndView llistaSucursals() {
		ModelAndView modelAndView = new ModelAndView();
		List<SucursalDTO> sucursalsDTO = sucursalService.getAllSucursal();
		modelAndView.addObject("DATA_SucursalsDtoLlista", sucursalsDTO);
		modelAndView.setViewName("Sucursals");
		return modelAndView;
	}
	
	
	@GetMapping("/AltaSucursal")
	public ModelAndView formulariNovaSucursal() {
		SucursalDTO sucursalDTO = new SucursalDTO();
		sucursalDTO.setNomSucursal("");
		return formulariSucursalDTO(sucursalDTO, "AltaSucursal");
	}
	
	
	@GetMapping("/EditaSucursal/{id}")
	public ModelAndView formulariEditaSucursal(@PathVariable("id") int id) {
		SucursalDTO sucursalDTO = sucursalService.getSucursalById(id);
		return formulariSucursalDTO(sucursalDTO, "EditaSucursal");
	}
	
	
	@GetMapping("/ConsultaSucursal/{id}")
	public ModelAndView formulariConsultaSucursal(@PathVariable("id") int id) {
		SucursalDTO sucursalDTO = sucursalService.getSucursalById(id);
		return formulariSucursalDTO(sucursalDTO, "ConsultaSucursal");
	}
	
	
	@GetMapping("BaixaSucursal/{id}")
	public ModelAndView baixaSucursal(@PathVariable("id") int id) {
		sucursalService.deleteSucursalById(id);
		return new ModelAndView("redirect:/LlistaSucursals");
	}
	
	
	@PostMapping("/DesarSucursal")
	public ModelAndView desarSucursal(@ModelAttribute("DATA_SucursalsDtoFormulari") SucursalDTO sucursalDTO) {
		sucursalService.addSucursal(sucursalDTO);
		return new ModelAndView("redirect:/LlistaSucursals");
	}
		
}