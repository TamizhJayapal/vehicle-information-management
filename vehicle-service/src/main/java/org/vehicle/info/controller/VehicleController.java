package org.vehicle.info.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.vehicle.info.model.Vehicle;
import org.vehicle.info.service.VehicleService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class VehicleController {
    @Autowired
    private VehicleService service;

    @CrossOrigin("*")
    @PostMapping("/add-vehicle")
    public ResponseEntity<HttpStatus> addVehicle(@RequestBody Vehicle vehicle) {
        try{
            service.saveVehicle(vehicle);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @CrossOrigin("*")
    @PutMapping("/update-vehicle/{id}")
    public ResponseEntity<HttpStatus> updateVehicle(@RequestBody Vehicle vehicle, @PathVariable long id) {
        try{
            service.updateVehicle(vehicle, id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @CrossOrigin("*")
    @GetMapping("/get-all-vehicle")
    public ResponseEntity<List<Vehicle>> getAllVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        try {
            vehicles = service.getAllVehicle();
            return ResponseEntity.ok(vehicles);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @CrossOrigin("*")
    @GetMapping("/get-vehicle/{id}")
    public ResponseEntity<Optional<Vehicle>> getVehicle(@PathVariable long id) {
        try {
            Optional<Vehicle> vehicle = service.getVehicle(id);
            return ResponseEntity.ok(vehicle);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @CrossOrigin("*")
    @DeleteMapping("/delete-vehicle/{id}")
    public ResponseEntity<HttpStatus> deleteVehicle(@PathVariable long id) {
        try {
            service.deleteVehicle(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
