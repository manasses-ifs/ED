package br.edu.ifs.ED_2020;

public class ListaDuplamenteEncadeada <T extends Comparable<T>> extends Lista<T>{

	int qtd;
	T noReturn;
	NoDuplo<T> noCabeca;
	NoDuplo<T> noFim;
	
	public ListaDuplamenteEncadeada() {
		this.noCabeca = null;
		this.noFim = null;
		this.qtd=0;
		
	}
	
	public boolean eVazia() {
		return(this.noCabeca==null);
	}

	@Override
	public void incluir(T elemento) throws Exception {
		//incluir no final
		if (eVazia() )
			incluirInicio(elemento);
		else {
			NoDuplo<T> novoNo = new NoDuplo(elemento, null,this.noFim);
			this.noFim.noProx = novoNo;
			this.noFim = novoNo;
			this.qtd++;
		}
	}

	@Override
	public void incluirInicio(T elemento) throws Exception {
		if (eVazia() ) {
			NoDuplo<T> novoNo = new NoDuplo(elemento, null,null);
			this.noCabeca = novoNo;
			this.noFim = novoNo;
			this.qtd++;
		}else {//se a lista tiver algum no, o no cabeca ira receber novo no, e novo n� aponta para
			
			NoDuplo<T> novoNo = new NoDuplo(elemento, this.noCabeca,null);
			this.noCabeca.noAnt = novoNo;
			this.noCabeca = novoNo;
			this.qtd++;
		}	
		
	}

	@Override
	public void incluir(T elemento, int posicao) throws Exception {
		if (posicao>=getTamanho()+1)throw new Exception("Posi��o inexistente.");
		
		if (posicao==0)
			incluirInicio(elemento);
		else {
			if (posicao==getTamanho()){//se for no final
				incluir(elemento);
			}else {//incluir entre dois n�s
				NoDuplo<T> noAtual = noCabeca.noProx;
				NoDuplo<T> noAnt = noCabeca;
				NoDuplo<T> noProx = noAtual.getNoProx();
				for (int i =1; i<this.qtd; i++) {
					//anda nos ponteiros
					if (i==posicao) {//ao chegar na posicao escolhida cria o novo no
						NoDuplo<T> novoNo = new NoDuplo(elemento,noAtual,noAnt);
						noAtual.noAnt = novoNo;
						noAnt.noProx = novoNo;
						this.qtd++;
					}else {
						noAnt = noAtual;
						noAtual = noAtual.noProx;
						noProx = noAtual.noProx;						
					}
				}
			}
		}
	}

	@Override
	public T get(int posicao) throws Exception {
		if (posicao>getTamanho()) throw new Exception("Lista sem elementos.");
		if (posicao ==0)
			return noCabeca.no;
		else {
			NoDuplo<T> noAtual = noCabeca.noProx;
			for (int i =1; i<getTamanho(); i++)
				if (posicao==i)
					return noAtual.no;					
				else {
					noAtual = noAtual.noProx;
				}
			}
		System.out.println("Elemento n�o est� na lista");
		return null;
	}

	@Override
	public int getPosElemento(T elemento) throws Exception {
		if (getTamanho()==0)throw new Exception("Lista sem elementos.");

		if (elemento.compareTo(noCabeca.no)==0)
			return 0;
		else {
			NoDuplo<T> noAtual = noCabeca.noProx;
			for (int i=1; i<getTamanho(); i++) {
				if (elemento.compareTo(noAtual.no)==0)
					return i;
				else {
					noAtual = noAtual.noProx;
				}
			}
		}
		System.out.println("Elemento nao esta na lista");
		return -1;
	}

	@Override
	public int getTamanho() {
		return this.qtd;
	}

	@Override
	public void remover(int posicao) throws Exception {
		if (getTamanho()==0)throw new Exception("Lista sem elementos.");
		if (getTamanho()<=posicao)throw new Exception("Posição fora da lista.");
		if (posicao<0)throw new Exception("Posição negativa.");

		NoDuplo<T> noAtual=null;
		NoDuplo<T> ant=null;
		NoDuplo<T> prox=null;
		if (posicao==0) {
			this.noCabeca=null;
			this.noFim=null;
			this.qtd=0;
		} else {
			noAtual = noCabeca.noProx;
			ant = noCabeca;
			prox = noAtual.noProx;

			for (int i = 1; i < getTamanho(); i++)
				if (posicao == i) {
					//ponteiro que aponta pro no atual recebe noProx do no atual
					//ponteiro sucessor que aponta pro atual recebe o anterior
					ant.noProx = noAtual.noProx;
					prox.noAnt = ant;
				} else {
					ant = noAtual;
					noAtual = noAtual.noProx;
				}
		}
		
	}

	@Override
	public void limpar() {
		this.noCabeca = null;
		this.noFim = null;
		this.qtd = 0;
	}

	@Override
	public boolean contem(T elemento) throws Exception {
		if (getTamanho()==0)throw new Exception("Lista sem elementos.");
		NoDuplo<T> temProx = noCabeca;
		while (temProx!=null) {
			if (temProx.no.compareTo(elemento)==0)
				return true;
		}
		return false;
	}

}
