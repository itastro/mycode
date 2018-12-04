package com.bailian.car.domain.cars.car;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCarAdmin is a Querydsl query type for CarAdmin
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCarAdmin extends EntityPathBase<CarAdmin> {

    private static final long serialVersionUID = -1967522821L;

    public static final QCarAdmin carAdmin = new QCarAdmin("carAdmin");

    public final StringPath adminName = createString("adminName");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath remark = createString("remark");

    public QCarAdmin(String variable) {
        super(CarAdmin.class, forVariable(variable));
    }

    public QCarAdmin(Path<? extends CarAdmin> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCarAdmin(PathMetadata metadata) {
        super(CarAdmin.class, metadata);
    }

}

