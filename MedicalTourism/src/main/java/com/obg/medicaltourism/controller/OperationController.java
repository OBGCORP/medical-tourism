package com.obg.medicaltourism.controller;

import com.obg.medicaltourism.database.entity.Operation;
import com.obg.medicaltourism.database.repository.OperationRepository;
import com.obg.medicaltourism.mapper.OperationMapper;
import com.obg.medicaltourism.model.OperationDTO;
import com.obg.medicaltourism.model.requestDTO.OperationRequestDTO;
import com.obg.medicaltourism.service.OperationService;
import com.obg.medicaltourism.utility.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/operations")
public class OperationController extends BaseController<Operation, OperationDTO, OperationRequestDTO, OperationMapper, OperationRepository, OperationService> {

    private final OperationService operationService;

    @Autowired
    public OperationController(OperationService operationService) {
        this.operationService = operationService;
    }

    @Override
    protected OperationService getService() {
        return operationService;
    }

}
