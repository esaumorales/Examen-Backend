package com.example.demo.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="VIAJES")
public class ViajesEntity implements Serializable {
private static final long serialVersionUID = -2170897015344177815L;

@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqViajes")
@Column(name = "VI_NUMEVUELTA")
@SequenceGenerator(sequenceName = "SEQ_VIAJES", allocationSize = 1, name = "seqViajes")
private Long id;

@Column(name = "VI_NUMEPASAJERO")
private String vi_NumePasajero;

@Column(name = "VI_FECHVIAJE")
private String vi_FechViaje;


	@ManyToOne
    @JoinColumn(name="RU_CODIRUTA", nullable = false)
    private RutasEntity rutas;
  	
  	@ManyToOne
    @JoinColumn(name="CO_CODICONDUC", nullable = false)
    private ConductoresEntity conductores;
  	
  	@ManyToOne
    @JoinColumn(name="BU_PLACA", nullable = false)
    private BusesEntity buses;
}
