package com.bailian.car.domain.cars.car;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCarLicense is a Querydsl query type for CarLicense
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCarLicense extends EntityPathBase<CarLicense> {

    private static final long serialVersionUID = 302580205L;

    public static final QCarLicense carLicense = new QCarLicense("carLicense");

    public final StringPath addPerson = createString("addPerson");

    public final StringPath applyperson = createString("applyperson");

    public final DateTimePath<java.util.Date> applytime = createDateTime("applytime", java.util.Date.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final DateTimePath<java.util.Date> licenseEndTime = createDateTime("licenseEndTime", java.util.Date.class);

    public final StringPath licenseNo = createString("licenseNo");

    public final DateTimePath<java.util.Date> licenseStartTime = createDateTime("licenseStartTime", java.util.Date.class);

    public final NumberPath<Integer> llave = createNumber("llave", Integer.class);

    public final DateTimePath<java.util.Date> maketime = createDateTime("maketime", java.util.Date.class);

    public final StringPath remark = createString("remark");

    public final StringPath vehicleInspection = createString("vehicleInspection");

    public final StringPath vSn = createString("vSn");

    public QCarLicense(String variable) {
        super(CarLicense.class, forVariable(variable));
    }

    public QCarLicense(Path<? extends CarLicense> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCarLicense(PathMetadata metadata) {
        super(CarLicense.class, metadata);
    }

}

