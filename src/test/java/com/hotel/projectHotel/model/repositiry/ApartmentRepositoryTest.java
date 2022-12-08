package com.hotel.projectHotel.model.repositiry;

import com.hotel.projectHotel.model.entity.Apartment;
import com.hotel.projectHotel.prototype.ApartmentPrototype;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
class ApartmentRepositoryTest {

    @Autowired
    ApartmentRepository apartmentRepository;

    @Test
    void findById() {
        apartmentRepository.saveAndFlush(ApartmentPrototype.getApartments());
        Apartment foundApartment = apartmentRepository.findById(1L);
//        List<Apartment> all = apartmentRepository.findAll();
        assertThat(foundApartment).isNotNull();
        assertThat(foundApartment.getId()).isEqualTo(1L);

    }
}