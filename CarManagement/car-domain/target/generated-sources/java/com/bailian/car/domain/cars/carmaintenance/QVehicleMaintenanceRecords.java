package com.bailian.car.domain.cars.carmaintenance;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QVehicleMaintenanceRecords is a Querydsl query type for VehicleMaintenanceRecords
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QVehicleMaintenanceRecords extends EntityPathBase<VehicleMaintenanceRecords> {

    private static final long serialVersionUID = -1044246638L;

    public static final QVehicleMaintenanceRecords vehicleMaintenanceRecords = new QVehicleMaintenanceRecords("vehicleMaintenanceRecords");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final ListPath<MaintenanceItem, QMaintenanceItem> maintenanceItem = this.<MaintenanceItem, QMaintenanceItem>createList("maintenanceItem", MaintenanceItem.class, QMaintenanceItem.class, PathInits.DIRECT2);

    public final StringPath maintenanceMileage = createString("maintenanceMileage");

    public final StringPath maintenanceOperator = createString("maintenanceOperator");

    public final DateTimePath<java.util.Date> maintenanceTime = createDateTime("maintenanceTime", java.util.Date.class);

    public final DateTimePath<java.util.Date> nextMaintenanceTime = createDateTime("nextMaintenanceTime", java.util.Date.class);

    public final DateTimePath<java.util.Date> operatorTime = createDateTime("operatorTime", java.util.Date.class);

    public final StringPath vSn = createString("vSn");

    public QVehicleMaintenanceRecords(String variable) {
        super(VehicleMaintenanceRecords.class, forVariable(variable));
    }

    public QVehicleMaintenanceRecords(Path<? extends VehicleMaintenanceRecords> path) {
        super(path.getType(), path.getMetadata());
    }

    public QVehicleMaintenanceRecords(PathMetadata metadata) {
        super(VehicleMaintenanceRecords.class, metadata);
    }

}

