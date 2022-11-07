package com.hotel.projectHotel.model.repositiry;

import com.hotel.projectHotel.model.entity.CustomerStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerStatusRepository extends JpaRepository<CustomerStatus, Integer> {
}
