package com.bailian.car.domain.carcheck;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QBackCheck is a Querydsl query type for BackCheck
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QBackCheck extends EntityPathBase<BackCheck> {

    private static final long serialVersionUID = -850573648L;

    public static final QBackCheck backCheck = new QBackCheck("backCheck");

    public final StringPath backPerson = createString("backPerson");

    public final NumberPath<Integer> fire = createNumber("fire", Integer.class);

    public final StringPath forpeople = createString("forpeople");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final NumberPath<Integer> jack = createNumber("jack", Integer.class);

    public final NumberPath<Integer> keyy = createNumber("keyy", Integer.class);

    public final StringPath odometer = createString("odometer");

    public final DateTimePath<java.util.Date> operate_time = createDateTime("operate_time", java.util.Date.class);

    public final StringPath operator = createString("operator");

    public final StringPath pick_card = createString("pick_card");

    public final StringPath pick_tel = createString("pick_tel");

    public final StringPath pickone = createString("pickone");

    public final StringPath proposer = createString("proposer");

    public final NumberPath<Integer> sparetyre = createNumber("sparetyre", Integer.class);

    public final DateTimePath<java.util.Date> time = createDateTime("time", java.util.Date.class);

    public final StringPath toolisrecycled = createString("toolisrecycled");

    public final NumberPath<Integer> tools = createNumber("tools", Integer.class);

    public final StringPath trans_sn = createString("trans_sn");

    public final StringPath vSn = createString("vSn");

    public final NumberPath<Integer> warningboard = createNumber("warningboard", Integer.class);

    public QBackCheck(String variable) {
        super(BackCheck.class, forVariable(variable));
    }

    public QBackCheck(Path<? extends BackCheck> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBackCheck(PathMetadata metadata) {
        super(BackCheck.class, metadata);
    }

}

