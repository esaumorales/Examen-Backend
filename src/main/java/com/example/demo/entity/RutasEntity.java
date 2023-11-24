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
@Table(name="RUTAS")
public class RutasEntity implements Serializable {
private static final long serialVersionUID = -2170897015344177815L;

@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqRutas")
@Column(name = "RU_CODIRUTA")
@SequenceGenerator(sequenceName = "SEQ_RUTAS", allocationSize = 1, name = "seqRutas")
private Long id;

@Column(name = "RU_NOMBRUTA")
private String ru_NombRuta;

@Column(name = "RU_VALOPASJ")
private String ru_ValoPasj;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "rutas")
@JsonIgnore
private Set<ViajesEntity> viajes;
}