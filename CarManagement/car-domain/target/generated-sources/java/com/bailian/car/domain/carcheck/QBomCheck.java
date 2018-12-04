package com.bailian.car.domain.carcheck;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QBomCheck is a Querydsl query type for BomCheck
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QBomCheck extends EntityPathBase<BomCheck> {

    private static final long serialVersionUID = 1979919097L;

    public static final QBomCheck bomCheck = new QBomCheck("bomCheck");

    public final StringPath applyPerson = createString("applyPerson");

    public final DateTimePath<java.util.Date> applyTime = createDateTime("applyTime", java.util.Date.class);

    public final StringPath checkingPerson = createString("checkingPerson");

    public final DateTimePath<java.util.Date> checkingTime = createDateTime("checkingTime", java.util.Date.class);

    public final StringPath checkPerson = createString("checkPerson");

    public final DateTimePath<java.util.Date> checkTime = createDateTime("checkTime", java.util.Date.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath vSn = createString("vSn");

    public QBomCheck(String variable) {
        super(BomCheck.class, forVariable(variable));
    }

    public QBomCheck(Path<? extends BomCheck> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBomCheck(PathMetadata metadata) {
        super(BomCheck.class, metadata);
    }

}

