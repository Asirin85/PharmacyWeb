package com.serverapplication.repos;

import com.serverapplication.domain.Pharmacyt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PharmacytRepo extends JpaRepository<Pharmacyt, Long> {
}
