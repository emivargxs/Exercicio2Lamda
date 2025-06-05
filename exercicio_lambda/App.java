import java.util.List;

    public class App {
    public static void main(String[] args) {
        // Passo 1: Criar o cadastro de funcionários
        CadastroFuncionariosOriginal cadastro = new CadastroFuncionariosOriginal();

        // Passo 2: Listar todos os funcionários
        System.out.println("Todos os funcionários:");
        System.out.println("\n"+ cadastro.getFuncionarios() + "\n");

        // Passo 3: Obter funcionários com insalubridade e dependentes
        List<Funcionario> insalubresComDependentes = cadastro.getInsalubridadeDependentes();
        System.out.println("Funcionários com insalubridade e dependentes:");
        System.out.println("\n" + insalubresComDependentes + "\n");

        // Passo 4: Quantidade de funcionários com dependentes
        long qtdComDependentes = cadastro.quantidadeFuncionariosComDependentes();
        System.out.println("Quantidade de funcionários com dependentes: " + qtdComDependentes);

        // Passo 5: Somatório dos salários brutos acima de 5000
        double somaSalarios = cadastro.somatorioSalarioBruto();
        System.out.println("Somatório dos salários brutos > 5000: " + somaSalarios);

        // Passo 6: Aumentar salário dos insalubres
        cadastro.aumentaSalarioInsalubres();

        // Passo 7: Lista de nomes e matrículas com salário bruto > 10% do base
        List<String> nomesMatriculas = cadastro.getNomeMatriculaSalarioBrutoMaiorQueBase(cadastro.getFuncionarios());
        System.out.println("Nomes e matrículas (salário bruto > 10% do base):");
        System.out.println(nomesMatriculas);

        // Passo 8: Média salarial dos que não têm insalubridade
        double mediaSemInsalubridade = cadastro.mediaSalarialDosQueNaoTemInsalubridade();
        System.out.println("Média salarial dos que não têm insalubridade: " + mediaSemInsalubridade);

        // Passo 9: Nomes dos que têm matrícula menor que 500
        List<String> nomesMatriculaMenor500 = cadastro.nomesDosQueTemMatriculaMenorQue500(cadastro.getFuncionarios());
        System.out.println("Nomes dos funcionários com matrícula < 500:");
        System.out.println(nomesMatriculaMenor500);

        // Passo 10: Salário líquido de um funcionário específico (exemplo: matrícula 150)
        double salarioLiquido = cadastro.getSalarioLiquido(150);
        System.out.println("Salário líquido do funcionário de matrícula 150: " + salarioLiquido);
    }
}
