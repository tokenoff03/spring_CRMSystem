package com.example.sprinttask2bitlab.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "appRequest")
public class ApplicationRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Long id;
    @Column(name = "userName")
    String userName;
    @Column(name = "courseName")
    String courseName;
    @Column(name = "commentary")
    String commentary;
    @Column(name = "phone")
    String phone;
    @Column(name = "handled")
    boolean handled;
}
