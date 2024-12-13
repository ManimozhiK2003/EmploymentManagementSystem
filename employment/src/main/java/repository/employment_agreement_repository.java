package repository;

import model.employment_agreement_model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface employment_agreement_repository extends JpaRepository<employment_agreement_model, Long> {
}
