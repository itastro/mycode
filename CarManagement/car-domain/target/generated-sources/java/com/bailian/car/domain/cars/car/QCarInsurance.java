package com.bailian.car.domain.cars.car;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCarInsurance is a Querydsl query type for CarInsurance
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCarInsurance extends EntityPathBase<CarInsurance> {

    private static final long serialVersionUID = 1749707142L;

    public static final QCarInsurance carInsurance = new QCarInsurance("carInsurance");

    public final StringPath addPerson = createString("addPerson");

    public final DateTimePath<java.util.Date> addtime = createDateTime("addtime", java.util.Date.class);

    public final StringPath applyPerson = createString("applyPerson");

    public final DateTimePath<java.util.Date> applyTime = createDateTime("applyTime", java.util.Date.class);

    public final StringPath brandModeltwo = createString("brandModeltwo");

    public final DateTimePath<java.util.Date> endTime = createDateTime("endTime", java.util.Date.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath insNo = createString("insNo");

    public final NumberPath<Integer> lave = createNumber("lave", Integer.class);

    public final DateTimePath<java.util.Date> makeTime = createDateTime("makeTime", java.util.Date.class);

    public final NumberPath<Integer> numtime = createNumber("numtime", Integer.class);

    public final StringPath remark = createString("remark");

    public final DateTimePath<java.util.Date> startTime = createDateTime("startTime", java.util.Date.class);

    public final StringPath vehicleInspection = createString("vehicleInspection");

    public final StringPath vSn = createString("vSn");

    public QCarInsurance(String variable) {
        super(CarInsurance.class, forVariable(variable));
    }

    public QCarInsurance(Path<? extends CarInsurance> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCarInsurance(PathMetadata metadata) {
        super(CarInsurance.class, metadata);
    }

}

