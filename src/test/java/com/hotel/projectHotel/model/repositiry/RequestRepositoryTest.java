package com.hotel.projectHotel.model.repositiry;

import com.hotel.projectHotel.model.entity.Request;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static com.hotel.projectHotel.prototype.RequestPrototype.getRequest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
class RequestRepositoryTest {

    @Autowired
    RequestRepository requestRepository;

    @BeforeEach
    private void setUp() {
        requestRepository.save(getRequest());
    }

    @Test
    void findById() {
        Request foundRequest = requestRepository.findById(1L);
        assertThat(foundRequest).isNotNull();
        assertThat(foundRequest.getId()).isEqualTo(1L);
    }

    @Test
    void findByStatusId_NameIgnoreCase() {
        List<Request> listRequestsByStatusName = requestRepository.findByStatusId_NameIgnoreCase("test_status");
        assertThat(listRequestsByStatusName).isNotNull();
        assertThat(listRequestsByStatusName.get(0).getStatusId().getName()).isEqualTo("test_status");
    }

    @Test
    void findByUserId_Id() {
        List<Request> requestsByUserId = requestRepository.findByUserId_Id(1L);
        assertThat(requestsByUserId).isNotNull();
        assertThat(requestsByUserId.get(0).getUserId().getId()).isEqualTo(1L);
    }

}