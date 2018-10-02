package principal;

import java.util.ArrayList;

public class Vertice {
	
	private String nome;
	private int peso = 0;
	ArrayList<Arestas> arestas_adjacentes = new ArrayList<Arestas>() ;
	private Vertice verticePai;
	int gAnt;
	private int PesoF;
	
	
	public Vertice(String nome, int peso) {
		this.nome = nome;
		this.peso = peso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPeso() {
		return peso;
	}


	public void setPeso(int peso) {
		this.peso = peso;
	}

	public void calcular_F(int peso_aresta) {
		this.PesoF = peso_aresta + this.peso; // para A*.
		//this.peso = peso_aresta; // para busca gulosa.
	}

	public int getF () {
		return PesoF;
	}

	public void setVerticePai(Vertice verticePai) {
		this.verticePai = verticePai;
	}
	
	public Vertice getVerticePai() {
		return verticePai;
	}

}
