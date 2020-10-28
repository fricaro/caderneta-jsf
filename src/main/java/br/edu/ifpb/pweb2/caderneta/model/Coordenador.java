package br.edu.ifpb.pweb2.caderneta.model;

import java.io.Serializable;

import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Coordenador extends Professor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(columnDefinition = "boolean default false")
	private Boolean ativo;
	
	private String dtype;
	
	public Coordenador() {}
	
	// GETTERS AND SETTERS

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	
	public String getDtype() {
		return dtype;
	}

	public void setDtype(String dtype) {
		this.dtype = dtype;
	}
	
	// TO STRING, HASHCODE, EQUALS
	
	
	@Override
	public String toString() {
		return "Coordenador [ativo=" + ativo + ", dtype=" + dtype + "]";
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.getId() == null) ? 0 : this.getId().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordenador other = (Coordenador) obj;
		if (this.getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!this.getId().equals(other.getId()))
			return false;
		return true;
	}
}
