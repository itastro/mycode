package com.bailian.car.domain.carcheck;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QClacyLindersss is a Querydsl query type for ClacyLindersss
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QClacyLindersss extends EntityPathBase<ClacyLindersss> {

    private static final long serialVersionUID = -1265141418L;

    public static final QClacyLindersss clacyLindersss = new QClacyLindersss("clacyLindersss");

    public final NumberPath<Double> actual_p = createNumber("actual_p", Double.class);

    public final NumberPath<Double> cylinder_p = createNumber("cylinder_p", Double.class);

    public final NumberPath<Double> four_p = createNumber("four_p", Double.class);

    public final NumberPath<Double> fuel_p = createNumber("fuel_p", Double.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final NumberPath<Double> one_p = createNumber("one_p", Double.class);

    public final NumberPath<Double> three_p = createNumber("three_p", Double.class);

    public final NumberPath<Double> two_p = createNumber("two_p", Double.class);

    public final StringPath vSn = createString("vSn");

    public QClacyLindersss(String variable) {
        super(ClacyLindersss.class, forVariable(variable));
    }

    public QClacyLindersss(Path<? extends ClacyLindersss> path) {
        super(path.getType(), path.getMetadata());
    }

    public QClacyLindersss(PathMetadata metadata) {
        super(ClacyLindersss.class, metadata);
    }

}

