package com.rmems.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.rmems.entities.ClientDetail;

import java.util.List;

@Transactional(readOnly = true)
public interface ClientDetailRepository extends JpaRepository<ClientDetail, Long> {
    /**
     * Returns the list of ClientDetails for a given EmployeeId.
     *
     * @param employeeId
     * @return
     */
    List<ClientDetail> findAllByEmployeeEmployeeIdOrderByCreatedAtDesc(long employeeId);
}
