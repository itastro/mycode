package com.bailian.car.domain.carcheck;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QReviewer is a Querydsl query type for Reviewer
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QReviewer extends EntityPathBase<Reviewer> {

    private static final long serialVersionUID = -192304682L;

    public static final QReviewer reviewer = new QReviewer("reviewer");

    public final StringPath bomCheckingPerson = createString("bomCheckingPerson");

    public final StringPath bomCheckPerson = createString("bomCheckPerson");

    public final StringPath confirmPerson = createString("confirmPerson");

    public final StringPath explanation = createString("explanation");

    public final StringPath hiCheckingPerson = createString("hiCheckingPerson");

    public final StringPath hiCheckPerson = createString("hiCheckPerson");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath reviewerPerson = createString("reviewerPerson");

    public final DateTimePath<java.util.Date> reviewerTime = createDateTime("reviewerTime", java.util.Date.class);

    public final StringPath safeCheckingPerson = createString("safeCheckingPerson");

    public final StringPath safeCheckPerson = createString("safeCheckPerson");

    public final StringPath status = createString("status");

    public final StringPath vSn = createString("vSn");

    public QReviewer(String variable) {
        super(Reviewer.class, forVariable(variable));
    }

    public QReviewer(Path<? extends Reviewer> path) {
        super(path.getType(), path.getMetadata());
    }

    public QReviewer(PathMetadata metadata) {
        super(Reviewer.class, metadata);
    }

}

