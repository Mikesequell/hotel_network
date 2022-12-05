package com.hotel.projectHotel.model.repositiry;

import com.hotel.projectHotel.model.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<Request, Integer> {
    List<Request> findByStatusId_NameIgnoreCase(String statusName);
    List<Request> findByUserId_Id(Long Id);
    Request findById(Long id);
}
