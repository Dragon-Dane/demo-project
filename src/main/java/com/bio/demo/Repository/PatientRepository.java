package com.bio.demo.Repository;

import com.bio.demo.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface PatientRepository extends JpaRepository<Patient, UUID> {

    @Query(value = "select * from tbl_patient p where date(p.prescription_date) >= :startDate and date(p.prescription_date) <= :endDate", nativeQuery = true)
    List<Patient> findbyDateRange(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
