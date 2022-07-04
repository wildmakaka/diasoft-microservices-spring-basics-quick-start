package ru.diasoft.micro.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "sms_verification")
public class SmsVerificationEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sms_verification_verificationid_seq")
	@SequenceGenerator(name = "sms_verification_verificationid_seq", sequenceName = "sms_verification_verificationid_seq", initialValue = 1, allocationSize = 1)
	@Column(name = "verificationid")
	@EqualsAndHashCode.Exclude
	private Long verificationId;
	
	@Column(name = "processguid")
	private String processGuid;
	
	@Column(name = "phonenumber")
	private String phoneNumber;
	
	@Column(name = "secretcode")
	private String secretCode;
	
	@Column(name = "status")
	private String status;

} // The End of Class;
