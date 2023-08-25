package com.obg.medicaltourism.utility;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public abstract class BaseService<Entity extends BaseEntity, DTO extends BaseDTO, RequestDTO extends BaseDTO, Mapper extends IBaseMapper<Entity, DTO, RequestDTO>, Repository extends IBaseRepository<Entity>> {

    public abstract Mapper getMapper();

    public abstract Repository getRepository();

    public DTO save(RequestDTO requestDTO) {
        Entity entity = getMapper().requestDTOToEntity(requestDTO);
        getRepository().save(entity);
        return getMapper().entityToDTO(entity);
    }

    @Modifying
    @Transactional
    public DTO update(UUID uuid, RequestDTO requestDTO) {
        Optional<Entity> entity = getRepository().findByUuid(uuid);
        if (entity.isPresent()) {
            Entity newEntity = getMapper().requestDTOToExistEntity(requestDTO, entity.get());
            getRepository().save(newEntity);
            return getMapper().entityToDTO(newEntity);
        } else {
            return null;
        }
    }

    public List<DTO> getAll() {
        return getMapper().entityListToDTOList(getRepository().findAll());
    }

    @Modifying
    @Transactional
    public Boolean delete(UUID uuid) {
        Optional<Entity> entity = getRepository().findByUuid(uuid);
        if (entity.isPresent()) {
            getRepository().delete(entity.get());
            return true;
        } else {
            return false;
        }
    }

    public DTO getByUuid(UUID uuid) {
        Optional<Entity> entity = getRepository().findByUuid(uuid);
        if (entity.isPresent()) {
            return getMapper().entityToDTO(entity.get());
        } else {
            return null;
        }
    }
}
