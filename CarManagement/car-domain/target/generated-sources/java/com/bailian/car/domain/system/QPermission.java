package com.bailian.car.domain.system;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPermission is a Querydsl query type for Permission
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPermission extends EntityPathBase<Permission> {

    private static final long serialVersionUID = -1044009019L;

    public static final QPermission permission = new QPermission("permission");

    public final DateTimePath<java.util.Date> createTime = createDateTime("createTime", java.util.Date.class);

    public final StringPath keyWord = createString("keyWord");

    public final StringPath name = createString("name");

    public final StringPath operate_ip = createString("operate_ip");

    public final StringPath operator = createString("operator");

    public final NumberPath<Integer> pid = createNumber("pid", Integer.class);

    public final StringPath remark = createString("remark");

    public final SetPath<Role, QRole> roles = this.<Role, QRole>createSet("roles", Role.class, QRole.class, PathInits.DIRECT2);

    public QPermission(String variable) {
        super(Permission.class, forVariable(variable));
    }

    public QPermission(Path<? extends Permission> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPermission(PathMetadata metadata) {
        super(Permission.class, metadata);
    }

}

