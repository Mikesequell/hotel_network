package com.hotel.projectHotel.model.repositiry;

import com.hotel.projectHotel.model.entity.Status;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.hotel.projectHotel.prototype.StatusPrototype.getTestStatus;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
class StatusRepositoryTest {

    @Autowired
    StatusRepository statusRepository;

    @Test
    void getByNameLikeIgnoreCase() {
        statusRepository.save(getTestStatus());
        Status foundStatus = statusRepository.getByNameLikeIgnoreCase(getTestStatus().getName());
        assertThat(foundStatus).isNotNull();
        assertThat(foundStatus.getName()).isEqualTo(getTestStatus().getName());
    }
}