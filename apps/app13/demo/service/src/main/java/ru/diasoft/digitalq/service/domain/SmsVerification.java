package ru.diasoft.digitalq.service.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "sms_verification")
public class SmsVerification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sms_verification_verificationid_seq")
	@SequenceGenerator(name = "sms_verification_verificationid_seq", sequenceName = "sms_verification_verificationid_seq")
	@Column(name = "verificationid")
	private Long virificationId;
	
	@Column(name = "processguid")
	private String processGuid;
	
	@Column(name = "phonenumber")
	private String phoneNumber;
	
	@Column(name = "secretcode")
	private String secretCode;
	
	@Column(name = "status")
	private String status;

} // The End of Class;
