package com.bailian.car.domain.system;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRole is a Querydsl query type for Role
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRole extends EntityPathBase<Role> {

    private static final long serialVersionUID = 699505388L;

    public static final QRole role = new QRole("role");

    public final DateTimePath<java.util.Date> createTime = createDateTime("createTime", java.util.Date.class);

    public final StringPath keyWord = createString("keyWord");

    public final SetPath<Menu, QMenu> menus = this.<Menu, QMenu>createSet("menus", Menu.class, QMenu.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final StringPath operate_ip = createString("operate_ip");

    public final StringPath operator = createString("operator");

    public final SetPath<Permission, QPermission> permissions = this.<Permission, QPermission>createSet("permissions", Permission.class, QPermission.class, PathInits.DIRECT2);

    public final StringPath remark = createString("remark");

    public final NumberPath<Integer> rid = createNumber("rid", Integer.class);

    public final SetPath<User, QUser> users = this.<User, QUser>createSet("users", User.class, QUser.class, PathInits.DIRECT2);

    public QRole(String variable) {
        super(Role.class, forVariable(variable));
    }

    public QRole(Path<? extends Role> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRole(PathMetadata metadata) {
        super(Role.class, metadata);
    }

}

