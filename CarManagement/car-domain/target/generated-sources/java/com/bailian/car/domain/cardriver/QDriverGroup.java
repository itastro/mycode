package com.bailian.car.domain.cardriver;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDriverGroup is a Querydsl query type for DriverGroup
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDriverGroup extends EntityPathBase<DriverGroup> {

    private static final long serialVersionUID = 937625180L;

    public static final QDriverGroup driverGroup = new QDriverGroup("driverGroup");

    public final SetPath<Driver, QDriver> driver = this.<Driver, QDriver>createSet("driver", Driver.class, QDriver.class, PathInits.DIRECT2);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    public final StringPath remark = createString("remark");

    public QDriverGroup(String variable) {
        super(DriverGroup.class, forVariable(variable));
    }

    public QDriverGroup(Path<? extends DriverGroup> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDriverGroup(PathMetadata metadata) {
        super(DriverGroup.class, metadata);
    }

}

