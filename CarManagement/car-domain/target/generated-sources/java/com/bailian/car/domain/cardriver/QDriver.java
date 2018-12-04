package com.bailian.car.domain.cardriver;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDriver is a Querydsl query type for Driver
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDriver extends EntityPathBase<Driver> {

    private static final long serialVersionUID = 1181758947L;

    public static final QDriver driver = new QDriver("driver");

    public final DateTimePath<java.util.Date> allowEndTime = createDateTime("allowEndTime", java.util.Date.class);

    public final DateTimePath<java.util.Date> allowStartTime = createDateTime("allowStartTime", java.util.Date.class);

    public final StringPath allowType = createString("allowType");

    public final StringPath employeeCard = createString("employeeCard");

    public final SetPath<DriverGroup, QDriverGroup> groups = this.<DriverGroup, QDriverGroup>createSet("groups", DriverGroup.class, QDriverGroup.class, PathInits.DIRECT2);

    public final StringPath iccard = createString("iccard");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath isallow = createString("isallow");

    public final StringPath name = createString("name");

    public final StringPath remark = createString("remark");

    public final StringPath telephone = createString("telephone");

    public QDriver(String variable) {
        super(Driver.class, forVariable(variable));
    }

    public QDriver(Path<? extends Driver> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDriver(PathMetadata metadata) {
        super(Driver.class, metadata);
    }

}

