import java.sql.Date;
import java.util.ArrayList;

public class Funcionario extends Pessoa {
    private int matricula;
    private Date horarioTrabalho;
    
    public int getMatricula() {
        return matricula;
    }
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
    public Date getHorarioTrabalho() {
        return horarioTrabalho;
    }
    public void setHorarioTrabalho(Date horarioTrabalho) {
        this.horarioTrabalho = horarioTrabalho;
    }
    public Funcionario(String cpf, String nome, String email, int matricula, Date horarioTrabalho) {
        super(cpf, nome, email);
        this.matricula = matricula;
        this.horarioTrabalho = horarioTrabalho;
    }

    
}
