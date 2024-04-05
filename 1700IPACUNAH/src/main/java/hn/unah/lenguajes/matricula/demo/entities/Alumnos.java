package hn.unah.lenguajes.matricula.demo.entities;

import java.util.List;

import jakarta.persistence.Id;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="alumnos")
@Data
public class Alumnos {
    
    @Id
    @Column(name = "numerocuenta")
    private String numeroCuenta;

    private String nombre;

    private String apellido;

    private String correo;

    private String telefono;

    @ManyToOne
    @JoinColumn(name = "codigocarrera", referencedColumnName = "codigocarrera")
    private Carrera carrera;


    //relacion de muchos a muchos
    //un alumno tiene una list de asignaturas
    @ManyToMany(cascade = CascadeType.ALL)      //para actualizacion en cascada
    @JoinTable(name="alumno_asignatura",        //nombre de la tabla
    joinColumns = @JoinColumn(name="numerocuenta"),     //llave columna de la entidad en la que estoy en este caso Alumnos
    inverseJoinColumns = @JoinColumn(name="codigoasignatura"))  //columna de la entidad con la que se esta relacionando, osea la otra columa de la tabla transaccinal
    private List<Asignaturas> asignaturas;

}
