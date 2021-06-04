package com.integracion.demo;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@RequestMapping("inventario")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	private InterfaceLibros iLibros; //inyectamos la interface (tendra un libro valido)

	/*{
  		"titulo": "Idiotisado",
  		"autor": "Rafael Cervantes",
  		"categoria": "Drama",
  		"idioma": "Castellano",
  		"paginas": 80,
  		"estatus": "Disponible"
	}*/

	//dar de alta libro
	@PostMapping
	public ResponseEntity<Libro> createLibro(@RequestBody Libro book){
		Libro libroNew = iLibros.save(book);
		return ResponseEntity.ok(libroNew);
	}

	//obtener todos los libros
	@GetMapping
	public ResponseEntity<List<Libro>> getLibro(){ //regresa todos los libros de mi base de datos
		List<Libro> libros = iLibros.findAll();
		return ResponseEntity.ok(libros);
	}

    //obtener libro en especifico   /inventario/4
	@RequestMapping(value="{libroId}")
	public ResponseEntity<Libro> getLibroById(@PathVariable("libroId") Long libroId){
		Optional<Libro> optionalLibro = iLibros.findById(libroId);
		if(optionalLibro.isPresent()){
			return ResponseEntity.ok(optionalLibro.get()); // si existe retorno el libro
		}else{
			return ResponseEntity.noContent().build();// si no existe dira que no esta
		}
	}

	//borrar libro
	@DeleteMapping(value = "{libroId}")
	public ResponseEntity<Void> deleteLibro(@PathVariable("libroId") Long libroId){
		iLibros.deleteById(libroId);
		return ResponseEntity.ok(null);
	}

	@PutMapping
	public ResponseEntity<Libro> updateLibro(@RequestBody Libro book){
		Optional<Libro> optionalLibro = iLibros.findById(book.getId());
		if(optionalLibro.isPresent()){
			Libro updateLibro = optionalLibro.get();
			updateLibro.setTitulo(book.getTitulo());
			updateLibro.setAutor(book.getAutor());
			updateLibro.setCategoria(book.getCategoria());
			updateLibro.setIdioma(book.getIdioma());
			updateLibro.setPaginas(book.getPaginas());
			updateLibro.setEstatus(book.getEstatus());
			iLibros.save(updateLibro);
			return ResponseEntity.ok(updateLibro);
		}else{
			return ResponseEntity.notFound().build();// si no existe dira que no esta
		}
	}


}
