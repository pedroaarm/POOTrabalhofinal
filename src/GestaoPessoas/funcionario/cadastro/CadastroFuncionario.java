package GestaoPessoas.funcionario.cadastro;
import GestaoPessoas.CadastroEndereco;
import GestaoPessoas.CadastroInformacoesPessoais;
import GestaoPessoas.cliente.Endereco;
import GestaoPessoas.funcionario.BancoDedadosFuncionario.ArrayDeDados_Funcionario;
import GestaoPessoas.funcionario.Funcionario;
import java.io.IOException;

/**Faz o cadastro dos funcionarios
 *
 * @author pedro
 */
public class CadastroFuncionario {
    /**Usa os metodos necessarios para fazer o cadstro
     * 
     */
    public static void cadastro() throws IOException{
        
        CadastroInformacoesPessoais cadastropessoas = new CadastroInformacoesPessoais();
        CadastroEndereco cadastroendereco = new CadastroEndereco();
        CadastroTrabalhistaFuncionario trabalhista = new CadastroTrabalhistaFuncionario();
        //Chamando as classes de cadastro;
        cadastropessoas.cadastroinformacoespessoais();
        Endereco endereco = cadastroendereco.cadendereco();
        trabalhista.cadastrotrabalhistas();

        Funcionario funcionario = new Funcionario(trabalhista.getSalario(),trabalhista.getJornadadetrabalho(),cadastropessoas.getNome(),cadastropessoas.getCpf(),cadastropessoas.getTelefone(),endereco.toString(), trabalhista.getFuncao());
        AdicionarFuncionario.addfuncionario(funcionario);

        System.out.println("\nPressione Enter para continuar...");
        System.in.read(); 

}   
    }