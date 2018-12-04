package com.bailian.car.domain.cars.checktable;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCheckRequest is a Querydsl query type for CheckRequest
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCheckRequest extends EntityPathBase<CheckRequest> {

    private static final long serialVersionUID = -1590137143L;

    public static final QCheckRequest checkRequest = new QCheckRequest("checkRequest");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath request = createString("request");

    public QCheckRequest(String variable) {
        super(CheckRequest.class, forVariable(variable));
    }

    public QCheckRequest(Path<? extends CheckRequest> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCheckRequest(PathMetadata metadata) {
        super(CheckRequest.class, metadata);
    }

}

