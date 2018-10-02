package principal;

import java.util.ArrayList;
import java.util.Scanner;

public class AppAStar {
	
	Vertice A;
	Vertice B;
	Vertice C;
	Vertice D;
	Vertice E;
	Vertice F;
	Vertice G;
	Vertice H;
	Vertice I;
	Vertice J;
	Vertice K;
	Vertice L;
	
	public void criar_grafo() {
		
		A = new Vertice("A",18);
		B = new Vertice("B",15);
		C = new Vertice("C",35);
		D = new Vertice("D",10);
		E = new Vertice("E",27);
		F = new Vertice("F",20);
		G = new Vertice("G",23);
		H = new Vertice("H",5);
		I = new Vertice("I",12);
		J = new Vertice("J",34);
		K = new Vertice("K",22);
		L = new Vertice("L",9);
		
		A.arestas_adjacentes.add(new Arestas(0, A));
		A.arestas_adjacentes.add(new Arestas(15, B));
		A.arestas_adjacentes.add(new Arestas(8, C));
		
		B.arestas_adjacentes.add(new Arestas(0, B));
		B.arestas_adjacentes.add(new Arestas(5, D));
		
		C.arestas_adjacentes.add(new Arestas(0, C));
		C.arestas_adjacentes.add(new Arestas(12, E));
		C.arestas_adjacentes.add(new Arestas(8, F));
		
		D.arestas_adjacentes.add(new Arestas(0, D));
		D.arestas_adjacentes.add(new Arestas(11, G));
		D.arestas_adjacentes.add(new Arestas(3, H));
		
		E.arestas_adjacentes.add(new Arestas(0, E));
		E.arestas_adjacentes.add(new Arestas(7, H));
		E.arestas_adjacentes.add(new Arestas(5, I));
		
		F.arestas_adjacentes.add(new Arestas(0, F));
		F.arestas_adjacentes.add(new Arestas(11, I));
	
		G.arestas_adjacentes.add(new Arestas(0, G));
		G.arestas_adjacentes.add(new Arestas(8, J));
		
		H.arestas_adjacentes.add(new Arestas(0, H));
		
		I.arestas_adjacentes.add(new Arestas(0, I));
		I.arestas_adjacentes.add(new Arestas(7,K));
		
		J.arestas_adjacentes.add(new Arestas(0, J));
		J.arestas_adjacentes.add(new Arestas(5, L));
		
		K.arestas_adjacentes.add(new Arestas(0, K));
		K.arestas_adjacentes.add(new Arestas(16, L));
		
		L.arestas_adjacentes.add(new Arestas(0, L));
		
		ArrayList<Vertice> grafo = new ArrayList<Vertice>();
		
		grafo.add(A);
		grafo.add(B);
		grafo.add(C);
		grafo.add(D);
		grafo.add(E);
		grafo.add(F);
		grafo.add(G);
		grafo.add(H);
		grafo.add(I);
		grafo.add(J);
		grafo.add(K);
		grafo.add(K);
		grafo.add(L);
		
		AlgoritmoAEstrela algoritmoAstar = new AlgoritmoAEstrela();
		
		Vertice resultado = algoritmoAstar.algoritmoAestrela(grafo, A, L);
		
		algoritmoAstar.caminho_recorrencia(resultado);

	}
	
	public static void main(String[]  args) {
		AppAStar astar = new AppAStar();
		astar.criar_grafo();
	}

}
