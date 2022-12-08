package com.hotel.projectHotel.model.repositiry;

import com.hotel.projectHotel.model.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.hotel.projectHotel.prototype.UsersPrototype.getUser;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    void findByUsername() {
    userRepository.save(getUser());
    User foundUser = userRepository.findByUsername(getUser().getUsername());
    assertThat(foundUser).isNotNull();
//    assertThat(foundUser.getUsername()).isEqualTo(getUser().getUsername());

    }
}