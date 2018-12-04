package com.bailian.car.domain.cars.car;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCarBase is a Querydsl query type for CarBase
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCarBase extends EntityPathBase<CarBase> {

    private static final long serialVersionUID = 629295269L;

    public static final QCarBase carBase = new QCarBase("carBase");

    public final StringPath adminName = createString("adminName");

    public final StringPath backCard = createString("backCard");

    public final StringPath bomurl = createString("bomurl");

    public final StringPath carName = createString("carName");

    public final StringPath circuitName = createString("circuitName");

    public final StringPath circuiturl = createString("circuiturl");

    public final StringPath color = createString("color");

    public final StringPath contactNumber = createString("contactNumber");

    public final StringPath customer = createString("customer");

    public final StringPath engineCapacity = createString("engineCapacity");

    public final StringPath engineType = createString("engineType");

    public final StringPath frontTireP = createString("frontTireP");

    public final StringPath fuelType = createString("fuelType");

    public final StringPath gbts = createString("gbts");

    public final StringPath groupName = createString("groupName");

    public final StringPath iccard = createString("iccard");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final DateTimePath<java.util.Date> makeTime = createDateTime("makeTime", java.util.Date.class);

    public final StringPath oilspecification = createString("oilspecification");

    public final StringPath operator = createString("operator");

    public final StringPath picurl = createString("picurl");

    public final StringPath price = createString("price");

    public final StringPath project_name = createString("project_name");

    public final StringPath project_sn = createString("project_sn");

    public final StringPath projectEngineer = createString("projectEngineer");

    public final StringPath reaTireP = createString("reaTireP");

    public final StringPath remark = createString("remark");

    public final NumberPath<Integer> seats = createNumber("seats", Integer.class);

    public final StringPath tyresize = createString("tyresize");

    public final StringPath vCarType = createString("vCarType");

    public final StringPath vehicleQuality = createString("vehicleQuality");

    public final StringPath vSn = createString("vSn");

    public final StringPath wordName = createString("wordName");

    public final StringPath wordurl = createString("wordurl");

    public QCarBase(String variable) {
        super(CarBase.class, forVariable(variable));
    }

    public QCarBase(Path<? extends CarBase> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCarBase(PathMetadata metadata) {
        super(CarBase.class, metadata);
    }

}

