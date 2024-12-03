package com.utcn.scdproiect.courier;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface CourierRepository extends JpaRepository<Courier, Integer>{

    // Get all couriers without pending packages
    @Query(value = "select * from Courier c inner join Package p on p.courier_id where p.status != 'PENDING'",
    nativeQuery = true)
    public List<Courier> getAllCouriersWithoutPendingPackages();

    // Get all managers and delivered number
    @Query(value = "SELECT m.name AS manager_name, COUNT(p.courier_id) AS total_delivered_packages FROM Courier m LEFT JOIN Courier c ON c.courier_id = m.courier_id LEFT JOIN Package p ON (p.courier_id = m.courier_id OR p.courier_id = c.courier_id) AND p.status = 'DELIVERED' WHERE m.courier_id IN (SELECT DISTINCT courier_id FROM Courier) GROUP BY m.name ORDER BY total_delivered_packages ", nativeQuery = true)
    public Map<String, Integer>getAllManagersAndTotalDeliveredPackages();
}
