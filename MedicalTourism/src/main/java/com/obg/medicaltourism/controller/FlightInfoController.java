package com.obg.medicaltourism.controller;

import com.obg.medicaltourism.database.entity.FlightInfo;
import com.obg.medicaltourism.database.repository.FlightInfoRepository;
import com.obg.medicaltourism.mapper.FlightInfoMapper;
import com.obg.medicaltourism.model.FlightInfoDTO;
import com.obg.medicaltourism.model.requestDTO.FlightInfoRequestDTO;
import com.obg.medicaltourism.service.FlightInfoService;
import com.obg.medicaltourism.utility.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flightInfos")
public class FlightInfoController extends BaseController<FlightInfo, FlightInfoDTO, FlightInfoRequestDTO, FlightInfoMapper, FlightInfoRepository, FlightInfoService> {

    private final FlightInfoService flightInfoService;

    @Autowired
    public FlightInfoController(FlightInfoService flightInfoService) {
        this.flightInfoService = flightInfoService;
    }

    @Override
    protected FlightInfoService getService() {
        return flightInfoService;
    }

}
