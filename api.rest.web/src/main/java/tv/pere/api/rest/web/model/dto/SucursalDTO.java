package tv.pere.api.rest.web.model.dto;

import java.util.Arrays;
import java.util.List;


public class SucursalDTO {
	
	private int idSucursal;
	private String nomSucursal;
	private String paisSucursal;
	private String tipusSucursal;
	private List<String> paisosUE = Arrays.asList("Alemanya", "Àustria", "Bèlgica", "Bulgària", "Croàcia", "Dinamarca", "Eslovàquia", 
			"Eslovènia", "Espanya", "Estònia", "Finlàndia", "França", "Grècia", "Hongria", "Irlanda", "Itàlia", "Letònia", "Lituània",
			"Luxemburg", "Malta", "Països Baixos", "Polònia", "Portugal", "Romania", "Suècia", "Txèquia", "Xipre");
	

	public int getIdSucursal() {
		return idSucursal;
	}


	public void setIdSucursal(int idSucursal) {
		this.idSucursal = idSucursal;
	}


	public String getNomSucursal() {
		return nomSucursal;
	}


	public void setNomSucursal(String nomSucursal) {
		this.nomSucursal = nomSucursal;
	}


	public String getPaisSucursal() {
		return paisSucursal;
	}


	public void setPaisSucursal(String paisSucursal) {
		this.paisSucursal = paisSucursal;
	}


	public String getTipusSucursal() {
		return tipusSucursal;
	}
	
	public void setTipusSucursal(String paisSucursal) {
		
		boolean isUE = false;
		int i = 0;
		
		if (paisSucursal != null) {
			while (!isUE && paisosUE.size() > i) {
				if (paisSucursal.equalsIgnoreCase(paisosUE.get(i))) {
					isUE = true;
				}
				i++;
			}

			tipusSucursal = isUE ? "UE" : "Fora UE";
		}
	}

}