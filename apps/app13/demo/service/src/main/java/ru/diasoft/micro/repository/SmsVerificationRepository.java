package ru.diasoft.micro.repository;

import java.util.Optional;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ru.diasoft.micro.domain.SmsVerificationEntity;

@Repository
public interface SmsVerificationRepository extends JpaRepository<SmsVerificationEntity, Long> {
	Optional<SmsVerificationEntity> findBySecretCodeAndProcessGuid(String secretCode, String processGuid);

	@Transactional
	@Modifying
	@Query("update SmsVerificationEntity v set status = ?1 where processguid = ?2")
	int updateStatusByProcessGuid(String status, String processGuid);

}
