package com.bailian.car.domain.carcheckresult;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QEmsAndBomCheckResult is a Querydsl query type for EmsAndBomCheckResult
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QEmsAndBomCheckResult extends EntityPathBase<EmsAndBomCheckResult> {

    private static final long serialVersionUID = -1054227035L;

    public static final QEmsAndBomCheckResult emsAndBomCheckResult = new QEmsAndBomCheckResult("emsAndBomCheckResult");

    public final StringPath bomName = createString("bomName");

    public final StringPath bomNum = createString("bomNum");

    public final StringPath checkExplanation = createString("checkExplanation");

    public final StringPath checkingExplanation = createString("checkingExplanation");

    public final StringPath status = createString("status");

    public final StringPath uuid = createString("uuid");

    public final StringPath vSn = createString("vSn");

    public QEmsAndBomCheckResult(String variable) {
        super(EmsAndBomCheckResult.class, forVariable(variable));
    }

    public QEmsAndBomCheckResult(Path<? extends EmsAndBomCheckResult> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEmsAndBomCheckResult(PathMetadata metadata) {
        super(EmsAndBomCheckResult.class, metadata);
    }

}

