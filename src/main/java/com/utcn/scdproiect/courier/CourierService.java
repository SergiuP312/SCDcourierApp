package com.utcn.scdproiect.courier;

import com.utcn.scdproiect.pkg.PackageRepository;
import jakarta.transaction.Transactional;
import org.hibernate.annotations.NamedNativeQuery;
import org.hibernate.annotations.NamedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.lang.annotation.Native;
import java.util.List;
import java.util.Map;

@Service
public class CourierService {

    @Autowired
    private CourierRepository courierRepository;

    //CRUD: READ
    public List<Courier> getAllCouriers() {
        return courierRepository.findAll();
    }

    @Transactional
    //CRUD: CREATE
    public Courier createCourier(Courier courier) {
        return courierRepository.save(courier);
    }

    //CRUD: UPDATE
    public Courier updateCourier(Courier courier) {
        if(courierRepository.existsById(courier.getCourier_id())) {
            return courierRepository.save(courier);
        }
        else
            return null;
    }

    //CRUD: DELETE
    public void deleteCourier(Integer id) {
        courierRepository.deleteById(id);
    }

    // Get all courier by id
    public Courier getCourierById(int courierId) {
        return courierRepository.findById(courierId).orElseThrow();
    }

    public List<Courier> getAllCouriersWithoutPendingPackages() {
        return courierRepository.getAllCouriersWithoutPendingPackages();
    }

    public Map<String, Integer> getAllManagersAndTotalNumberOfPackages() {
        return courierRepository.getAllManagersAndTotalDeliveredPackages();
    }

}
