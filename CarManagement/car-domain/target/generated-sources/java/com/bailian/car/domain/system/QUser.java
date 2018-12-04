package com.bailian.car.domain.system;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = 699598401L;

    public static final QUser user = new QUser("user");

    public final DateTimePath<java.util.Date> createTime = createDateTime("createTime", java.util.Date.class);

    public final StringPath email = createString("email");

    public final StringPath employeeCard = createString("employeeCard");

    public final StringPath netid = createString("netid");

    public final StringPath nickname = createString("nickname");

    public final StringPath operate_id = createString("operate_id");

    public final StringPath operator = createString("operator");

    public final StringPath password = createString("password");

    public final StringPath remark = createString("remark");

    public final SetPath<Role, QRole> roles = this.<Role, QRole>createSet("roles", Role.class, QRole.class, PathInits.DIRECT2);

    public final StringPath sex = createString("sex");

    public final StringPath team = createString("team");

    public final StringPath telephone = createString("telephone");

    public final NumberPath<Integer> uid = createNumber("uid", Integer.class);

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

