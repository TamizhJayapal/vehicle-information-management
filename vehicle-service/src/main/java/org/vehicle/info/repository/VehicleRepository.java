package org.vehicle.info.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vehicle.info.model.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
