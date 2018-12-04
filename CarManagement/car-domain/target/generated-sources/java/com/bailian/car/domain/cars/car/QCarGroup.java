package com.bailian.car.domain.cars.car;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCarGroup is a Querydsl query type for CarGroup
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCarGroup extends EntityPathBase<CarGroup> {

    private static final long serialVersionUID = -1961562325L;

    public static final QCarGroup carGroup = new QCarGroup("carGroup");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    public final StringPath remark = createString("remark");

    public QCarGroup(String variable) {
        super(CarGroup.class, forVariable(variable));
    }

    public QCarGroup(Path<? extends CarGroup> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCarGroup(PathMetadata metadata) {
        super(CarGroup.class, metadata);
    }

}

