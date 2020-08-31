package com.example.iotdevice.repository;

import com.example.iotdevice.model.Device;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public interface DeviceDao {
    public Device getByFilter(Integer deviceId);
}
