package com.andresrojas.literalura.Repository;

import com.andresrojas.literalura.modelos.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}