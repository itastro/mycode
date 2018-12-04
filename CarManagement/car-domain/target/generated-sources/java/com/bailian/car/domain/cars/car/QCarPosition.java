package com.bailian.car.domain.cars.car;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCarPosition is a Querydsl query type for CarPosition
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCarPosition extends EntityPathBase<CarPosition> {

    private static final long serialVersionUID = 663343357L;

    public static final QCarPosition carPosition = new QCarPosition("carPosition");

    public final StringPath AUTHORITY = createString("AUTHORITY");

    public final NumberPath<Double> batteryvoltage = createNumber("batteryvoltage", Double.class);

    public final StringPath carcode = createString("carcode");

    public final DateTimePath<java.util.Date> colltime = createDateTime("colltime", java.util.Date.class);

    public final StringPath iccard = createString("iccard");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath iostatic = createString("iostatic");

    public final NumberPath<Double> latitude = createNumber("latitude", Double.class);

    public final NumberPath<Double> latitude2 = createNumber("latitude2", Double.class);

    public final NumberPath<Double> longitude = createNumber("longitude", Double.class);

    public final NumberPath<Double> longitude2 = createNumber("longitude2", Double.class);

    public final StringPath runStatic = createString("runStatic");

    public final NumberPath<Double> speed = createNumber("speed", Double.class);

    public final NumberPath<Double> towards = createNumber("towards", Double.class);

    public QCarPosition(String variable) {
        super(CarPosition.class, forVariable(variable));
    }

    public QCarPosition(Path<? extends CarPosition> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCarPosition(PathMetadata metadata) {
        super(CarPosition.class, metadata);
    }

}

