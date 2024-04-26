package com.onesell.user.user.persistence;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    boolean existsByUserId(@Param("userId") String userId);

    Optional<UserEntity> findByUserId(@Param("userId") String userId);
}
