package com.obg.medicaltourism.mapper;

import com.obg.medicaltourism.database.entity.Operation;
import com.obg.medicaltourism.model.OperationDTO;
import com.obg.medicaltourism.model.requestDTO.OperationRequestDTO;
import com.obg.medicaltourism.utility.BaseMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OperationMapper implements BaseMapper<Operation, OperationDTO, OperationRequestDTO> {
    @Override
    public OperationDTO entityToDTO(Operation entity) {
        return null;
    }

    @Override
    public Operation dtoToEntity(OperationDTO dto) {
        return null;
    }

    @Override
    public List<OperationDTO> entityListToDTOList(List<Operation> operations) {
        return null;
    }

    @Override
    public List<Operation> dtoListToEntityList(List<OperationDTO> operationDTOS) {
        return null;
    }

    @Override
    public Operation requestDTOToEntity(OperationRequestDTO operationRequestDTO) {
        return null;
    }

    @Override
    public List<Operation> requestDTOListToEntityList(List<OperationRequestDTO> operationRequestDTOS) {
        return null;
    }

    @Override
    public Operation requestDTOToExistEntity(OperationRequestDTO operationRequestDTO, Operation entity) {
        return null;
    }
}
