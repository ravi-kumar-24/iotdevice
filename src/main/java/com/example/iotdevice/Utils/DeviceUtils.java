package com.example.iotdevice.Utils;

import com.example.iotdevice.model.Device;
import com.example.iotdevice.model.Temperature;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class DeviceUtils {

   public static Set<Temperature>  getTemps(Integer id, Device deivce, Set<Integer> temIntegers){
        Set<Temperature> temperatures = new HashSet<>();
       temperatures.addAll(deivce.getTemperatures());
       deivce.setDeviceId(id);
       for (Integer t:temIntegers) {
            temperatures.add(new Temperature(t));
        }
        return temperatures;
    }
}
