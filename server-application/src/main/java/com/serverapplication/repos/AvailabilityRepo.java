package com.serverapplication.repos;

import com.serverapplication.domain.Availability;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvailabilityRepo extends JpaRepository<Availability, Long> {
}
