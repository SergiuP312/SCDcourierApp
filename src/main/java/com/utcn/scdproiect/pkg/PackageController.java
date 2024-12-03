package com.utcn.scdproiect.pkg;

import com.utcn.scdproiect.courier.Courier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/package")
@CrossOrigin
public class PackageController {

    @Autowired
    private PackageService packageService;

    @PostMapping
    public Package createPackage(@RequestBody Package pkg) {
        return packageService.createPackage(pkg);
    }

    @GetMapping
    public List<Package> getAllPackages() {
        return packageService.getAllPackages();
    }

    @PostMapping("/update")
    public Package updatePackage(@RequestBody Package pkg) {
        return packageService.updatePackage(pkg);
    }

    @DeleteMapping
    public void deletePackage(@RequestParam Integer id) {
        packageService.deletePackageById(id);
    }

    @RequestMapping("/getById")
    public Package getPackageById(@RequestParam int id) {
        return packageService.getPackageById(id);
    }

    @RequestMapping("/getForCourier")
    public List<Package> getPackagesForCourier(@RequestBody Courier courier) {
        return packageService.getPackagesForCourier(courier);
    }
}
