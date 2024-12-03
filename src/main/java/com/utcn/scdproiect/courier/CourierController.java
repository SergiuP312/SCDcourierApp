package com.utcn.scdproiect.courier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/courier")
@CrossOrigin
public class CourierController {

    @Autowired
    private CourierService courierService;

    @PostMapping
    public Courier createCourier(@RequestBody Courier courier) {
        return courierService.createCourier(courier);
    }

    @GetMapping
    public List<Courier> getAllCouriers() {
        return courierService.getAllCouriers();
    }

    @PostMapping("/update")
    public Courier updateCourier(@RequestBody Courier courier) {
        return courierService.updateCourier(courier);
    }

    @DeleteMapping
    public void deleteCourier(Integer id) {
        courierService.deleteCourier(id);
    }

    @RequestMapping("/getById")
    public Courier getCourier(@RequestParam Integer id) {
        return courierService.getCourierById(id);
    }

    @RequestMapping("/getAllCouriersNoPending")
    public List<Courier> getAllCouriersNoPending() {
        return courierService.getAllCouriersWithoutPendingPackages();
    }

    @RequestMapping("/getAllManagersAndDeliveredPackages")
    public Map<String, Integer> getAllManagersAndDeliveredPackages() {
        return courierService.getAllManagersAndTotalNumberOfPackages();
    }

}
