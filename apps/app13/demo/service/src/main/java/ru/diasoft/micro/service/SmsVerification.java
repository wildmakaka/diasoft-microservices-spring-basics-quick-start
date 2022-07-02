package ru.diasoft.micro.service;

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
@SequenceGenerator(name = "sms_verification_verificationid_seq", allocationSize = 1)
public class SmsVerification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sms_verification_verificationid_seq")
	@Column(name = "verificationid")
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
