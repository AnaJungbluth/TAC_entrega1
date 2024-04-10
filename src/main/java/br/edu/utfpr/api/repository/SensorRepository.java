package br.edu.utfpr.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.api.model.Sensor;

public interface SensorRepository extends JpaRepository<Sensor, Long>  {

}
