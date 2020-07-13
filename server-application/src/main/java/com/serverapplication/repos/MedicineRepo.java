package com.serverapplication.repos;

import com.serverapplication.domain.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepo extends JpaRepository<Medicine, Long> {
}
