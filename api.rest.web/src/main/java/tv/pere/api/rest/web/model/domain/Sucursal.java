package tv.pere.api.rest.web.model.domain;

import javax.persistence.*;


@Entity
@Table(name = "sucursals")
public class Sucursal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int idSucursal;
	
	@Column(name = "nom")
	private String nomSucursal;
	
	@Column(name = "pais")
	private String paisSucursal;
	
	
	public Sucursal() {

	}
	

	public Sucursal(int idSucursal, String nomSucursal, String paisSucursal) {
		this.idSucursal = idSucursal;
		this.nomSucursal = nomSucursal;
		this.paisSucursal = paisSucursal;
	}


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

}