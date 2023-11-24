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
@Table(name="CONDUCTORES")
public class ConductoresEntity implements Serializable {
private static final long serialVersionUID = -2170897015344177815L;

@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqConductores")
@Column(name = "CO_CODICONDUC")
@SequenceGenerator(sequenceName = "SEQ_CONDUCTORES", allocationSize = 1, name = "seqConductores")
private Long id;

@Column(name = "CO_NOMBCONDUC")
private String co_NombConduc;

@Column(name = "CO_DIRECODUC")
private String co_DireConduc;

@Column(name = "CO_FECHNACI")
private String co_fechNaci;

@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "conductores")
@JsonIgnore
private Set<ViajesEntity> viajes;

}