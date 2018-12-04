package com.bailian.car.domain.cars.checktable;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCheckItem is a Querydsl query type for CheckItem
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCheckItem extends EntityPathBase<CheckItem> {

    private static final long serialVersionUID = 1569847577L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCheckItem checkItem = new QCheckItem("checkItem");

    public final QCheckParentItem carCheckParentItem;

    public final StringPath cname = createString("cname");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public QCheckItem(String variable) {
        this(CheckItem.class, forVariable(variable), INITS);
    }

    public QCheckItem(Path<? extends CheckItem> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCheckItem(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCheckItem(PathMetadata metadata, PathInits inits) {
        this(CheckItem.class, metadata, inits);
    }

    public QCheckItem(Class<? extends CheckItem> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.carCheckParentItem = inits.isInitialized("carCheckParentItem") ? new QCheckParentItem(forProperty("carCheckParentItem"), inits.get("carCheckParentItem")) : null;
    }

}

