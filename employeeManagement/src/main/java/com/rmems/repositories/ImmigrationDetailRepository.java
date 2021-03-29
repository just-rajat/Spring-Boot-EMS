package com.rmems.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.rmems.entities.ImmigrationDetail;

import java.util.List;

@Transactional(readOnly = true)
public interface ImmigrationDetailRepository extends JpaRepository<ImmigrationDetail, Long> {

    /**
     * Returns the List of ImmigrationDetails for a given EmployeeId.
     *
     * @param employeeId
     * @return
     */
    List<ImmigrationDetail> findAllByEmployeeEmployeeId(long employeeId);

}
