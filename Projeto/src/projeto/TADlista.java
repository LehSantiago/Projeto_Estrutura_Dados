package projeto;
	
	import java.util.Scanner;
	import java.io.BufferedReader;
	import java.io.FileReader;
	import java.io.FileWriter;
	import java.io.PrintWriter;


	public class TADlista {

	    public static void main(String[] args) throws Exception {
	        Lista lista = new Lista(20);

	        carregarRodada("rodada1.txt", lista);
	        System.out.println("LISTA DA PRIMEIRA RODADA: -------------------------------------------------------");
	        lista.mostraLista();

	        carregarRodada("rodada2.txt", lista);
	        System.out.println("LISTA DA SEGUNDA RODADA: -------------------------------------------------------");
	        lista.mostraLista();

	        carregarRodada("rodada3.txt", lista);
	        System.out.println("LISTA DA TERCEIRA RODADA: -------------------------------------------------------");
	        lista.mostraLista();

	        carregarRodada("rodada4.txt", lista);
	        System.out.println("LISTA DA QUARTA RODADA: ---------------------------------------------------------");
	        lista.mostraLista();

	     
	        atualizarFinalistas(lista);

	     
	        System.out.println("ATUALIZAÇÃO DAS FINALISTA: -------------------------------------------------------");
	        lista.mostraLista();

	      
	        gravarMedalhistas(lista);
	    }

	    private static void carregarRodada(String arquivo, Lista lista) {
	        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
	            String linha;
	            while ((linha = br.readLine()) != null) {
	                String[] dados = linha.split(",");
	                String nome = dados[0].trim();
	                String pais = dados[1].trim();
	                double pontuacao = Double.parseDouble(dados[2].trim());
	                Atleta atleta = new Atleta(nome, pais, pontuacao);
	                lista.add(atleta);
	            }
	        } catch (Exception e) {
	            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
	        }
	    }

	    private static void atualizarFinalistas(Lista lista) {
	        Scanner entrada = new Scanner(System.in);
	        System.out.println("------- ATUALIZE AS PONTUAÇÕES DAS 8 FINALISTAS!: -------");

	        for (int i = 0; i < 8; i++) {
	            try {
	                Atleta atleta = lista.get(i);
	                System.out.print("DIGITE A NOVA PONTUAÇÃO PARA: " + atleta.getNome() + " (" + atleta.getPais() + "): ");
	                double novaPontuacao = entrada.nextDouble();
	                atleta.setPontuacao(novaPontuacao);
	            } catch (Exception e) {
	                System.err.println("Erro ao atualizar a lista: " + e.getMessage());
	            }
	        }

	      
	        reordenarLista(lista);
	    }

	    private static void reordenarLista(Lista lista) {
	       
	        for (int i = 0; i < lista.size() - 1; i++) {
	            for (int j = 0; j < lista.size() - 1 - i; j++) {
	                try {
	                    if (lista.get(j).getPontuacao() < lista.get(j + 1).getPontuacao()) {
	                        Atleta temp = lista.get(j);
	                        lista.set(j, lista.get(j + 1));
	                        lista.set(j + 1, temp);
	                    }
	                } catch (Exception e) {
	                    System.err.println("Erro ao reordenar a lista: " + e.getMessage());
	                }
	            }
	        }
	    }

	    private static void gravarMedalhistas(Lista lista) {
	        try (PrintWriter writer = new PrintWriter(new FileWriter("medalhas.txt"))) {
	            System.out.println("*** GRAVANDO MEDALHISTAS NO ARQUIVO! ***");
	            String[] medalhas = {"*--OURO:--*", "*--PRATA--*", "*--BRONZE--*"};
	            for (int i = 0; i < 3; i++) {
	                Atleta atleta;
	                try {
	                    atleta = lista.get(i);
	                    writer.printf("%s: %s - %s - %.2f%n", medalhas[i], atleta.getNome(), atleta.getPais(), atleta.getPontuacao());
	                    System.out.printf("%s: %s - %s - %.2f%n", medalhas[i], atleta.getNome(), atleta.getPais(), atleta.getPontuacao());
	                } catch (Exception e) {
	                    System.err.println("Erro ao gravar as medalhistas: " + e.getMessage());
	                }
	            }
	        } catch (Exception e) {
	            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
	        }
	    }
	}
