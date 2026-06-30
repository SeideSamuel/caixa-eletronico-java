public class ContaBanco {
    private String nome;
    private double saldo;
    private boolean status;

    public ContaBanco(String nome) {
        this.nome = nome;
    }

    public void abrirConta() {
        this.setStatus(true);
        System.out.println("Conta aberta com sucesso!");
    }

    public void fecharConta() {
        if(getSaldo() > 0) {
            System.out.println("Impossível fechar a conta, pois ainda tem saldo");
        } else {
            this.setStatus(false);
            System.out.println("Conta fechada!");
        }
    }

    public void depositar(double deposito) {
        if(isStatus()) {
            setSaldo(getSaldo() + deposito);
        } else {
            System.out.println("Impossível depositar em uma conta fechada");
        }
    }

    public void sacar(double saque) {
        if(isStatus()) {
            if (getSaldo() >= saque) {
                setSaldo(getSaldo() - saque);
                System.out.println("Saque realizado com sucesso");
            } else {
                System.out.println("Saldo insuficiente");

            }
        } else {
            System.out.println("Impossível sacar em uma conta fechada!");
        }
    }

    public void verSaldo() {
        System.out.println("Seu saldo é: " + "R$" + getSaldo());
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}