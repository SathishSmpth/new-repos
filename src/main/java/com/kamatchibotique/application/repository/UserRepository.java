package com.kamatchibotique.application.repository;


import com.kamatchibotique.application.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByPhoneOrEmail(String phone, String email);

    Boolean existsByPhone(String phone);

    Boolean existsByEmail(String email);

    Optional<UserEntity> findByPasswordResetTokenAndPasswordResetTokenExpiresInAfter(String token, LocalDateTime currentTime);
}
