package com.api.Projeto.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "estado")
@Builder
public class EstadoModel  implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    private String Municipio;

    private String nomeProduto;

    private String MesEmissao;

    private String AnoEmissao;

    private String cdPrograma;

    private String cdSubPrograma;

    private String cdFonteRecurso;

    private String cdTipoSeguro;

    private String cdEstado;

    private String cdProduto;

    private String cdMuicipio;

    private double VlCusteio;

    private String Atividade;

    private String cdModalidade;

    private String AreaInvest;
}
