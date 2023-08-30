package com.ouvidoria1.spring.Ouvidoria1;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ouvidoria1.spring.Ouvidoria1.services.PessoasServices;
import com.ouvidoria1.spring.Ouvidoria1.services.TratamentoDeErro;

@SpringBootApplication
public class Ouvidoria1Application implements CommandLineRunner {

	@Autowired
	PessoasServices pessoaServices;

	public static void main(String[] args) {
		SpringApplication.run(Ouvidoria1Application.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		TratamentoDeErro entrada = new TratamentoDeErro();
		Scanner scanner = new Scanner(System.in);

		int d6 = 0;
		while (d6 != 3) {

			System.out.println("1 - Cadastrar usuario \n2 - Logar \n3 - Sair");
			int d5 = entrada.inteiro();

			if (d5 == 1) {
				System.out.println("1 - Usuário \n2 - Funcionário");
				int d7 = entrada.inteiro();

				if (d7 == 1) {
					System.out.println("Nome do usuario: ");
					String nome = entrada.lerString();
					System.out.println("Email: ");
					String email = entrada.lerString();
					System.out.println("Usuário: ");
					String usuario = entrada.lerString();
					System.out.println("Senha: ");
					String senha = entrada.lerString();

					System.out.println("Cadastro efetuado com sucesso");

					pessoaServices.addUsuario(nome, email, usuario, senha, false);
				} else if (d7 == 2) {
					System.out.println("Nome: ");
					String nome = entrada.lerString();
					System.out.println("Email: ");
					String email = entrada.lerString();
					System.out.println("Usuário: ");
					String usuario = entrada.lerString();
					System.out.println("Senha: ");
					String senha = entrada.lerString();

					System.out.println("Cadastro efetuado com sucesso");

					pessoaServices.addFuncionario(nome, email, usuario, senha, true);
				} else {
					System.out.println("Número inexistente");
				}
			} else if (d5 == 2) {
				int d8 = 0;
				while (d8 != 3) {
					System.out.println("1 - Usuário \n2 - Funcionario \n3 - Voltar");
					int f3 = entrada.inteiro();

					if (f3 == 1) {
						System.out.println("Login usuário");

						System.out.println("Usuário: ");
						String usuario = entrada.lerString();
						System.out.println("Senha: ");
						String senha = entrada.lerString();

						pessoaServices.logarAluno(usuario, senha);

						if (pessoaServices.logarAluno(usuario, senha) != null) {
							System.out.println("Usuário logado com sucesso");

							int f22 = 0;
							while (f22 != 3) {
								System.out.println("1 - Cadastrar manifestação \n2 - Listar \n3 - Voltar");
								int d222 = entrada.inteiro();

								if (d222 == 1) {
									System.out.println("Cadastrar");
									System.out.println("Digite o tipo: ");
									String tipo = entrada.lerString();
									System.out.println("Descrição: ");
									String descricao = entrada.lerString();

									pessoaServices.adicionarManifestacao(tipo, descricao,
											pessoaServices.logarAluno(usuario, senha));

									System.out.println("Manifestação do tipo " + tipo + "Adicionada com sucesso!!");
								} else if (d222 == 2) {
									System.out.println("Listando");

									pessoaServices.listarManifestacao();
								} else if (d222 == 3) {
									System.out.println("Voltando");
									break;

								} else {
									System.out.println("Número incorreto");
								}
							}
						} else {
							System.out.println("Usuário ou senha incorreto");
						}
					} else if (f3 == 2) {
						System.out.println("Login funcionário");

						System.out.println("Usuário: ");
						String usuario = entrada.lerString();
						System.out.println("Senha: ");
						String senha = entrada.lerString();

						pessoaServices.logarFuncionario(usuario, senha);

						if (pessoaServices.logarFuncionario(usuario, senha) != null) {
							System.out.println("Funcionário logado com sucesso");
							
							int f5 = 0;
							while (f5 != 3) {
								System.out.println("1 - Listar manifestações \n2 - Remover manifestações \n3 - Voltar");
								int d114 = entrada.inteiro();
								
								if (d114 == 1) {
									System.out.println("Listando");
									
									pessoaServices.listarManifestacao();
								} else if (d114 == 2) {
									System.out.println("Removendo");
									
									System.out.println("Digite o id da manifestação que deseja excluir: ");
									long id = scanner.nextLong();
									
									pessoaServices.removerManifestacao(id);
									
								} else if (d114 == 3) {
									System.out.println("Voltando");
									break;
								} else {
									System.out.println("Número incorreto");
								}
							}
						} else {
							System.out.println("Usuário ou senha incorreto");
						}
					} else if (f3 == 3) {
						System.out.println("Voltando");
						break;
					} else {
						System.out.println("Número incorreto");
					}
				}
			} else if (d5 == 3) {
				System.out.println("Sair");
				break;
			} else {
				System.out.println("Número incorreto");
			}
		}
		scanner.close();

	}

}
