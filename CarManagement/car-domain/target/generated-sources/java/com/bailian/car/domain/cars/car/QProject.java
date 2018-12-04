package com.bailian.car.domain.cars.car;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QProject is a Querydsl query type for Project
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProject extends EntityPathBase<Project> {

    private static final long serialVersionUID = -232938759L;

    public static final QProject project = new QProject("project");

    public final StringPath customer = createString("customer");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath project_sn = createString("project_sn");

    public final StringPath project_status = createString("project_status");

    public final StringPath projectName = createString("projectName");

    public final StringPath remark = createString("remark");

    public QProject(String variable) {
        super(Project.class, forVariable(variable));
    }

    public QProject(Path<? extends Project> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProject(PathMetadata metadata) {
        super(Project.class, metadata);
    }

}

