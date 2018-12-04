package com.bailian.car.domain.cardriver;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QInAndOut is a Querydsl query type for InAndOut
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QInAndOut extends EntityPathBase<InAndOut> {

    private static final long serialVersionUID = 1515437687L;

    public static final QInAndOut inAndOut = new QInAndOut("inAndOut");

    public final StringPath driverCardId = createString("driverCardId");

    public final StringPath driverName = createString("driverName");

    public final DateTimePath<java.util.Date> endTime = createDateTime("endTime", java.util.Date.class);

    public final StringPath errorString = createString("errorString");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath insNo = createString("insNo");

    public final StringPath io = createString("io");

    public final StringPath isallow = createString("isallow");

    public final DateTimePath<java.util.Date> licenseEndTime = createDateTime("licenseEndTime", java.util.Date.class);

    public final StringPath LicenseNo = createString("LicenseNo");

    public final DateTimePath<java.util.Date> updateTime = createDateTime("updateTime", java.util.Date.class);

    public final StringPath vSn = createString("vSn");

    public QInAndOut(String variable) {
        super(InAndOut.class, forVariable(variable));
    }

    public QInAndOut(Path<? extends InAndOut> path) {
        super(path.getType(), path.getMetadata());
    }

    public QInAndOut(PathMetadata metadata) {
        super(InAndOut.class, metadata);
    }

}

