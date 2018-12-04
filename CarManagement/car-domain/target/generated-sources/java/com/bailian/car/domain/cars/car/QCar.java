package com.bailian.car.domain.cars.car;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCar is a Querydsl query type for Car
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCar extends EntityPathBase<Car> {

    private static final long serialVersionUID = 162908084L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCar car = new QCar("car");

    public final StringPath adminName = createString("adminName");

    public final StringPath backCard = createString("backCard");

    public final DateTimePath<java.util.Date> backcheckSubmitTime = createDateTime("backcheckSubmitTime", java.util.Date.class);

    public final DateTimePath<java.util.Date> backchecktime = createDateTime("backchecktime", java.util.Date.class);

    public final StringPath backStatus = createString("backStatus");

    public final NumberPath<Double> batteryvoltage = createNumber("batteryvoltage", Double.class);

    public final StringPath bomurl = createString("bomurl");

    public final StringPath brandModelone = createString("brandModelone");

    public final StringPath brandModeltwo = createString("brandModeltwo");

    public final StringPath car_status = createString("car_status");

    public final StringPath carName = createString("carName");

    public final StringPath checks_status = createString("checks_status");

    public final StringPath checkStaionType = createString("checkStaionType");

    public final StringPath circuitName = createString("circuitName");

    public final StringPath circuiturl = createString("circuiturl");

    public final StringPath color = createString("color");

    public final StringPath contactNumber = createString("contactNumber");

    public final StringPath customer = createString("customer");

    public final DateTimePath<java.util.Date> dAllowEndTm = createDateTime("dAllowEndTm", java.util.Date.class);

    public final DateTimePath<java.util.Date> dAllowStartTm = createDateTime("dAllowStartTm", java.util.Date.class);

    public final StringPath driverName = createString("driverName");

    public final DateTimePath<java.util.Date> endTime = createDateTime("endTime", java.util.Date.class);

    public final StringPath engineCapacity = createString("engineCapacity");

    public final StringPath engineNumber = createString("engineNumber");

    public final StringPath engineType = createString("engineType");

    public final StringPath explanation = createString("explanation");

    public final DateTimePath<java.util.Date> fromtime = createDateTime("fromtime", java.util.Date.class);

    public final StringPath frontTireP = createString("frontTireP");

    public final StringPath fsuelType = createString("fsuelType");

    public final StringPath gbts = createString("gbts");

    public final StringPath gpsSN = createString("gpsSN");

    public final StringPath groupName = createString("groupName");

    public final StringPath hiCheck = createString("hiCheck");

    public final StringPath iccard = createString("iccard");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath insNo = createString("insNo");

    public final StringPath insremark = createString("insremark");

    public final StringPath isAllow = createString("isAllow");

    public final StringPath istatus = createString("istatus");

    public final DateTimePath<java.util.Date> lastTime = createDateTime("lastTime", java.util.Date.class);

    public final NumberPath<Double> latitude = createNumber("latitude", Double.class);

    public final DateTimePath<java.util.Date> licenseEndTime = createDateTime("licenseEndTime", java.util.Date.class);

    public final StringPath licenseNo = createString("licenseNo");

    public final DateTimePath<java.util.Date> licenseStartTime = createDateTime("licenseStartTime", java.util.Date.class);

    public final StringPath licremark = createString("licremark");

    public final StringPath loadData = createString("loadData");

    public final StringPath loadMethod = createString("loadMethod");

    public final NumberPath<Double> longitude = createNumber("longitude", Double.class);

    public final DateTimePath<java.util.Date> makeTime = createDateTime("makeTime", java.util.Date.class);

    public final StringPath oilspecification = createString("oilspecification");

    public final StringPath picurl = createString("picurl");

    public final StringPath price = createString("price");

    public final QProject project;

    public final StringPath projectEngineer = createString("projectEngineer");

    public final StringPath reaTireP = createString("reaTireP");

    public final StringPath remark = createString("remark");

    public final StringPath rstatus = createString("rstatus");

    public final StringPath runStatic = createString("runStatic");

    public final NumberPath<Integer> runsumtime = createNumber("runsumtime", Integer.class);

    public final StringPath safeCheck = createString("safeCheck");

    public final NumberPath<Integer> seats = createNumber("seats", Integer.class);

    public final NumberPath<Double> speed = createNumber("speed", Double.class);

    public final DateTimePath<java.util.Date> startTime = createDateTime("startTime", java.util.Date.class);

    public final NumberPath<Double> towards = createNumber("towards", Double.class);

    public final StringPath tyresize = createString("tyresize");

    public final DateTimePath<java.util.Date> upcheckSubmitTime = createDateTime("upcheckSubmitTime", java.util.Date.class);

    public final DateTimePath<java.util.Date> upcheckTime = createDateTime("upcheckTime", java.util.Date.class);

    public final StringPath vCarType = createString("vCarType");

    public final StringPath vehicleInspection = createString("vehicleInspection");

    public final StringPath vehicleQuality = createString("vehicleQuality");

    public final StringPath vin = createString("vin");

    public final StringPath vSn = createString("vSn");

    public final StringPath warn = createString("warn");

    public final StringPath wordName = createString("wordName");

    public final StringPath wordurl = createString("wordurl");

    public QCar(String variable) {
        this(Car.class, forVariable(variable), INITS);
    }

    public QCar(Path<? extends Car> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCar(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCar(PathMetadata metadata, PathInits inits) {
        this(Car.class, metadata, inits);
    }

    public QCar(Class<? extends Car> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.project = inits.isInitialized("project") ? new QProject(forProperty("project")) : null;
    }

}

