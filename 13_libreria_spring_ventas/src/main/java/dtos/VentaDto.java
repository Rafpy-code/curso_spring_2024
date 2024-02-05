package dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class VentaDto {

	private int idVenta;
	private String usuario;
	private String tituloLibro;
	private LocalDate fechaVenta;
	
}
