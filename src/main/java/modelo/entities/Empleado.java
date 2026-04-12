package modelo.entities;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="EMPLEADOS")
public class Empleado {
	
	@Id
	@Column(name="ID_EMPL")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empleadoId;
	
    private String nombre;
    private String apellidos;
    private char genero;
    private String email;
    private String password;
    private double salario;
    
	@Column(name="FECHA_INGRESO")
    private LocalDate fechaIngreso;
	
	@Column(name="FECHA_NACIMIENTO")
    private LocalDate fechaNacimiento;
	
	@ManyToOne
	@JoinColumn(name="ID_DEPAR")
	private Departamento departamento;; 
	
	@ManyToOne
	@JoinColumn(name="ID_PERFIL")
	private Perfil perfil;
	
	
	public String nombreCompleto() {
		String nombreCompleto = (nombre + " " + apellidos);
		
		return nombreCompleto;
	}
	
	public String literalGenero() {
	    char literal = Character.toUpperCase(this.genero);

	    if (literal == 'H') {
	        return "Hombre";
	    } else if (literal == 'M') {
	        return "Mujer";
	    } else

	    return "No definido";
	}
	
	public double salarioMensual(int meses) {
	    return (this.salario / 12.0) * meses;
	}
	
	

	public Empleado(int empleadoID, String nombre, String apellidos, char genero, String email, String password,
			double salario, LocalDate fechaIngreso, LocalDate fechaNacimiento, Departamento departamento,
			Perfil perfil) {
		super();
		this.empleadoId = empleadoID;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.genero = genero;
		this.email = email;
		this.password = password;
		this.salario = salario;
		this.fechaIngreso = fechaIngreso;
		this.fechaNacimiento = fechaNacimiento;
		this.departamento = departamento;
		this.perfil = perfil;
	}

	public Empleado() {
		super();
	}

	public int getEmpleadoId() {
		return empleadoId;
	}

	public void setEmpleadoId(int empleadoID) {
		this.empleadoId = empleadoID;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public char getGenero() {
		return genero;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	@Override
	public int hashCode() {
		return Objects.hash(empleadoId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Empleado))
			return false;
		Empleado other = (Empleado) obj;
		return empleadoId == other.empleadoId;
	}

	@Override
	public String toString() {
		return "Empleado [empleadoID=" + empleadoId + ", nombre=" + nombre + ", apellidos=" + apellidos + ", genero="
				+ genero + ", email=" + email + ", password=" + password + ", salario=" + salario + ", fechaIngreso="
				+ fechaIngreso + ", fechaNacimiento=" + fechaNacimiento + ", departamento=" + departamento + ", perfil="
				+ perfil + "]";
	}
    

    

}