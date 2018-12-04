package com.bailian.car.domain.cars.checktable;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCheckType is a Querydsl query type for CheckType
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCheckType extends EntityPathBase<CheckType> {

    private static final long serialVersionUID = 1570180416L;

    public static final QCheckType checkType = new QCheckType("checkType");

    public final ListPath<CheckParentItem, QCheckParentItem> carCheckParentItems = this.<CheckParentItem, QCheckParentItem>createList("carCheckParentItems", CheckParentItem.class, QCheckParentItem.class, PathInits.DIRECT2);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    public final StringPath url = createString("url");

    public QCheckType(String variable) {
        super(CheckType.class, forVariable(variable));
    }

    public QCheckType(Path<? extends CheckType> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCheckType(PathMetadata metadata) {
        super(CheckType.class, metadata);
    }

}

