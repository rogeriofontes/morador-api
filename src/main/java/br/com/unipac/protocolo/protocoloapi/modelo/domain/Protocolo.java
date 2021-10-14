package br.com.unipac.protocolo.protocoloapi.modelo.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tb_protocolos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Protocolo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    @Column(name = "documento_id")
    private Integer documentId;
}