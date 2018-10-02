package principal;

import java.util.ArrayList;

public class AlgoritmoAEstrela {
	
	public ArrayList<Vertice> vertices_abertos = new ArrayList<>();
	public ArrayList<Vertice> vertices_fechados = new ArrayList<>();
	public ArrayList<Vertice> caminho_astar = new ArrayList<>();
	public ArrayList<Vertice> vertices_adjacentes;

	public Vertice algoritmoAestrela (ArrayList<Vertice> grafo, Vertice vInicial, Vertice vFinal) {
		
		//adiciona o vertice inicial ao conjunto aberto e calcula se F()
		vertices_abertos.add(vInicial); //adiciona o vertice inicial aos vertices abertos.
		vInicial.calcular_F(peso_aresta(vInicial,vInicial)); //calcula o valor de F
		
		//armazena o vertice atual
		Vertice verticePai = vInicial;
		
		//inicia o laco principal
		while (!verticePai.equals(vFinal)) {
			//preenche o conjunto de adjacentes do vertice inicial.
			vertices_adjacentes = new ArrayList();
			criar_N(verticePai);
			for (int i = 1; i < vertices_adjacentes.size(); i++ ) {
				vertices_adjacentes.get(i).gAnt = verticePai.gAnt + peso_aresta(verticePai,vertices_adjacentes.get(i));
				
				//calcula o F() do vertice
				vertices_adjacentes.get(i).calcular_F(vertices_adjacentes.get(i).gAnt); 
				
				if (!vertices_fechados.contains(vertices_adjacentes.get(i))) {
					// seta o vertice atual como vertice pai.
					vertices_adjacentes.get(i).setVerticePai(verticePai); 
					
				}
				// adiciona os vertices adjacentes aos vertices abertos
				vertices_abertos.add(vertices_adjacentes.get(i)); 
				
			}
			//adiciona o vertice atual ao conjunto de vertices fechados e retira-o dos vertices abertos.
			vertices_fechados.add(verticePai);
			vertices_abertos.remove(verticePai);
			//seta o novo vertice atual
			verticePai = menor_F(vertices_abertos);
		}
		
		return verticePai;
	}
	
	
	//verifica qual o vertice com o menor F no conjunto
	public Vertice menor_F (ArrayList<Vertice> grafo) {
		Vertice menorF = grafo.get(0);
		
		//percorre todos os vertices do grupo
		for (int i = 1; i < grafo.size(); i++ ) {
			if (grafo.get(i).getF() < menorF.getF()) {
				menorF = grafo.get(i);
			}
		}
		return menorF;
	}
	
	// criar o conjunto de vertices adjacentes
	public ArrayList<Vertice> criar_N(Vertice atual){
		//percore o conjunto de arestas.
		for (int i = 0; i < atual.arestas_adjacentes.size(); i++ ){
			//adiciona os vertices finais das arestas do vertice atual
			vertices_adjacentes.add(atual.arestas_adjacentes.get(i).getVet_final());
		}
		return vertices_adjacentes;
	}
	
	//retorna o peso da aresta
	public int peso_aresta(Vertice vi, Vertice vf){
		int peso = 0;
		//percorrer as aresta do vertice inicial
		for (int i =0 ; i < vi.arestas_adjacentes.size(); i++){
			if (vi.arestas_adjacentes.get(i).getVet_final().equals(vf)) {
				peso = vi.arestas_adjacentes.get(i).getPeso();
			}
		}
		return peso;
	}


	 /*recebe como parametro o vertice final (resultado) e busca o pai do mesmo e joga para um array auxiliar.
	  Após mostrar o array de forma inversa para que o caminho fique na ordem */
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
