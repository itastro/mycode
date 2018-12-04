package com.bailian.car.domain.carmaintain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCarMaintain is a Querydsl query type for CarMaintain
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCarMaintain extends EntityPathBase<CarMaintain> {

    private static final long serialVersionUID = -694186297L;

    public static final QCarMaintain carMaintain = new QCarMaintain("carMaintain");

    public final StringPath applyPeople = createString("applyPeople");

    public final StringPath applyRemark = createString("applyRemark");

    public final StringPath applyTEL = createString("applyTEL");

    public final DateTimePath<java.util.Date> applytime = createDateTime("applytime", java.util.Date.class);

    public final StringPath fin_park = createString("fin_park");

    public final DateTimePath<java.util.Date> forecastTime = createDateTime("forecastTime", java.util.Date.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath item = createString("item");

    public final StringPath operator = createString("operator");

    public final StringPath operatorTEL = createString("operatorTEL");

    public final StringPath remark = createString("remark");

    public final StringPath send_park = createString("send_park");

    public final DateTimePath<java.util.Date> sortTime = createDateTime("sortTime", java.util.Date.class);

    public final StringPath status = createString("status");

    public final StringPath vSn = createString("vSn");

    public final StringPath workContent = createString("workContent");

    public QCarMaintain(String variable) {
        super(CarMaintain.class, forVariable(variable));
    }

    public QCarMaintain(Path<? extends CarMaintain> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCarMaintain(PathMetadata metadata) {
        super(CarMaintain.class, metadata);
    }

}

