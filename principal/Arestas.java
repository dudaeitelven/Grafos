package principal;

public class Arestas {
	
	private int peso;
	private Vertice vertice_adjacente;
	
	public Arestas(int peso, Vertice vertice_adjacente) {
		this.peso = peso;
		this.vertice_adjacente = vertice_adjacente;
	
	}
	
	public int getPeso() {
		return peso;
	}
	
	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	public Vertice getVertice_adjacente() {
		return vertice_adjacente;
	}
	
	public void setVertice_adjacente(Vertice vertice_adjacente) {
		this.vertice_adjacente = vertice_adjacente;
	}

	
	public Vertice getVet_final() {
		return vertice_adjacente;
	}
	
	

}
