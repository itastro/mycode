package com.bailian.car.domain.carcheckresult;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHIResult is a Querydsl query type for HIResult
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QHIResult extends EntityPathBase<HIResult> {

    private static final long serialVersionUID = -1604547982L;

    public static final QHIResult hIResult = new QHIResult("hIResult");

    public final StringPath checkExplanation = createString("checkExplanation");

    public final StringPath checkingExplanation = createString("checkingExplanation");

    public final StringPath item = createString("item");

    public final StringPath pitem = createString("pitem");

    public final StringPath status = createString("status");

    public final StringPath uuid = createString("uuid");

    public final StringPath vSn = createString("vSn");

    public QHIResult(String variable) {
        super(HIResult.class, forVariable(variable));
    }

    public QHIResult(Path<? extends HIResult> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHIResult(PathMetadata metadata) {
        super(HIResult.class, metadata);
    }

}

