package com.hotel.projectHotel.model.repositiry;

import com.hotel.projectHotel.model.entity.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApartmentRepository extends JpaRepository<Apartment, Integer> {
    List<Apartment> findByHotelIdId(Integer id);

    List<Apartment> findByHotelId_IdAndStatusId_NameIgnoreCase(Integer id, String statusName);

    List<Apartment> findByHotelId_IdAndComfortableRankAndSleepingPlacesAndStatusId_NameIgnoreCase(
            Integer id, Integer comfortableRank, Integer sleepingPlaces, String statusName
    );

    List<Apartment> findByHotelId_IdAndComfortableRankAndSleepingPlacesAndStatusId_NameIgnoreCaseNotLike(
            Integer id, Integer comfortableRank, Integer sleepingPlaces, String statusName
    );
//    List<Apartment> findByStatusId_Name(String name);
}
