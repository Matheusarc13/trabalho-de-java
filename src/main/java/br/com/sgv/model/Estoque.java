package br.com.sgv.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Pablo Rangel <pablo.rangel@gmail.com>
 * @date 22/04/2021
 * @brief class Estoque
 */
@Entity
@Getter
@Setter
public class Estoque{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Size(min = 1, message = "O nome do produto precisa ser válido.")
    private String nome;
    private String tamanho;
    private String modelo;
    private float preco;
    private int quantidade;
    @Override
    public String toString() {
        return nome;
    }
}
