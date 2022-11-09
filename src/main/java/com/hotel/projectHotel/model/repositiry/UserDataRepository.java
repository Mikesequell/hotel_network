package com.hotel.projectHotel.model.repositiry;

import com.hotel.projectHotel.model.entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDataRepository extends JpaRepository<UserData, Integer> {

}
