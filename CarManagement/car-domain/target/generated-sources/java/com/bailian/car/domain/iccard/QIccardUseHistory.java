package com.bailian.car.domain.iccard;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QIccardUseHistory is a Querydsl query type for IccardUseHistory
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QIccardUseHistory extends EntityPathBase<IccardUseHistory> {

    private static final long serialVersionUID = 134836658L;

    public static final QIccardUseHistory iccardUseHistory = new QIccardUseHistory("iccardUseHistory");

    public final StringPath cariccard = createString("cariccard");

    public final StringPath carSn = createString("carSn");

    public final StringPath drivercard = createString("drivercard");

    public final StringPath driverName = createString("driverName");

    public final StringPath error = createString("error");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath io = createString("io");

    public final DateTimePath<java.util.Date> licenseEndTime = createDateTime("licenseEndTime", java.util.Date.class);

    public final StringPath licenseNo = createString("licenseNo");

    public final DateTimePath<java.util.Date> updateTime = createDateTime("updateTime", java.util.Date.class);

    public QIccardUseHistory(String variable) {
        super(IccardUseHistory.class, forVariable(variable));
    }

    public QIccardUseHistory(Path<? extends IccardUseHistory> path) {
        super(path.getType(), path.getMetadata());
    }

    public QIccardUseHistory(PathMetadata metadata) {
        super(IccardUseHistory.class, metadata);
    }

}

