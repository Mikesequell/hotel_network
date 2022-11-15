package com.hotel.projectHotel.model.repositiry;

import com.hotel.projectHotel.model.entity.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApartmentRepository extends JpaRepository<Apartment, Integer> {
    List<Apartment> findByHotel_Id(Integer id);
}
