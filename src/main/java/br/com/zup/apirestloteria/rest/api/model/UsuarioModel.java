package br.com.zup.apirestloteria.rest.api.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Arrays;

@Entity(name = "usuario")
public class UsuarioModel {

    @Id
    public Integer codigo;

    @Column(nullable = false, length = 100)
    public String login;

    @Column(nullable = false, length = 50)
    public String numeros;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNumeros() {
        return numeros;
    }

    public void setNumeros(String numeros) {
        int[] resultado = new int[6];
        for (int i = 0; i < 6; i++) {
            int sorteado;
            sorteado = (int) (Math.random()*60)+1;
            resultado[i] = sorteado;
        };
        this.numeros = Arrays.toString(resultado);
    }
}
