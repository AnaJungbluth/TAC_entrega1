package br.edu.utfpr.api.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_leitura")
@Data

public class Leitura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long leituraID;

    @Column(nullable = false)
    private String valor;

    @Column(nullable = false)
    private Date dataHora;

    @ManyToOne
    @JoinColumn(name = "sensor_id")
    private Sensor sensor;
}
