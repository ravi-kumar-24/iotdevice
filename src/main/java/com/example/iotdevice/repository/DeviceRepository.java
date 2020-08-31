package com.example.iotdevice.repository;

import com.example.iotdevice.model.Device;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Integer> {
    public  Device getOne(Integer deviceId);


    @Query("select  t.temperatureValue from Device d join d.temperatures t where d.deviceId = ?1 and t.temperatureValue > ?2" )
    List<Integer> getByFilterGreaterThan(Integer deviceId, int filter);

    @Query("select  t.temperatureValue from Device d join d.temperatures t where d.deviceId = ?1 and t.temperatureValue < ?2" )
    List<Integer> getByFilterLessThan(Integer deviceId, int filter);
}
