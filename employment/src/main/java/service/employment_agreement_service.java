package service;

import model.employment_agreement_model;
import repository.employment_agreement_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class employment_agreement_service {

    @Autowired
    private employment_agreement_repository repository;

    public employment_agreement_model createAgreement(employment_agreement_model agreement) {
        return repository.save(agreement);
    }

    public List<employment_agreement_model> getAllAgreements() {
        return repository.findAll();
    }

    public Optional<employment_agreement_model> getAgreementById(Long id) {
        return repository.findById(id);
    }

    public employment_agreement_model updateAgreement(Long id, employment_agreement_model updatedAgreement) {
        return repository.findById(id).map(existingAgreement -> {
            existingAgreement.setEmployeeName(updatedAgreement.getEmployeeName());
            existingAgreement.setRole(updatedAgreement.getRole());
            existingAgreement.setStartDate(updatedAgreement.getStartDate());
            existingAgreement.setEndDate(updatedAgreement.getEndDate());
            existingAgreement.setSalary(updatedAgreement.getSalary());
            existingAgreement.setTerms(updatedAgreement.getTerms());
            return repository.save(existingAgreement);
        }).orElseThrow(() -> new RuntimeException("Agreement not found with id " + id));
    }

    public void deleteAgreement(Long id) {
        repository.deleteById(id);
    }
}
