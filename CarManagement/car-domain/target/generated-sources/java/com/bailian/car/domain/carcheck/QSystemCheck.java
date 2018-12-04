package com.bailian.car.domain.carcheck;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSystemCheck is a Querydsl query type for SystemCheck
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSystemCheck extends EntityPathBase<SystemCheck> {

    private static final long serialVersionUID = 1905888936L;

    public static final QSystemCheck systemCheck = new QSystemCheck("systemCheck");

    public final StringPath checkingPerson = createString("checkingPerson");

    public final DateTimePath<java.util.Date> checkingTime = createDateTime("checkingTime", java.util.Date.class);

    public final StringPath checkPerson = createString("checkPerson");

    public final DateTimePath<java.util.Date> checkTime = createDateTime("checkTime", java.util.Date.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath status = createString("status");

    public final StringPath vSn = createString("vSn");

    public QSystemCheck(String variable) {
        super(SystemCheck.class, forVariable(variable));
    }

    public QSystemCheck(Path<? extends SystemCheck> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSystemCheck(PathMetadata metadata) {
        super(SystemCheck.class, metadata);
    }

}

