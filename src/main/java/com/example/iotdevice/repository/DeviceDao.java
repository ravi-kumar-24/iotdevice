package com.example.iotdevice.repository;

import com.example.iotdevice.model.Device;

public interface DeviceDao {
    public Device getByFilter(Integer deviceId, String filter);
}
