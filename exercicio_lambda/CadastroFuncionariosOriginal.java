import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class CadastroFuncionariosOriginal {
	private List<Funcionario> lstf;

	public CadastroFuncionariosOriginal() {
		lstf = new LinkedList<>();

		Random r = new Random();

		for (int i = 0; i < 40; i++) {
			int matricula = r.nextInt(1000) + 100;
			String nome = "Fulano" + i;
			boolean insalubridade = r.nextBoolean();
			int nroDep = r.nextInt(3) + 1;
			double salBase = (r.nextDouble() * 15000) + 500;
			Funcionario f = new Funcionario(matricula, nome, salBase, nroDep, insalubridade);
			lstf.add(f);
		}
	}

	public List<Funcionario> getFuncionarios() {
		return Collections.unmodifiableList(lstf);
	}

	@Override
	public String toString() {
		return "CadastroFuncionarios [lstf=" + lstf + "]";
	}

	// 2a
	//Retornar uma lista com todos os funcionários que recebem insalubridade e tem dependentes.
	public List<Funcionario> getInsalubridadeDependentes() {
		List<Funcionario> resultado = lstf.stream() //cria uma stream a partir da lista de funcionários
		.filter(r -> r.getInsalubridade() && r.getNroDependentes() > 0)
		.toList();
		System.out.println("Lista de funcionários com insalubridade e dependentes: " + resultado);
		return resultado;
		//return new ArrayList<Funcionario>(); retorna lista vazia
	}

	// Retornar a quantidade de funcionários que tem dependentes.
	public long quantidadeFuncionariosComDependentes() {
   		long quantidade = lstf.stream() //pega a lista de funcionários que é private
		.filter(f -> f.getNroDependentes() > 0) //filtra os funcionários com dependentes
		.count(); //filtra os funcionários com dependentes e conta quantos são
		System.out.println("Quantidade de funcionários com dependentes: " + quantidade);
		return quantidade;
	}

	// Retornar o somatório do valor do salário bruto de todos os funcionários que ganha mais de 5000
	public double somatorioSalarioBruto() {
		double soma = lstf.stream()
		.filter(f -> f.getSalarioBruto() > 5000) //filtra os funcionários com salário bruto maior que 5000
		.mapToDouble(f -> f.getSalarioBruto()) //mapeia os funcionários para o salário bruto
		.sum(); //soma os salários brutos dos funcionários que ganham mais de 5000
		System.out.println("Soma dos salários brutos: " + soma);
		return soma;
	}

	// Aplicar uma taxa de aumento (ex: 1.2 para 20%) em todos os funcionários que recebem insalubridade.

	public void aumentaSalarioInsalubres() {
	    lstf.stream() //cria uma stream a partir da lista de funcionários
		.filter(f -> f.getInsalubridade()) //filtra os funcionários com insalubridade
		.forEach(f -> f.aumentaSalBase(1.2)); //aumenta o salário base em 20% para os funcionários com insalubridade
		System.out.println("Salário base aumentado em 10% para funcionários com insalubridade.");
		//COMPREENDIDO
	}

	// Retornar uma lista de strings com nome e a matrícula de todos os funcionários cujo salário bruto é mais de 10% maior que o salário base.
	public List<String> getNomeMatriculaSalarioBrutoMaiorQueBase(List<Funcionario> funcionarios) {
		List<Funcionario> resultado = funcionarios.stream()
		.filter(f -> f.getSalarioBruto() > (f.getSalarioBase() * 1.1)) //filtra os funcionários cujo salário bruto é mais de 10% maior que o salário base
		.toList(); // isso faz com que o resultado seja uma lista de funcionários filtrados
		List<String> nomesMatriculas = new ArrayList<>();
		for (Funcionario f : resultado) {
			nomesMatriculas.add(f.getNome() + " - " + f.getMatricula()); //adiciona o nome e a matrícula dos funcionários filtrados na lista de strings
		}
		System.out.println("Lista de nomes e matrículas de funcionários com salário bruto mais de 10% maior que o salário base: " + nomesMatriculas);
		return nomesMatriculas;
		//return new ArrayList<String>();

	}

	// Retornar a média salarial dos funcionários que não recebem insalubridade.
	public double mediaSalarialDosQueNaoTemInsalubridade() {
		double media = lstf.stream() //cria uma stream a paritr da lista de funcionários
		.filter(f -> !f.getInsalubridade()) //filtra os funcionários que não recebem insalubridade
		.mapToDouble(f -> f.getSalarioBruto()) //mapeia os funcionários para o salário bruto
		.average() //calcula a média dos salários brutos dos funcionários que não recebem insalubridade
		.orElse(0.0); //se não houver funcionários, retorna 0.0
		System.out.println("Média salarial dos funcionários que não recebem insalubridade: " + media);
		return media;
	}

	// Retornar a lista com o nome dos funcionários cujos números de matrícula são menores que 500.
	public List<String> nomesDosQueTemMatriculaMenorQue500(List<Funcionario> funcionarios) {
		List<String> nomes = funcionarios.stream()
		.filter(f -> f.getMatricula() < 500)
		.map(f -> f.getNome()) //mapeia os funcionários para o nome
		.toList(); //isso faz com que o resultado seja uma lista de nomes filtrados
		System.out.println("Lista de nomes de funcionários com matrícula menor que 500: " + nomes);
		return nomes;
		//COMPREENDIDO

		//return new ArrayList<String>();
	}

	// Retornar o salário líquido de um funcionário específico ou -1 se o funcionário não for encontrado.
	public double getSalarioLiquido(int matricula) {
		double salarioLiquido = lstf.stream()
		.filter(f -> f.getMatricula() == matricula) //filtra o funcionário pela matrícula
		.mapToDouble(f -> f.getSalarioLiquido()) //mapeia o funcionário para o salário líquido
		.findFirst() //encontra o primeiro funcionário que atende ao critério
		.orElse(-1.0); //se não houver funcionário, retorna -1.0
		System.out.println("Salário líquido do funcionário com matrícula " + matricula + ": " + salarioLiquido);
		return salarioLiquido;
	}
}
