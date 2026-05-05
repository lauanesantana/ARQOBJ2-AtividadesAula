
public enum NivelAcesso {

	ADM("administrador"),
	USUARIO("usuário"),
	VISITANTE("visitante");
	
	private String descricao; 
	
	NivelAcesso (String descricao) { 
		this.descricao = descricao; 
}	

	String getNivelAcesso() {
		
		return descricao; 
		
	}

	
}
