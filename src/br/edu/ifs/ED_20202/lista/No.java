package br.edu.ifs.ED_2020;

public class No <T extends Comparable<T>>{
	 
	 public T no;
	 public No noProx;
	 
	 public No(T elemento, No noProx){
	        super();
	        this.no = elemento;
	        this.noProx = noProx;	        
	 }

	public T getNo() {
		return this.no;
	}

	public void setNo(T no) {
		this.no = no;
	}

	public No getNoProx() {
		return noProx;
	}

	public void setNoProx(No noProx) {
		this.noProx = noProx;
	}
}
