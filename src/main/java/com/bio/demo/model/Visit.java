package com.bio.demo.model;

import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigInteger;
import java.util.Date;

@Data
@Entity
@Table(name = "report_view")
public class Visit {
    @Id
    private Date day;

    @Column
    private BigInteger visits;
}
