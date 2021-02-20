package br.edu.ifs.ED_20202.lista;

import java.lang.reflect.InvocationTargetException;

public class ListaSequencial<T extends Comparable<T>> extends Lista<T>{


    T[] lista;
    int qtdMax;
    int finalLista;
    public ListaSequencial(Class<T> dataType){
        super();
        qtdMax = 10;
        this.lista = (T[]) java.lang.reflect.Array.newInstance(dataType, qtdMax);
        finalLista = -1;
    }

    @Override
    public void limpar() {
        finalLista = -1;
    }
    @Override
    public T get(int posicao) throws Exception {
        if (finalLista<0)throw new Exception("Array vazio.");
        return lista[posicao];
    }

    @Override
    public int getPosElemento(T elemento) throws Exception {
        if(finalLista<0) throw new Exception("Array vazio.");
        int pos=-1;
        if (contem(elemento))
            for (int i =0; i<finalLista; i++) {
                if (lista[i]==elemento)
                    pos = i;
            }
        return pos;
    }

    @Override
    public void incluir(T elemento) throws Exception {
        if (getTamanho()==getQtdMax()) throw new Exception("Array completo.");
        for (int i =0; i<finalLista;i++)
            if ((elemento.compareTo(this.lista[i]))<1)
                incluir(elemento, i);
    }

    @Override
    public void incluirInicio(T elemento) throws Exception {
        if (getTamanho()==getQtdMax()) throw new Exception("Array completo.");
        if (get(0).compareTo(elemento)>0) throw new Exception("Lista desordenada, inserção não realizada.");

        finalLista ++;
        if (getTamanho()>=0)
            for(int i =finalLista; i>=1; i--)
                lista[i]=lista[i-1];
        lista[0]=elemento;
    }

    @Override
    public void incluir(T elemento, int posicao) throws Exception {
        if (getTamanho()==this.getQtdMax()) new Exception("array completo");
        if (posicao==0)
        {
            incluirInicio(elemento);
        } else{
            if ( (posicao==getTamanho()+1) && ((elemento.compareTo(lista[finalLista]))>=0) )
            {
                this.finalLista++;
                this.lista[finalLista]=elemento;
            } else
            {
                if ( (elemento.compareTo(get(posicao-1))>0) && (elemento.compareTo(get(posicao+1))<=0) )
                {
                    finalLista++;
                    for (int i =finalLista; i>posicao; i--)
                        lista[i]=lista[i-1];
                    lista[posicao]=elemento;
                }else
                    System.out.println("Array desordenado...");
            }
        }
    }

    @Override
    public void remover(int posicao) throws Exception {
        if(getTamanho()<0) throw new Exception("Array vazio.");
        if(posicao>getTamanho()) throw new Exception("Posição não pertence ao vetor.");
        for (int i =posicao; i<getTamanho(); i++)
            lista[i]=lista[i+1];
        finalLista--;
    }
    @Override
    public int getTamanho() {
        return this.qtdMax;
    }

    @Override
    public boolean contem(T elemento) throws Exception {
        if(getTamanho()<0) throw new Exception("Array vazio.");
        boolean result = false;
        for (int i =0; i<=getTamanho(); i++)
            if (elemento.compareTo(lista[i])==0)
                result= true;
        return result;
    }
}
