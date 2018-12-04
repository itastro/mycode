package com.bailian.car.domain.cars.car;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHistoryLicense is a Querydsl query type for HistoryLicense
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QHistoryLicense extends EntityPathBase<HistoryLicense> {

    private static final long serialVersionUID = -1723288275L;

    public static final QHistoryLicense historyLicense = new QHistoryLicense("historyLicense");

    public final StringPath addPerson = createString("addPerson");

    public final StringPath applyperson = createString("applyperson");

    public final DateTimePath<java.util.Date> applytime = createDateTime("applytime", java.util.Date.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final DateTimePath<java.util.Date> licenseEndTime = createDateTime("licenseEndTime", java.util.Date.class);

    public final StringPath licenseNo = createString("licenseNo");

    public final DateTimePath<java.util.Date> licenseStartTime = createDateTime("licenseStartTime", java.util.Date.class);

    public final DateTimePath<java.util.Date> maketime = createDateTime("maketime", java.util.Date.class);

    public final StringPath remark = createString("remark");

    public final StringPath vSn = createString("vSn");

    public QHistoryLicense(String variable) {
        super(HistoryLicense.class, forVariable(variable));
    }

    public QHistoryLicense(Path<? extends HistoryLicense> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHistoryLicense(PathMetadata metadata) {
        super(HistoryLicense.class, metadata);
    }

}

