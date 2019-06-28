package com.bio.demo.Repository;

import com.bio.demo.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface ReportRepository extends JpaRepository<Visit, Date> {


}
