package ru.diasoft.micro.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSmsVerificationEntity is a Querydsl query type for SmsVerificationEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSmsVerificationEntity extends EntityPathBase<SmsVerificationEntity> {

    private static final long serialVersionUID = -113235702L;

    public static final QSmsVerificationEntity smsVerificationEntity = new QSmsVerificationEntity("smsVerificationEntity");

    public final StringPath phoneNumber = createString("phoneNumber");

    public final StringPath processGuid = createString("processGuid");

    public final StringPath secretCode = createString("secretCode");

    public final StringPath status = createString("status");

    public final NumberPath<Long> verificationId = createNumber("verificationId", Long.class);

    public QSmsVerificationEntity(String variable) {
        super(SmsVerificationEntity.class, forVariable(variable));
    }

    public QSmsVerificationEntity(Path<? extends SmsVerificationEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSmsVerificationEntity(PathMetadata metadata) {
        super(SmsVerificationEntity.class, metadata);
    }

}

