package com.example.iotdevice.service;

import com.example.iotdevice.model.Device;
import org.springframework.stereotype.Service;

@Service
public interface DeviceService {

    public Device save(Device device);
    public Device getById(Integer deviceId);

    public Device getByFilter(Integer deviceId);
}
