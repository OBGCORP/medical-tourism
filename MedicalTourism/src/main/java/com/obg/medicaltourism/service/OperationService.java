package com.obg.medicaltourism.service;

import com.obg.medicaltourism.database.entity.Operation;
import com.obg.medicaltourism.database.repository.OperationRepository;
import com.obg.medicaltourism.mapper.OperationMapper;
import com.obg.medicaltourism.model.OperationDTO;
import com.obg.medicaltourism.model.requestDTO.OperationRequestDTO;
import com.obg.medicaltourism.utility.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class OperationService extends BaseService<Operation, OperationDTO, OperationRequestDTO, OperationMapper, OperationRepository> {

    private final OperationMapper operationMapper;
    private final OperationRepository operationRepository;

    @Autowired
    public OperationService(OperationMapper operationMapper, OperationRepository operationRepository) {
        this.operationMapper = operationMapper;
        this.operationRepository = operationRepository;
    }

    @Override
    public OperationMapper getMapper() {
        return operationMapper;
    }

    @Override
    public OperationRepository getRepository() {
        return operationRepository;
    }

    public Page<OperationDTO> getAllOperationsWithPagination(int page, int pageSize) {
        if (page < 0) return null;
        else if (pageSize <= 0) pageSize = 5;
        Page<Operation> operations = operationRepository.findAll(org.springframework.data.domain.PageRequest.of(page, pageSize));
        return operations.map(operationMapper::entityToDTO);
    }

}
