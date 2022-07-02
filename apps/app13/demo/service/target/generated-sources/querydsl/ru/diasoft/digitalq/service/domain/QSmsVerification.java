package ru.diasoft.digitalq.service.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import ru.diasoft.micro.service.SmsVerification;


/**
 * QSmsVerification is a Querydsl query type for SmsVerification
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSmsVerification extends EntityPathBase<SmsVerification> {

    private static final long serialVersionUID = -920172955L;

    public static final QSmsVerification smsVerification = new QSmsVerification("smsVerification");

    public final StringPath phoneNumber = createString("phoneNumber");

    public final StringPath processGuid = createString("processGuid");

    public final StringPath secretCode = createString("secretCode");

    public final StringPath status = createString("status");

    public final NumberPath<Long> verificationId = createNumber("verificationId", Long.class);

    public QSmsVerification(String variable) {
        super(SmsVerification.class, forVariable(variable));
    }

    public QSmsVerification(Path<? extends SmsVerification> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSmsVerification(PathMetadata metadata) {
        super(SmsVerification.class, metadata);
    }

}

