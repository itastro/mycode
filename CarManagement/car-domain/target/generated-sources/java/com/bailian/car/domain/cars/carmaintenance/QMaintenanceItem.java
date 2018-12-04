package com.bailian.car.domain.cars.carmaintenance;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMaintenanceItem is a Querydsl query type for MaintenanceItem
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMaintenanceItem extends EntityPathBase<MaintenanceItem> {

    private static final long serialVersionUID = 1977311517L;

    public static final QMaintenanceItem maintenanceItem = new QMaintenanceItem("maintenanceItem");

    public final StringPath brandAndlabel = createString("brandAndlabel");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath itemName = createString("itemName");

    public QMaintenanceItem(String variable) {
        super(MaintenanceItem.class, forVariable(variable));
    }

    public QMaintenanceItem(Path<? extends MaintenanceItem> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMaintenanceItem(PathMetadata metadata) {
        super(MaintenanceItem.class, metadata);
    }

}

