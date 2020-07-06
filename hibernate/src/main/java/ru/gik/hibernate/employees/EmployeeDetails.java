package ru.gik.hibernate.employees;

import javax.persistence.*;

@Entity
@Table(name = "employees_details")
public class EmployeeDetails {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @OneToOne(mappedBy = "details")
    private Employee employee;
}
