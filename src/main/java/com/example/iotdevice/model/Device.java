package com.example.iotdevice.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "device")
public class Device  implements Serializable {

    @Id
    @Column(name = "device_id")
    private Integer deviceId;

    @Column(name = "device_name")
    private String deviceName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="device_id")
    private Set<Temperature> temperatures;


    @Column(name = "filter")
    private String filter;


    public Device() {
    }

    public Device(Integer deviceId, String deviceName, Set<Temperature> temperatures, String filter) {
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.temperatures = temperatures;

        this.filter = filter;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public Set<Temperature> getTemperatures() {
        return temperatures;
    }

    public void setTemperatures(Set<Temperature> temperatures) {
        this.temperatures = temperatures;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Device device = (Device) o;
        return Objects.equals(deviceId, device.deviceId) &&
                Objects.equals(deviceName, device.deviceName) &&
                Objects.equals(temperatures, device.temperatures) &&
                Objects.equals(filter, device.filter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deviceId, deviceName, temperatures, filter);
    }
}

