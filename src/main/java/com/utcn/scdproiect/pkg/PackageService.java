package com.utcn.scdproiect.pkg;


import com.utcn.scdproiect.courier.Courier;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PackageService {

    @Autowired
    private PackageRepository packageRepository;

    //CRUD: READ
    public List<Package> getAllPackages() {
        return packageRepository.findAll();
    }

    @Transactional
    //CRUD: CREATE
    public Package createPackage(Package pkg) {
        return packageRepository.save(pkg);
    }

    //CRUD: UPDATE
    public Package updatePackage(Package pkg) {
        if (packageRepository.existsById(pkg.getPackageId())) {
            return packageRepository.save(pkg);
        }
        else
            return null;
    }

    //CRUD: DELETE
    public void deletePackageById(Integer id) {
        packageRepository.deleteById(id);
    }

    // Get specific package by id
    public Package getPackageById(int id) {
        return packageRepository.findById(id).orElseThrow();
    }

    // Get all packages for a specific courier
    public List<Package> getPackagesForCourier(Courier courier) {
        List<Package> packages = new ArrayList<Package>();
        for (Package pkg : getAllPackages()) {
            if (pkg.getCourier().equals(courier)) {
                packages.add(pkg);
            }
        }
        return packages;
    }
}
