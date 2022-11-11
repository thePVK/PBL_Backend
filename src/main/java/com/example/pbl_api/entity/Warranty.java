package com.example.pbl_api.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table
public class Warranty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "time")
    private Date time;

}
