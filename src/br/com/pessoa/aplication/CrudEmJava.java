package br.com.pessoa.aplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.pessoa.model.Pessoa;

public class CrudEmJava {
	private List<Pessoa> pessoas = new ArrayList<>();
	private Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		CrudEmJava crud = new CrudEmJava();
		crud.executar();
	}
	
	private void executar() {
		int opcao;
		do {
			System.out.println("1 - Adicionar Pessoa");
			System.out.println("2 - Listar Pessoas");
			System.out.println("3 - Atualizar Pessoa");
			System.out.println("4 - Remover Pessoa");
			System.out.println("0 - Sair");
			System.out.println("Escolha uma opção");
			opcao = scanner.nextInt();
			scanner.nextLine(); //
			
			switch (opcao) {
				case 1:
					adicionarPessoa();
					break;
				case 2:
					listarPessoas();
					break;
				case 3:
					atualizarPessoa();
					break;
				case 4:
					removerPessoa();
					break;
			}
		} while (opcao != 0);
	}
	
	private void adicionarPessoa() {
		System.out.println("Digite o nome da pessoa: ");
		String nome = scanner.nextLine();
		System.out.println("Digite a idade da pessoa: ");
		int idade = scanner.nextInt();
		scanner.nextLine(); 
		
		Pessoa pessoa = new Pessoa(nome, idade);
		pessoas.add(pessoa);
		System.out.println("Pessoa adicionada com sucesso");
	}
	
	private void listarPessoas() {
		System.out.println("Lista de Pessoas: ");
		for (Pessoa pessoa : pessoas) {
			System.out.println("Nome: " + pessoa.getNome() + " Idade: " + pessoa.getIdade());
		}
	}
	
	private void atualizarPessoa() {
		System.out.println("Digite o nome da pessoa que irá ser atualizado: "); 
		String nome = scanner.nextLine();
		
		for (Pessoa pessoa : pessoas) {
			if (pessoa.getNome().equals(nome)) {
				System.out.println("Digite a nova idade da pessoa: ");
				int novaIdade = scanner.nextInt();
				scanner.nextLine(); 
				
				pessoa = new Pessoa(nome, novaIdade);
				System.out.println("Pessoa atualizada com sucesso !!");
				return;
			}
		}
		
		System.out.println("Pessoa não encontrada");
	}
	
	private void removerPessoa() {
		System.out.println("Digite o nome da pessoa que será removido: ");
		String nome = scanner.nextLine();
		
		Pessoa pessoaRemovida = null;
		for (Pessoa pessoa : pessoas) {
			if (pessoa.getNome().equals(nome)) {
				pessoaRemovida = pessoa;
				break;
			}
		}
		
		if (pessoaRemovida != null) {
			pessoas.remove(pessoaRemovida);
			System.out.println("Pessoa removida com sucesso!!");
		} else {
			System.out.println("Pessoa não encontrada");
		}
	}
}
