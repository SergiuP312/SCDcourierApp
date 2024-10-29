package com.utcn.scdproiect.pkg;

import com.utcn.scdproiect.courier.Courier;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return packageRepository.save(pkg);
    }


    public Package getPackageById(int id) {
        return packageRepository.findById(id).orElseThrow();
    }
}
