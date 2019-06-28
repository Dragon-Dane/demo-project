package com.bio.demo.Repository;

import com.bio.demo.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface PatientRepository extends JpaRepository<Patient, UUID> {

    List<Patient> findAllByPrescriptionDateBetween(Date startDate, Date endDate);
}
