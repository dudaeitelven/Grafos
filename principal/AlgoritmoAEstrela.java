package principal;

import java.util.ArrayList;

public class AlgoritmoAEstrela {
	
	public ArrayList<Vertice> vertices_abertos = new ArrayList<>();
	public ArrayList<Vertice> vertices_fechados = new ArrayList<>();
	public ArrayList<Vertice> caminho_astar = new ArrayList<>();
	public ArrayList<Vertice> vertices_adjacentes;

	public Vertice algoritmoAestrela (ArrayList<Vertice> grafo, Vertice vInicial, Vertice vFinal) {
		
		vertices_abertos.add(vInicial); //adiciona o vertice inicial aos vertices abertos.
		vInicial.calcular_F(peso_aresta(vInicial,vInicial)); //calcula o valor de F
		
		Vertice verticePai = vInicial;
		
		while (!verticePai.equals(vFinal)) {
			
			vertices_adjacentes = new ArrayList();
			criar_N(verticePai);
			for (int i = 1; i < vertices_adjacentes.size(); i++ ) {
				vertices_adjacentes.get(i).gAnt = verticePai.gAnt + peso_aresta(verticePai,vertices_adjacentes.get(i));
				
				vertices_adjacentes.get(i).calcular_F(vertices_adjacentes.get(i).gAnt); 
				
				if (!vertices_fechados.contains(vertices_adjacentes.get(i))) {
					vertices_adjacentes.get(i).setVerticePai(verticePai); 
					
				}
				vertices_abertos.add(vertices_adjacentes.get(i)); 
				
			}
			vertices_fechados.add(verticePai);
			vertices_abertos.remove(verticePai);
			verticePai = menor_F(vertices_abertos);
		}
		
		return verticePai;
	}
	
	public Vertice menor_F (ArrayList<Vertice> grafo) {
		Vertice menorF = grafo.get(0);
		
		for (int i = 1; i < grafo.size(); i++ ) {
			if (grafo.get(i).getF() < menorF.getF()) {
				menorF = grafo.get(i);
			}
		}
		return menorF;
	}
	
	public ArrayList<Vertice> criar_N(Vertice atual){
		for (int i = 0; i < atual.arestas_adjacentes.size(); i++ ){
			vertices_adjacentes.add(atual.arestas_adjacentes.get(i).getVet_final());
		}
		return vertices_adjacentes;
	}
	
	public int peso_aresta(Vertice vi, Vertice vf){
		int peso = 0;
		for (int i =0 ; i < vi.arestas_adjacentes.size(); i++){
			if (vi.arestas_adjacentes.get(i).getVet_final().equals(vf)) {
				peso = vi.arestas_adjacentes.get(i).getPeso();
			}
		}
		return peso;
	}

	public void caminho_recorrencia(Vertice resultado) {
		int aux = 0;
		Vertice pai = resultado;
	   	  do {
	   		  caminho_astar.add(pai);
	   		  pai = pai.getVerticePai();
	   		  
	   	 } while (pai != null);
	   	  
	   	 
	   	System.out.println("   ---   Resultado   ---   "); 
	    System.out.print("Caminho: ");
	    for ( int i = caminho_astar.size()-1 ; i > -1 ; i-- ) {

	    	 if (i != 0) {
	    		 System.out.print(caminho_astar.get(i).getNome() + " ( " + caminho_astar.get(i).getPeso()  + " ) =>  ");
	    		 aux = aux + caminho_astar.get(i).getPeso();
	    	 } else {
	    		 System.out.print(caminho_astar.get(i).getNome());
	    	 }
	     }
	   
	     System.out.println("\nTempo de Viagem: " + aux + " minutos.\n");
	}

}
