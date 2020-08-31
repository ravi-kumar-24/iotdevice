package com.example.iotdevice.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity(name =  "temperature")
@Table(name = "temperature")
public class Temperature implements Comparable<Temperature> , Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "temperature_id")
    private Integer temperatureId;

    /*@ManyToOne
    private Integer deviceId;*/

    @Column(name = "temperature_value")
    private Integer temperatureValue;

    public Temperature() {
    }

    public Temperature( Integer temperatureValue) {
        this.temperatureValue = temperatureValue;
    }
    public Temperature(Integer temperatureId,  Integer temperatureValue) {
        this.temperatureId = temperatureId;
       // this.deviceId = deviceId;
        this.temperatureValue = temperatureValue;
    }

    public Integer getTemperatureId() {
        return temperatureId;
    }

    public void setTemperatureId(Integer temperatureId) {
        this.temperatureId = temperatureId;
    }

   /*public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }
*/
    public Integer getTemperatureValue() {
        return temperatureValue;
    }

    public void setTemperatureValue(Integer temperatureValue) {
        this.temperatureValue = temperatureValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Temperature that = (Temperature) o;
        return Objects.equals(temperatureValue, that.temperatureValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(temperatureValue);
    }

    @Override
    public int compareTo(Temperature o) {
        int tempDif = this.getTemperatureValue().compareTo(o.getTemperatureValue());
       /* if(tempDif ==0){
            return this.getTemperatureId().compareTo(o.getTemperatureId());
        }*/
        return tempDif;
    }
}
