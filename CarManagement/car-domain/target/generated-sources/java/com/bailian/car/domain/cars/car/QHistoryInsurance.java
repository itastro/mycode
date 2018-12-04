package com.bailian.car.domain.cars.car;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHistoryInsurance is a Querydsl query type for HistoryInsurance
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QHistoryInsurance extends EntityPathBase<HistoryInsurance> {

    private static final long serialVersionUID = 510282950L;

    public static final QHistoryInsurance historyInsurance = new QHistoryInsurance("historyInsurance");

    public final StringPath addPerson = createString("addPerson");

    public final DateTimePath<java.util.Date> addtime = createDateTime("addtime", java.util.Date.class);

    public final StringPath applyPerson = createString("applyPerson");

    public final DateTimePath<java.util.Date> applyTime = createDateTime("applyTime", java.util.Date.class);

    public final StringPath brandModeltwo = createString("brandModeltwo");

    public final DateTimePath<java.util.Date> endTime = createDateTime("endTime", java.util.Date.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath insNo = createString("insNo");

    public final DateTimePath<java.util.Date> makeTime = createDateTime("makeTime", java.util.Date.class);

    public final NumberPath<Integer> numtime = createNumber("numtime", Integer.class);

    public final StringPath remark = createString("remark");

    public final DateTimePath<java.util.Date> startTime = createDateTime("startTime", java.util.Date.class);

    public final StringPath vehicleInspection = createString("vehicleInspection");

    public final StringPath vSn = createString("vSn");

    public QHistoryInsurance(String variable) {
        super(HistoryInsurance.class, forVariable(variable));
    }

    public QHistoryInsurance(Path<? extends HistoryInsurance> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHistoryInsurance(PathMetadata metadata) {
        super(HistoryInsurance.class, metadata);
    }

}

