package com.bailian.car.domain.carcheckresult;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSafeCheckResult is a Querydsl query type for SafeCheckResult
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSafeCheckResult extends EntityPathBase<SafeCheckResult> {

    private static final long serialVersionUID = 932011236L;

    public static final QSafeCheckResult safeCheckResult = new QSafeCheckResult("safeCheckResult");

    public final StringPath checkExplanation = createString("checkExplanation");

    public final StringPath checkingExplanation = createString("checkingExplanation");

    public final StringPath confirmExplanation = createString("confirmExplanation");

    public final StringPath item = createString("item");

    public final StringPath request = createString("request");

    public final StringPath status = createString("status");

    public final StringPath uuid = createString("uuid");

    public final StringPath vSn = createString("vSn");

    public QSafeCheckResult(String variable) {
        super(SafeCheckResult.class, forVariable(variable));
    }

    public QSafeCheckResult(Path<? extends SafeCheckResult> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSafeCheckResult(PathMetadata metadata) {
        super(SafeCheckResult.class, metadata);
    }

}

