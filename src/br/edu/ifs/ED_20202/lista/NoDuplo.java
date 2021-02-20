package br.edu.ifs.ED_2020;

public class NoDuplo  <T extends Comparable<T>> {

	public T no;
	public NoDuplo noProx;
	public NoDuplo noAnt;
	
	public NoDuplo(T elemento, NoDuplo noProx, NoDuplo noAnt) {
		super();
		this.no = elemento;
        this.noProx = noProx;
        this.noAnt = noAnt;
	}

	public T getNo() {
		return no;
	}

	public void setNo(T no) {
		this.no = no;
	}

	public NoDuplo getNoProx() {
		return noProx;
	}

	public void setNoProx(NoDuplo noProx) {
		this.noProx = noProx;
	}

	public NoDuplo getNoAnt() {
		return noAnt;
	}

	public void setNoAnt(NoDuplo noAnt) {
		this.noAnt = noAnt;
	}

}
