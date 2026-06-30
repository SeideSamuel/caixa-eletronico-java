import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<ContaBanco> contas = new ArrayList<>();
        Scanner usuario = new Scanner(System.in);
        int opcao = 0;

        menu : while (true) {
        System.out.println("-----CAIXA ELETRONICO-----");
        System.out.println("[1] Criar uma conta");
        System.out.println("[2] Fechar uma conta");
        System.out.println("[3] Sacar");
        System.out.println("[4] Depositar");
        System.out.println("[5] Ver saldo");
        System.out.println("[6] Sair");
        System.out.println("Escolha uma opção:");
        try {
            opcao = usuario.nextInt();
        } catch (RuntimeException e) {
            usuario.next();
            continue;
        }

        switch(opcao) {
                case 1:
                    System.out.println("Qual o seu nome?");
                    String nome = usuario.next();
                    ContaBanco user = new ContaBanco(nome);
                    user.abrirConta();
                    contas.add(user);
                    System.out.println("Conta criada, Seja bem vindo" + user.getNome() + "!");
                    break;

                case 2:
                    System.out.println("Qual nome da conta?");
                    String nomeDigitado = usuario.next();

                    for (ContaBanco c: contas) {
                        if(c.getNome().toLowerCase().equals(nomeDigitado.toLowerCase())) {
                            c.fecharConta();
                        }
                    }
                    break;

                case 3:
                    System.out.println("Qual nome da conta?");
                    String nomeSaque = usuario.next();

                    for (ContaBanco c: contas) {
                        if(c.getNome().toLowerCase().equals(nomeSaque.toLowerCase())) {
                            while (true) {
                                try {
                                    System.out.println("Qual valor do saque?");
                                    double saque = usuario.nextDouble();
                                    c.sacar(saque);
                                    break;
                                } catch (RuntimeException e) {
                                    System.out.println("ERRO! Tente novamente");
                                    usuario.next();
                                }
                            }
                        }
                    }
                    break;

                case 4:
                    System.out.println("Qual nome da conta?");
                    String nomeDeposito = usuario.next();

                    for (ContaBanco c : contas) {
                        if(c.getNome().toLowerCase().equals(nomeDeposito.toLowerCase())) {
                            while(true) {
                                try {
                                    System.out.println("Qual valor do deposito?");
                                    double deposito = usuario.nextDouble();
                                    c.depositar(deposito);
                                    break;
                                } catch (RuntimeException e) {
                                    System.out.println("ERRO! Tente novamente");
                                    usuario.next();
                                }
                            }


                        }
                    }
                    break;

                case 5:
                    System.out.println("Qual nome da conta?");
                    String nomeSaldo = usuario.next();

                    for(ContaBanco c : contas) {
                        if(c.getNome().toLowerCase().equals(nomeSaldo.toLowerCase())) {
                            c.verSaldo();
                        }
                    }
                    break;

                case 6:
                    System.out.println("Encerrando...");
                    break menu;


                default:
                    System.out.println("Opção inválida, tente novamente");
                    continue;

            }
        }


    }
}