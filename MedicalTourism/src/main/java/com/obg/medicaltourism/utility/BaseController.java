package com.obg.medicaltourism.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

public abstract class BaseController<Entity extends BaseEntity, DTO extends BaseDTO, RequestDTO extends BaseDTO, Mapper extends BaseMapper<Entity, DTO, RequestDTO>, Repository extends BaseRepository<Entity>, Service extends BaseService<Entity, DTO, RequestDTO, Mapper, Repository>> {
    protected abstract Service getService();

    @PostMapping
    public ResponseEntity<DTO> save(@RequestBody RequestDTO requestDTO) {
        return new ResponseEntity<>(getService().save(requestDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DTO>> getAll() {
        return new ResponseEntity<>(getService().getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<Boolean> deleteByUuid(@PathVariable UUID uuid) {
        Boolean isDeleted = getService().delete(uuid);
        if (isDeleted) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<DTO> update(@PathVariable UUID uuid, @RequestBody RequestDTO requestDTO) {
        if (getService().update(uuid, requestDTO) != null) {
            return new ResponseEntity<>(getService().update(uuid, requestDTO), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<DTO> getByUuid(@PathVariable UUID uuid) {
        DTO dto = getService().getByUuid(uuid);

        if (dto != null) {
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
