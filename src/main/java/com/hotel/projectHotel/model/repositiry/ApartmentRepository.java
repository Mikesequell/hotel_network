package com.hotel.projectHotel.model.repositiry;

import com.hotel.projectHotel.model.entity.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApartmentRepository extends JpaRepository<Apartment, Integer> {

}
