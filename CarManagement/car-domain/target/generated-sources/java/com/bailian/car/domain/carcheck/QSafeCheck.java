package com.bailian.car.domain.carcheck;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSafeCheck is a Querydsl query type for SafeCheck
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSafeCheck extends EntityPathBase<SafeCheck> {

    private static final long serialVersionUID = 978207690L;

    public static final QSafeCheck safeCheck = new QSafeCheck("safeCheck");

    public final StringPath checkingPerson = createString("checkingPerson");

    public final DateTimePath<java.util.Date> checkingTime = createDateTime("checkingTime", java.util.Date.class);

    public final StringPath checkPerson = createString("checkPerson");

    public final DateTimePath<java.util.Date> checkTime = createDateTime("checkTime", java.util.Date.class);

    public final StringPath confirmPerson = createString("confirmPerson");

    public final DateTimePath<java.util.Date> confirmTime = createDateTime("confirmTime", java.util.Date.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath vSn = createString("vSn");

    public QSafeCheck(String variable) {
        super(SafeCheck.class, forVariable(variable));
    }

    public QSafeCheck(Path<? extends SafeCheck> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSafeCheck(PathMetadata metadata) {
        super(SafeCheck.class, metadata);
    }

}

