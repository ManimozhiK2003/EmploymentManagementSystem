package controller;

import model.employment_agreement_model;
import service.employment_agreement_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employment-agreements")
public class employment_agreement_controller {

    @Autowired
    private employment_agreement_service service;

    @PostMapping
    public employment_agreement_model createAgreement(@RequestBody employment_agreement_model agreement) {
        return service.createAgreement(agreement);
    }

    @GetMapping
    public List<employment_agreement_model> getAllAgreements() {
        return service.getAllAgreements();
    }

    @GetMapping("/{id}")
    public ResponseEntity<employment_agreement_model> getAgreementById(@PathVariable Long id) {
        return service.getAgreementById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public employment_agreement_model updateAgreement(@PathVariable Long id, @RequestBody employment_agreement_model updatedAgreement) {
        return service.updateAgreement(id, updatedAgreement);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAgreement(@PathVariable Long id) {
        service.deleteAgreement(id);
        return ResponseEntity.noContent().build();
    }
}
