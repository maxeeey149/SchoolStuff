package com.Maxeeey.Database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Maxeeey.TODOListElements.NormalTODOListElement;

@Repository
public interface TODOListRepo extends JpaRepository<NormalTODOListElement, Long> {
    // You can define custom query methods here if needed
}

