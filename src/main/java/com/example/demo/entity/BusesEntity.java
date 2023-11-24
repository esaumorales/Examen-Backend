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
@Table(name="BUSES")
public class BusesEntity implements Serializable {
private static final long serialVersionUID = -2170897015344177815L;

@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqBuses")
@Column(name = "BU_PLACA")
@SequenceGenerator(sequenceName = "SEQ_BUSES", allocationSize = 1, name = "seqBuses")
private Long id;

@Column(name = "BU_CODIBFLOT")
private String bu_CodiFlot;

@Column(name = "BU_CAPACIDAD")
private String bu_Capacidad;

@Column(name = "BU_FECHFABRI")
private String bu_FechFabri;

@Column(name = "BU_TIPO")
private String bu_Tipo;


@ManyToOne
@JoinColumn(name="FL_CODIFLOT", nullable = false)
private FlotaEntity flota;
}