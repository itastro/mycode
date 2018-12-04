package com.bailian.car.domain.carcheck;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPickUpCheck is a Querydsl query type for PickUpCheck
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPickUpCheck extends EntityPathBase<PickUpCheck> {

    private static final long serialVersionUID = 970831451L;

    public static final QPickUpCheck pickUpCheck = new QPickUpCheck("pickUpCheck");

    public final StringPath brandModelone = createString("brandModelone");

    public final StringPath engineNumber = createString("engineNumber");

    public final StringPath explanation = createString("explanation");

    public final StringPath facade = createString("facade");

    public final NumberPath<Integer> fire = createNumber("fire", Integer.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath item = createString("item");

    public final NumberPath<Integer> jack = createNumber("jack", Integer.class);

    public final NumberPath<Integer> keyy = createNumber("keyy", Integer.class);

    public final StringPath odometer = createString("odometer");

    public final StringPath pickone = createString("pickone");

    public final StringPath remark = createString("remark");

    public final StringPath send_p = createString("send_p");

    public final NumberPath<Integer> sparetyre = createNumber("sparetyre", Integer.class);

    public final StringPath telephone = createString("telephone");

    public final DateTimePath<java.util.Date> time = createDateTime("time", java.util.Date.class);

    public final NumberPath<Integer> tools = createNumber("tools", Integer.class);

    public final StringPath vin = createString("vin");

    public final StringPath vSn = createString("vSn");

    public final NumberPath<Integer> warningboard = createNumber("warningboard", Integer.class);

    public QPickUpCheck(String variable) {
        super(PickUpCheck.class, forVariable(variable));
    }

    public QPickUpCheck(Path<? extends PickUpCheck> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPickUpCheck(PathMetadata metadata) {
        super(PickUpCheck.class, metadata);
    }

}

