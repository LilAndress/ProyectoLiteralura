package com.andresrojas.literalura;

import com.andresrojas.literalura.Service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

	@Autowired
	private LibroService service;

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) {

		Scanner teclado = new Scanner(System.in);
		int opcion = -1;

		while (opcion != 0) {

			System.out.println("""
                    1 - Buscar libro por título
                    2 - Listar todos los libros
                    3 - Listar libros por idioma
                    4 - Cantidad de libros en inglés
                    5 - Cantidad de libros en español
                    0 - Salir
                    """);

			opcion = teclado.nextInt();
			teclado.nextLine();

			switch (opcion) {
				case 1:
					System.out.println("Ingrese el título:");
					String titulo = teclado.nextLine();
					service.buscarYGuardarLibro(titulo);
					break;

				case 2:
					service.listarLibros();
					break;

				case 3:
					System.out.println("Ingrese idioma (en, es):");
					String idioma = teclado.nextLine();
					service.listarPorIdioma(idioma);
					break;

				case 4:
					service.mostrarCantidadPorIdioma("en");
					break;

				case 5:
					service.mostrarCantidadPorIdioma("es");
					break;
			}
		}
	}
}