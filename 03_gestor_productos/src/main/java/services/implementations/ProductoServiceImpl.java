package services.implementations;


import java.util.ArrayList;
import java.util.List;

import models.Producto;
public class ProductoServiceImpl {

		private static List<Producto> productos = new ArrayList<>();

		public void agregarProducto(String nombre, double precio, String categoria) {
			productos.add(new Producto(nombre,precio,categoria));
			System.out.println("Producto añadido correctamente.");
		}

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
		
		public List<Producto> mostrarCategoriaFuncional(String categoria) {
			for(Producto p : productos) {
				System.out.println("mostrarCategoriaFuncional->"+p.getNombre()+"-"+p.getPrecio());
			}
			return productos.stream()
					.filter(p->p.getCategoria().equals(categoria.toLowerCase()))
					.toList();
		}

		public void eliminarProducto(String nombre) {
			for (int i = 0; i < productos.size(); i++) {
				if (productos.get(i).getNombre().equals(nombre)) {
					productos.remove(i);
				}
			}
		}
		
		public void eliminarProductoFuncional(String nombre) {
			productos.removeIf(p->p.getNombre().equals(nombre));
		}
	}
