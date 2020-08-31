package com.example.iotdevice.repository;

import com.example.iotdevice.model.Temperature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemperatureRepository extends JpaRepository<Temperature, Integer> {
}
