package com.example.iotdevice.repository;

import com.example.iotdevice.model.Device;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class DeviceDaoImpl implements DeviceDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Resource
    private DeviceRepository deviceRepository;

    public Device getByFilter(Integer deviceId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Device> query = cb.createQuery(Device.class);
        Root<Device> device = query.from(Device.class);

        Path<String> filetrPath = device.get("filter");

        List<Predicate> predicates = new ArrayList<>();
        Device device1 = deviceRepository.getOne(deviceId);
        predicates.add(cb.like(filetrPath, device1.getFilter()));

        query.select(device)
                .where(cb.or(predicates.toArray(new Predicate[predicates.size()])));
        List lis = entityManager.createQuery(query)
                .getResultList();

        if (!lis.isEmpty()) {
            return (Device) lis.get(0);
        } else {
            return new Device();
        }
    }
}
