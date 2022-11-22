package com.hotel.projectHotel.model.repositiry;

import com.hotel.projectHotel.model.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer> {
    Status getByNameLikeIgnoreCase(String status);
}
