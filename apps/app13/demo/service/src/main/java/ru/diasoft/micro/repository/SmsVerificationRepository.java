package ru.diasoft.micro.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.diasoft.micro.domain.SmsVerificationEntity;

@Repository
public interface SmsVerificationRepository extends JpaRepository<SmsVerificationEntity, Long> {
	Optional<SmsVerificationEntity> findBySecretCodeAndProcessGuidAndStatus(String secretCode, String processGuid, String status);
}
