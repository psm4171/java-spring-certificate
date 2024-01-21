package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.entity.Resident;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResidentRepository extends JpaRepository<Resident, Long> {

    Optional <Resident> findByResidentSerialNumber(Long residentSerialNumber);

  //  Optional <Resident> findByEmail(String email);

}
