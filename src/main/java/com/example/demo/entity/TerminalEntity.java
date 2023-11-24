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
@Table(name="TERMINAL")
public class TerminalEntity implements Serializable {
private static final long serialVersionUID = -2170897015344177815L;

@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqTerminal")
@Column(name = "TE_CODITERM")
@SequenceGenerator(sequenceName = "SEQ_TERMINAL", allocationSize = 1, name = "seqTerminal")
private Long id;

@Column(name = "TE_DIRETERM")
private String Te_DireTerm;

@Column(name = "TE_NOMBTERM")
private String Te_NombTerm;




/*@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "rutas")
@JsonIgnore
private Set<AsistenciaEntity> asistencia;
*/
}