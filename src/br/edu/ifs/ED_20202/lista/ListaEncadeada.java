package br.edu.ifs.ED_2020;

public class ListaEncadeada <T extends Comparable<T>> extends Lista<T>{

	int qtd;
	T noReturn;
	No<T> noCabeca;
	No<T> noFim;
	
	public ListaEncadeada(Class<T> dataType){
        super();
        qtd = 0; 
        this.noCabeca = null;        
        this.noFim = null;               
	}
	
	public boolean eVazia() {
		return(this.noCabeca==null);
	}
	
	@Override
	public void incluir(T elemento) throws Exception {		
		if (eVazia()) {
			incluirInicio(elemento);
		} else {//insere no final
			No<T> novoNo = new No(elemento, null);
			this.noFim.noProx = novoNo;
			this.noFim = novoNo;
			qtd++;
		}	
	}

	@Override
	public void incluirInicio(T elemento) throws Exception {
		//se a cabeca est� vazia
		if (eVazia() ) {
			No<T> novoNo = new No(elemento, null);
			this.noCabeca = novoNo;
			this.noFim = novoNo;
			this.qtd++;
		}			
		else {//se a lista tiver algum no, o no cabeca ira receber novo no 
			No<T> novoNo = new No(elemento, this.noCabeca);
			this.noCabeca = novoNo;
			this.qtd++;
		}	
	}

	@Override
	public void incluir(T elemento, int posicao) throws Exception {
		if (posicao>=getTamanho()+1)throw new Exception("Posi��o inexistente.");

		if (eVazia())//se nao existe nos na lista incluir no inicio
			incluirInicio(elemento);
		else {
			No<T> noAtual = noCabeca.noProx;
			No<T> ApontaAnt = noCabeca;
			
			for (int i =1; i<this.qtd; i++) {
				//anda nos ponteiros
				if (i==posicao) {//ao chegar na posicao escolhida cria o novo no
					No<T> novoNo = new No(elemento, ApontaAnt);					
					noAtual.noProx = novoNo;
				}else {//percorre os n�s at� chegar na posi��o
					ApontaAnt = noAtual;
					noAtual = noAtual.noProx;
				}					
			}
		}
		
	}

	
	@Override
	public T get(int posicao) throws Exception {
		if (posicao>getTamanho()) throw new Exception("Lista sem elementos.");
			
		if (eVazia())
			return noCabeca.no;
			
		else {
			No<T> noAtual = noCabeca.noProx;
			for (int i =1; i<getTamanho(); i++)
				if (posicao==i)
					return noAtual.no;					
				else {
					noAtual = noAtual.noProx;
				}
			}
		System.out.println("Elemento nao esta na lista");
		return null;	
	}

	@Override
	public int getPosElemento(T elemento) throws Exception {
		if (getTamanho()==0)throw new Exception("Lista sem elementos.");
		
		if (elemento.compareTo(noCabeca.no)==0)
			return 0;
		else {
			No<T> noAtual = noCabeca.noProx;
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
		// TODO Auto-generated method stub
		return this.qtd;
	}

	@Override
	public void remover(int posicao) throws Exception {
		if (getTamanho()==0)throw new Exception("Lista sem elementos.");
		if (getTamanho()<=posicao)throw new Exception("Posição fora da lista.");
		if (posicao<0)throw new Exception("Posição negativa.");
		No<T> noAtual=null;
		No<T> ant=null;
		if (posicao==0) {
			this.noCabeca=null;
			this.noFim=null;
			this.qtd=0;
		} else {
			noAtual = noCabeca.noProx;
			ant = noCabeca;
			for (int i = 1; i < getTamanho(); i++)
				if (posicao == i) {
					//ponteiro anterior que aponta pro no atual recebe noProx do no atual
					ant = noAtual.noProx;
				} else {
					ant = noAtual;
					noAtual = noAtual.noProx;
				}
		}
	}

	@Override
	public void limpar() {
		qtd = 0; 
        this.noCabeca = null;        
        this.noFim = null;
	}

	@Override
	public boolean contem(T elemento) throws Exception {
		if (getTamanho()==0)throw new Exception("Lista sem elementos.");
		No<T> temProx=noCabeca;
		while (temProx!=null) {
			if (temProx.no.compareTo(elemento)==0)
				return true;
		}	
		return false;
	}
		
}
