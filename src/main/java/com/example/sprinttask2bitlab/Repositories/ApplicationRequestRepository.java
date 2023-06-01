package com.example.sprinttask2bitlab.Repositories;

import com.example.sprinttask2bitlab.Models.ApplicationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRequestRepository extends JpaRepository<ApplicationRequest, Long> {
}
