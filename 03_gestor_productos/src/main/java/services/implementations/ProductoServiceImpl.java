package services.implementations;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import models.Producto;
import services.interfaces.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService {

		private static List<Producto> productos = new ArrayList<>();

		@Override
		public void agregarProducto(Producto producto) {
			productos.add(producto);
		}

		@Override
		public List<Producto> mostrarCategoria(String categoria) {
			List<Producto> encontrados = new ArrayList<Producto>();
			for (Producto p : productos) {
				if (p.getCategoria().toLowerCase().equals(categoria.toLowerCase())) {
					encontrados.add(p);
				}
			}
			encontrados.forEach(p->System.out.println(p.getNombre()));
			return encontrados;
		}
		
		@Override
		public List<Producto> mostrarCategoriaFuncional(String categoria) {
			for(Producto p : productos) {
				System.out.println("mostrarCategoriaFuncional->"+p.getNombre()+"-"+p.getPrecio());
			}
			return productos.stream()
					.filter(p->p.getCategoria().equals(categoria.toLowerCase()))
					.toList();
		}

		@Override
		public void eliminarProducto(String nombre) {
			for (int i = 0; i < productos.size(); i++) {
				if (productos.get(i).getNombre().equals(nombre)) {
					productos.remove(i);
				}
			}
		}
		
		@Override
		public void eliminarProductoFuncional(String nombre) {
			productos.removeIf(p->p.getNombre().equals(nombre));
		}

	}
