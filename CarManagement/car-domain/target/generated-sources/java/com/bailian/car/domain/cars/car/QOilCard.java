package com.bailian.car.domain.cars.car;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QOilCard is a Querydsl query type for OilCard
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QOilCard extends EntityPathBase<OilCard> {

    private static final long serialVersionUID = -1382040606L;

    public static final QOilCard oilCard = new QOilCard("oilCard");

    public final NumberPath<Double> expense = createNumber("expense", Double.class);

    public final StringPath gas = createString("gas");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final DateTimePath<java.util.Date> importTime = createDateTime("importTime", java.util.Date.class);

    public final StringPath L = createString("L");

    public final StringPath l = createString("l");

    public final StringPath mm = createString("mm");

    public final StringPath oilCardNum = createString("oilCardNum");

    public final StringPath operator = createString("operator");

    public final NumberPath<Double> price = createNumber("price", Double.class);

    public final StringPath projectSn = createString("projectSn");

    public final StringPath remark = createString("remark");

    public final DateTimePath<java.util.Date> time = createDateTime("time", java.util.Date.class);

    public final StringPath type = createString("type");

    public final StringPath vSn = createString("vSn");

    public QOilCard(String variable) {
        super(OilCard.class, forVariable(variable));
    }

    public QOilCard(Path<? extends OilCard> path) {
        super(path.getType(), path.getMetadata());
    }

    public QOilCard(PathMetadata metadata) {
        super(OilCard.class, metadata);
    }

}

