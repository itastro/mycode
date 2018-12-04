package com.bailian.car.domain.Log;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSysLog is a Querydsl query type for SysLog
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSysLog extends EntityPathBase<SysLog> {

    private static final long serialVersionUID = 548388490L;

    public static final QSysLog sysLog = new QSysLog("sysLog");

    public final DateTimePath<java.util.Date> createTime = createDateTime("createTime", java.util.Date.class);

    public final StringPath description = createString("description");

    public final StringPath exception = createString("exception");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath method = createString("method");

    public final StringPath methodType = createString("methodType");

    public final StringPath module = createString("module");

    public final StringPath operate_ip = createString("operate_ip");

    public final StringPath operator = createString("operator");

    public final StringPath params = createString("params");

    public final StringPath requestMethod = createString("requestMethod");

    public final StringPath requestUrl = createString("requestUrl");

    public final StringPath rsponse_date = createString("rsponse_date");

    public QSysLog(String variable) {
        super(SysLog.class, forVariable(variable));
    }

    public QSysLog(Path<? extends SysLog> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSysLog(PathMetadata metadata) {
        super(SysLog.class, metadata);
    }

}

