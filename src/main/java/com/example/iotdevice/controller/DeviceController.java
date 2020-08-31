package com.example.iotdevice.controller;

import com.example.iotdevice.Utils.DeviceUtils;
import com.example.iotdevice.model.Device;
import com.example.iotdevice.model.Temperature;
import com.example.iotdevice.service.DeviceService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class DeviceController {

    @Resource
    private DeviceService deviceService;

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    @RequestMapping( value = "/device/{id}/data", method = RequestMethod.PUT)
    public Device addTemp(@PathVariable Integer id, @RequestBody final Set<Integer> temperature){
      Device device =  deviceService.getById(id);
      device.setTemperatures(DeviceUtils.getTemps(id,device,temperature));
      return   deviceService.save(device);
    }

    @RequestMapping( value = "/device/add", method = RequestMethod.POST)
    public Device addDevice( @RequestBody final Device device){
        return   deviceService.save(device);
    }

    @RequestMapping( value = "/device/{id}/filter/{filter}", method = RequestMethod.PUT)
    public Device addFiletr(@PathVariable Integer id,@PathVariable String filter){
        Device device =  deviceService.getById(id);
        device.setFilter(filter);
        return   deviceService.save(device);
    }

    @RequestMapping( value = "/device/{id}", method = RequestMethod.GET)
    public Device getDevice(@PathVariable Integer id){
        return   deviceService.getById(id);
    }

    @RequestMapping( value = "/device/{id}/data", method = RequestMethod.GET)
    public List<Integer> getDeviceByFilter(@PathVariable Integer id){
        return   deviceService.getByFilter(id);
    }
}
