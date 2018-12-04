package com.bailian.car.domain.cars.develop;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QDevelopToolsRecord is a Querydsl query type for DevelopToolsRecord
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDevelopToolsRecord extends EntityPathBase<DevelopToolsRecord> {

    private static final long serialVersionUID = -1454029978L;

    public static final QDevelopToolsRecord developToolsRecord = new QDevelopToolsRecord("developToolsRecord");

    public final StringPath applicant = createString("applicant");

    public final DateTimePath<java.util.Date> applyTime = createDateTime("applyTime", java.util.Date.class);

    public final DateTimePath<java.util.Date> demolitionDate = createDateTime("demolitionDate", java.util.Date.class);

    public final StringPath demolitionOperator = createString("demolitionOperator");

    public final DateTimePath<java.util.Date> equippedDate = createDateTime("equippedDate", java.util.Date.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath operator = createString("operator");

    public final DateTimePath<java.util.Date> operatorDate = createDateTime("operatorDate", java.util.Date.class);

    public final StringPath remark = createString("remark");

    public final StringPath toolName = createString("toolName");

    public final StringPath vSn = createString("vSn");

    public QDevelopToolsRecord(String variable) {
        super(DevelopToolsRecord.class, forVariable(variable));
    }

    public QDevelopToolsRecord(Path<? extends DevelopToolsRecord> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDevelopToolsRecord(PathMetadata metadata) {
        super(DevelopToolsRecord.class, metadata);
    }

}

