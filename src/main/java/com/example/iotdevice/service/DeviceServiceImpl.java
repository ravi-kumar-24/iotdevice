package com.example.iotdevice.service;

import com.example.iotdevice.model.Device;
import com.example.iotdevice.repository.DeviceRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DeviceServiceImpl implements DeviceService {


    @Resource
    private DeviceRepository deviceRepository;
    @Override
    public Device save(Device device) {
        return deviceRepository.save(device);
    }

    public Device getById(Integer deviceId){
      return   deviceRepository.getOne(deviceId);
    }

    public Device getByFilter(Integer deviceId){
        return deviceRepository.getOne(deviceId);
    }
}
