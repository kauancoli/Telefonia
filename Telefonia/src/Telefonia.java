import java.util.Scanner;

class Telefonia {
	private PrePago[] prePagos;
    private int numPrePagos;
    private PosPago[] posPagos;
    private int numPosPagos;

    public Telefonia() {
        this.prePagos = new PrePago[3];
        this.numPrePagos = 0;
        this.posPagos = new PosPago[3];
        this.numPosPagos = 0;
    }

    public void cadastrarAssinante() {
    	Scanner scanner = new Scanner(System.in);

        System.out.println("Tipos de assinatura:");
        System.out.println("1. Pré-pago");
        System.out.println("2. Pós-pago");
        System.out.print("Digite o desejado: ");
        int tipoAssinante = scanner.nextInt();

        System.out.print("Digite o CPF: ");
        long cpf = scanner.nextLong();

        System.out.print("Digite o nome: ");
        String nome = scanner.next();

        System.out.print("Digite o número: ");
        String numero = scanner.next();

        switch (tipoAssinante) {
        	case 1:
	            prePagos[numPrePagos] = new PrePago(cpf, nome, numero);
	            numPrePagos++;
	            System.out.println("Assinante pré-pago cadastrado com sucesso!");
	            break;

        	case 2:
	            posPagos[numPosPagos] = new PosPago(cpf, nome, numero);
	            numPosPagos++;
	            System.out.println("Assinante pós-pago cadastrado com sucesso!");
	            break;

            default:
                System.out.println("Opção inválida.");
                return;
        }
    }

   public void listarAssinantes() {
    	System.out.println("Assinantes Pré-pagos:");
        for (int i = 0; i < numPrePagos; i++) {
            System.out.println("Assinante " + (i + 1) + ":");
            prePagos[i].exibirDetalhes();
            System.out.println();
        }

        System.out.println("Assinantes Pós-pagos:");
        for (int i = 0; i < numPosPagos; i++) {
            System.out.println("Assinante " + (i + 1) + ":");
            posPagos[i].exibirDetalhes();
            System.out.println();
        }

        if (numPrePagos == 0 && numPosPagos == 0) {
            System.out.println("Nenhum assinante cadastrado.");
        } else {
            System.out.println("Total de Assinantes: " + (numPrePagos + numPosPagos));
        }
    }

    public void fazerChamada() {
	Scanner scanner = new Scanner(System.in);

       	System.out.print("Digite o CPF do assinante: ");
       	long cpf = scanner.nextLong();

       	System.out.print("Digite o tipo de assinatura (1 para Pré-pago, 2 para Pós-pago): ");
       	int tipoAssinatura = scanner.nextInt();

       	Assinante assinante;
       	if (tipoAssinatura == 1) {
           	assinante = localizarPrePago(cpf);
       	} else if (tipoAssinatura == 2) {
           	assinante = localizarPosPago(cpf);
       	} else {
           	System.out.println("Tipo de assinatura inválido.");
           	return;
       	}

       	if (assinante == null) {
           	System.out.println("Assinante não encontrado.");
           	return;
       	}

       	System.out.print("Digite a duração da chamada em minutos: ");
       	int duracao = scanner.nextInt();

       	GregorianCalendar data = new GregorianCalendar();

       	assinante.fazerChamada(data, duracao);

       	System.out.println("Chamada realizada com sucesso!");
    	}

    public void fazerRecarga() {

    }

    public PrePago localizarPrePago(long cpf) {
    	for (int i = 0; i < numPrePagos; i++) {
            if (prePagos[i].getCpf() == cpf) {
                return prePagos[i];
            }
        }
        return null;
    }

    public PosPago localizarPosPago(long cpf) {
    	for (int i = 0; i < numPosPagos; i++) {
    		if (posPagos[i].getCpf() == cpf) {
    			return posPagos[i];
    	    }
    	}
    	return null;
    }

    public void imprimirFaturas() {
        
    }

    public static void main(String[] args) {
        Telefonia sistemaTelefonia = new Telefonia();
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("Menu:");
            System.out.println("1. Cadastrar assinante");
            System.out.println("2. Listar assinantes");
            System.out.println("3. Fazer chamada");
            System.out.println("4. Fazer recarga");
            System.out.println("5. Imprimir faturas");
            System.out.println("6. Sair do programa");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    sistemaTelefonia.cadastrarAssinante();
                    break;
                case 2:
                    sistemaTelefonia.listarAssinantes();
                    break;
                case 3:
                    sistemaTelefonia.fazerChamada();
                    break;
                case 4:
                    sistemaTelefonia.fazerRecarga();
                    break;
                case 5:
                    sistemaTelefonia.imprimirFaturas();
                    break;
                case 6:
                    System.out.println("Encerrando o programa. Obrigado!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 6);

        scanner.close();
    }
}
