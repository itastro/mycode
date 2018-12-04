package com.bailian.car.domain.cargps;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCarGps is a Querydsl query type for CarGps
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCarGps extends EntityPathBase<CarGps> {

    private static final long serialVersionUID = -1709480667L;

    public static final QCarGps carGps = new QCarGps("carGps");

    public final StringPath gpsSn = createString("gpsSn");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath vSn = createString("vSn");

    public QCarGps(String variable) {
        super(CarGps.class, forVariable(variable));
    }

    public QCarGps(Path<? extends CarGps> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCarGps(PathMetadata metadata) {
        super(CarGps.class, metadata);
    }

}

