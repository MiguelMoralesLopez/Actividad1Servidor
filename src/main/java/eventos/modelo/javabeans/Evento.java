package eventos.modelo.javabeans;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Evento implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int idEvento;
	private String nombre;
	private String descripcion;
	private Date fechaInicio;
	private String estado;
	private String destacado;
	private int aforoMaximo;
	private int minimoAsistencia;
	private double precio;
	private Tipo idTipo;
}
