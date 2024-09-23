package projeto;

public class Lista {

	  Atleta[] vetor;
	  int tamanho;
	  int qtde;

	  public Lista(int tamanho) {
	   this.tamanho = tamanho;
	     vetor = new Atleta[tamanho];
	     qtde = 0;
	  }

	  public boolean isEmpty() {
	      return qtde == 0;
	}

	  public int size() {
	    return qtde;
}

	 public Atleta get(int p) throws Exception {
	    if (isEmpty()) {
	     throw new Exception("A lista está vazia!!");
	   }
	       if (p < 0 || p >= qtde) {
	          throw new Exception("Posição inválida");
	     }
	    return vetor[p];
	 }

	  public void set(int p, Atleta nova) throws Exception {
	    if (isEmpty()) {
	        throw new Exception("A lista está vazia!!");
	     }
	    
	  if (p < 0 || p >= qtde) {
	        throw new Exception("Posição inválida");
	        }
	        vetor[p] = nova;
	    }

	  
	  
	   public int achaPos(double pontuacao) {
	     int pos = 0;
	     while (pos < qtde && vetor[pos].getPontuacao() >= pontuacao) {
	          pos++;
	       }
	       return pos;
	    }

 public void add(Atleta nova) throws Exception {
	      if (qtde == tamanho) {
	            throw new Exception("A lista está cheia!! Impossível inserir");
	        }
	      
	        int pos = achaPos(nova.getPontuacao());
	        for (int i = qtde; i > pos; i--) {
	            vetor[i] = vetor[i - 1];
	        }
	        vetor[pos] = nova;
	        qtde++;
	    }

	    public void remove(int p) throws Exception {
	        if (isEmpty()) {
	            throw new Exception("A lista está vazia!! Impossível remover");
	        }
	        if (p < 0 || p > qtde - 1) {
	            throw new Exception("Posição inválida!!");
	        }
	        for (int i = p; i < qtde - 1; i++) {
	            vetor[i] = vetor[i + 1];
	        }
	        qtde--;
	    }

	    public void mostraLista() {
	        for (int i = 0; i < qtde; i++) {
	            System.out.println(vetor[i].getNome() + " - " + vetor[i].getPais() + " - " + vetor[i].getPontuacao());
	        }
	        System.out.println("FIM DA LISTA!!");
	    }
	}

