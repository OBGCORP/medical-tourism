package com.obg.medicaltourism.mapper;

import com.obg.medicaltourism.database.entity.Operation;
import com.obg.medicaltourism.model.OperationDTO;
import com.obg.medicaltourism.model.requestDTO.OperationRequestDTO;
import com.obg.medicaltourism.utility.BaseMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OperationMapper implements BaseMapper<Operation, OperationDTO, OperationRequestDTO> {
    @Override
    public OperationDTO entityToDTO(Operation operation) {
        OperationDTO operationDTO = new OperationDTO();
        operationDTO.setUuid(operation.getUuid());
        operationDTO.setId(operation.getId());
        operationDTO.setCreationDate(operation.getCreationDate());
        operationDTO.setUpdatedDate(operation.getUpdatedDate());
        operationDTO.setName(operation.getName());
        operationDTO.setDescription(operation.getDescription());
        operationDTO.setTreatmentFee(operation.getTreatmentFee());
        return operationDTO;
    }

    @Override
    public Operation dtoToEntity(OperationDTO dto) {
        Operation operation = new Operation();
        operation.setUuid(dto.getUuid());
        operation.setId(dto.getId());
        operation.setCreationDate(dto.getCreationDate());
        operation.setUpdatedDate(dto.getUpdatedDate());
        operation.setName(dto.getName());
        operation.setDescription(dto.getDescription());
        operation.setTreatmentFee(dto.getTreatmentFee());
        return operation;
    }

    @Override
    public List<OperationDTO> entityListToDTOList(List<Operation> operations) {
        List<OperationDTO> operationDTOS = new ArrayList<>();
        for (Operation operation : operations) {
            operationDTOS.add(entityToDTO(operation));
        }
        return operationDTOS;
    }

    @Override
    public List<Operation> dtoListToEntityList(List<OperationDTO> operationDTOS) {
        List<Operation> operations = new ArrayList<>();
        for (OperationDTO operationDTO : operationDTOS) {
            operations.add(dtoToEntity(operationDTO));
        }
        return operations;
    }

    @Override
    public Operation requestDTOToEntity(OperationRequestDTO operationRequestDTO) {
        Operation operation = new Operation();
        operation.setUuid(operationRequestDTO.getUuid());
        operation.setId(operationRequestDTO.getId());
        operation.setCreationDate(operationRequestDTO.getCreationDate());
        operation.setUpdatedDate(operationRequestDTO.getUpdatedDate());
        operation.setName(operationRequestDTO.getName());
        operation.setDescription(operationRequestDTO.getDescription());
        operation.setTreatmentFee(operationRequestDTO.getTreatmentFee());
        return operation;
    }

    @Override
    public List<Operation> requestDTOListToEntityList(List<OperationRequestDTO> operationRequestDTOS) {
        List<Operation> operations = new ArrayList<>();
        for (OperationRequestDTO operationRequestDTO : operationRequestDTOS) {
            operations.add(requestDTOToEntity(operationRequestDTO));
        }
        return operations;
    }

    @Override
    public Operation requestDTOToExistEntity(OperationRequestDTO operationRequestDTO, Operation operation) {
        operation.setUuid(operationRequestDTO.getUuid());
        operation.setId(operationRequestDTO.getId());
        operation.setCreationDate(operationRequestDTO.getCreationDate());
        operation.setUpdatedDate(operationRequestDTO.getUpdatedDate());
        operation.setName(operationRequestDTO.getName());
        operation.setDescription(operationRequestDTO.getDescription());
        operation.setTreatmentFee(operationRequestDTO.getTreatmentFee());
        return operation;
    }
}
