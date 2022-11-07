package com.hotel.projectHotel.model.repositiry;

import com.hotel.projectHotel.model.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> {
    
}
