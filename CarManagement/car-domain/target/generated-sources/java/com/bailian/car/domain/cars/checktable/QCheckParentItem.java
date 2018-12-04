package com.bailian.car.domain.cars.checktable;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCheckParentItem is a Querydsl query type for CheckParentItem
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCheckParentItem extends EntityPathBase<CheckParentItem> {

    private static final long serialVersionUID = 1431630947L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCheckParentItem checkParentItem = new QCheckParentItem("checkParentItem");

    public final ListPath<CheckItem, QCheckItem> CarCheckItems = this.<CheckItem, QCheckItem>createList("CarCheckItems", CheckItem.class, QCheckItem.class, PathInits.DIRECT2);

    public final QCheckType carCheckName;

    public final QCheckRequest carCheckRequest;

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath pname = createString("pname");

    public QCheckParentItem(String variable) {
        this(CheckParentItem.class, forVariable(variable), INITS);
    }

    public QCheckParentItem(Path<? extends CheckParentItem> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCheckParentItem(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCheckParentItem(PathMetadata metadata, PathInits inits) {
        this(CheckParentItem.class, metadata, inits);
    }

    public QCheckParentItem(Class<? extends CheckParentItem> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.carCheckName = inits.isInitialized("carCheckName") ? new QCheckType(forProperty("carCheckName")) : null;
        this.carCheckRequest = inits.isInitialized("carCheckRequest") ? new QCheckRequest(forProperty("carCheckRequest")) : null;
    }

}

