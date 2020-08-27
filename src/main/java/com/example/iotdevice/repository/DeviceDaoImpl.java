package com.example.iotdevice.repository;

import com.example.iotdevice.model.Device;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class DeviceDaoImpl implements DeviceDao{

    @PersistenceContext
    private EntityManager entityManager;
    public Device getByFilter(Integer deviceId, String filter){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Device> query = cb.createQuery(Device.class);
        Root<Device> device = query.from(Device.class);

        Path<String> filetrPath = device.get("filter");

        List<Predicate> predicates = new ArrayList<>();

            predicates.add(cb.like(filetrPath, filter));

        query.select(device)
                .where(cb.or(predicates.toArray(new Predicate[predicates.size()])));

        return entityManager.createQuery(query)
                .getResultList().get(0);

     //  return new Device();
    }
}
