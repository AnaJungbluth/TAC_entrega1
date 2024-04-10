package br.edu.utfpr.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.api.model.Leitura;

public interface LeituraRepository extends JpaRepository<Leitura, Long> {

}
