package com.hotel.projectHotel.model.repositiry;

import com.hotel.projectHotel.model.entity.Request;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.hotel.projectHotel.prototype.RequestPrototype.getRequest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
class RequestRepositoryTest {

    @Autowired
    RequestRepository requestRepository;

    @Test
    void findById() {
        requestRepository.save(getRequest());
        Request foundRequest = requestRepository.findById(getRequest().getId());
        assertThat(foundRequest).isNotNull();
        assertThat(foundRequest.getId()).isEqualTo(getRequest().getId());
    }
}