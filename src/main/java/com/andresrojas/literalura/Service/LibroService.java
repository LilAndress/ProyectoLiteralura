package com.andresrojas.literalura.Service;

import com.andresrojas.literalura.DTO.DatosAutor;
import com.andresrojas.literalura.DTO.DatosLibro;
import com.andresrojas.literalura.DTO.RespuestaGutendex;
import com.andresrojas.literalura.Repository.AutorRepository;
import com.andresrojas.literalura.Repository.LibroRepository;
import com.andresrojas.literalura.modelos.Autor;
import com.andresrojas.literalura.modelos.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private ConsumoApi consumoAPI;

    public void buscarYGuardarLibro(String titulo) {

        RespuestaGutendex respuesta = consumoAPI.buscarLibro(titulo);

        if (respuesta.getResults().isEmpty()) {
            System.out.println("Libro no encontrado.");
            return;
        }

        DatosLibro datos = respuesta.getResults().get(0);

        DatosAutor datosAutor = datos.getAuthors().get(0);

        Autor autor = new Autor();
        autor.setNombre(datosAutor.getName());
        autor.setAnioNacimiento(datosAutor.getAnioNacimiento());
        autor.setAnioFallecimiento(datosAutor.getAnioFallecimiento());

        autorRepository.save(autor);

        Libro libro = new Libro();
        libro.setTitulo(datos.getTitle());
        libro.setIdioma(datos.getLanguages().get(0));
        libro.setNumeroDescargas(datos.getNumeroDescargas());
        libro.setAutor(autor);

        libroRepository.save(libro);

        System.out.println("Libro guardado correctamente.");
    }

    public void listarLibros() {
        libroRepository.findAll()
                .forEach(System.out::println);
    }

    public void listarPorIdioma(String idioma) {
        libroRepository.findByIdioma(idioma)
                .forEach(System.out::println);
    }

    public void mostrarCantidadPorIdioma(String idioma) {
        Long cantidad = libroRepository.countByIdioma(idioma);
        System.out.println("Cantidad en " + idioma + ": " + cantidad);
    }
}