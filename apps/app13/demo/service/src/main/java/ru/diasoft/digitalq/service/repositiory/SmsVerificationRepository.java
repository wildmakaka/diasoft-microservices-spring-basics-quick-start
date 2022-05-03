package ru.diasoft.digitalq.service.repositiory;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.diasoft.digitalq.service.domain.SmsVerification;

@Repository
public interface SmsVerificationRepository extends JpaRepository<SmsVerification, Long> {
	Optional<SmsVerification> findBySecretCodeAndProcessGuidAndStatus(String secretCode, String processGuid, String status);
}
