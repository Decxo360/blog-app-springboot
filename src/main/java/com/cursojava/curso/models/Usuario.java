package com.cursojava.curso.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "usuarios")
@ToString
@EqualsAndHashCode
public class Usuario {

    @Getter @Setter @Id @Column(name = "idusuario") @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Getter @Setter @Column(name = "correo")
    private String correo;
    @Getter @Setter @Column(name = "contrasena")
    private String contrasena;
    @Getter @Setter @Column(name = "nombre")
    private String nombre;
    @Getter @Setter @Column(name = "apellidos")
    private String apellidos;
    @Getter @Setter @Column(name = "nickname")
    private String nickname;
    @Getter @Setter @Column(name = "created_at")
    private Date created_at;
    @Getter @Setter @Column(name = "updated_at")
    private Date updated_at;


}
