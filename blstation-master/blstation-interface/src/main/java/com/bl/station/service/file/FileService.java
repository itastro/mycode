package com.bl.station.service.file;

import com.bl.station.param.SourceParam;
import com.bl.station.utils.StationResult;

public interface FileService {


    StationResult upload(SourceParam sourceParam) throws  Exception;
}
