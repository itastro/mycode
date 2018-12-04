package com.bailian.car.domain.iccard;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QIccard is a Querydsl query type for Iccard
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QIccard extends EntityPathBase<Iccard> {

    private static final long serialVersionUID = -367278395L;

    public static final QIccard iccard1 = new QIccard("iccard1");

    public final NumberPath<Integer> cardType = createNumber("cardType", Integer.class);

    public final StringPath driversn = createString("driversn");

    public final NumberPath<Integer> icauthority = createNumber("icauthority", Integer.class);

    public final StringPath iccard = createString("iccard");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public QIccard(String variable) {
        super(Iccard.class, forVariable(variable));
    }

    public QIccard(Path<? extends Iccard> path) {
        super(path.getType(), path.getMetadata());
    }

    public QIccard(PathMetadata metadata) {
        super(Iccard.class, metadata);
    }

}

