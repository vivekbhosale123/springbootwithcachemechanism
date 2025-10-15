package com.vdb.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CUSTOMER")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int custId;

    @Size(min = 2,message = "name should contain at least two later")
    private String custName;

    private double custAccountBalance;

    @Range(min = 1000000000,max = 9999999999L,message = "number should be 10 digits")
    private long custContactNumber;

}
