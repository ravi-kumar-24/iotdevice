package com.example.iotdevice.service;

import com.example.iotdevice.model.Device;
import com.example.iotdevice.repository.DeviceDao;
import com.example.iotdevice.repository.DeviceDaoImpl;
import com.example.iotdevice.repository.DeviceRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {


    @Resource
    private DeviceRepository deviceRepository;

    @Resource
    private DeviceDaoImpl deviceDaoImpl;

    @Override
    public Device save(Device device) {
        return deviceRepository.save(device);
    }

    public Device getById(Integer deviceId){
      return   deviceRepository.getOne(deviceId);
    }

    public List<Integer> getByFilter(Integer deviceId){
        Device d = getById(deviceId);
        String fil = d.getFilter();
        String[] tokens = fil.split(" ");
        if(fil.contains("gt")){
            return deviceRepository.getByFilterGreaterThan(deviceId, Integer.parseInt(tokens[1]));
        }else{
            return deviceRepository.getByFilterLessThan(deviceId,  Integer.parseInt(tokens[1]));
        }

    }
}
