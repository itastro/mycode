package com.bailian.car.domain.carmaintain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QScreen is a Querydsl query type for Screen
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QScreen extends EntityPathBase<Screen> {

    private static final long serialVersionUID = -634516956L;

    public static final QScreen screen = new QScreen("screen");

    public final StringPath applyPeople = createString("applyPeople");

    public final DateTimePath<java.util.Date> applyTime = createDateTime("applyTime", java.util.Date.class);

    public final StringPath fin_park = createString("fin_park");

    public final DateTimePath<java.util.Date> forecastTime = createDateTime("forecastTime", java.util.Date.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final NumberPath<Integer> mid = createNumber("mid", Integer.class);

    public final StringPath operator = createString("operator");

    public final StringPath status = createString("status");

    public final StringPath vSn = createString("vSn");

    public final StringPath workContent = createString("workContent");

    public QScreen(String variable) {
        super(Screen.class, forVariable(variable));
    }

    public QScreen(Path<? extends Screen> path) {
        super(path.getType(), path.getMetadata());
    }

    public QScreen(PathMetadata metadata) {
        super(Screen.class, metadata);
    }

}

