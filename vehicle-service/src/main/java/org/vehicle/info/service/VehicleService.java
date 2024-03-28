package org.vehicle.info.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vehicle.info.model.Vehicle;
import org.vehicle.info.repository.VehicleRepository;

import java.util.List;
import java.util.Optional;


@Service
public class VehicleService {

    @Autowired
    private VehicleRepository repository;

    public void saveVehicle(Vehicle vehicle) throws Exception{
        repository.save(vehicle);
    }

    public List<Vehicle> getAllVehicle() {
        return repository.findAll();
    }

    public Optional<Vehicle> getVehicle(long id) {
        return repository.findById(id);
    }

    public void deleteVehicle(long id) {
        repository.deleteById(id);
    }

    public void updateVehicle(Vehicle vehicle, long id) {
        Vehicle vehicle1 = vehicle;
        vehicle1.setId(id);
        repository.save(vehicle1);
    }
}
