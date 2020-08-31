package com.example.iotdevice.service;

import com.example.iotdevice.model.Device;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DeviceService {

    public Device save(Device device);
    public Device getById(Integer deviceId);

    public List<Integer> getByFilter(Integer deviceId);
}
