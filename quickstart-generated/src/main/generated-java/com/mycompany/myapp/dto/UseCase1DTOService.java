/*
 * Source code generated by Celerio, a Jaxio product.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Follow us on twitter: @jaxiosoft
 * Need commercial support ? Contact us: info@jaxio.com
 * Template pack-angular:src/main/java/dto/EntityDTOService.java.e.vm
 */
package com.mycompany.myapp.dto;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.myapp.domain.UseCase1;
import com.mycompany.myapp.domain.UseCase1Pk;
import com.mycompany.myapp.domain.UseCase1_;
import com.mycompany.myapp.dto.support.PageRequestByExample;
import com.mycompany.myapp.dto.support.PageResponse;
import com.mycompany.myapp.repository.UseCase1Repository;

/**
 * A simple DTO Facility for UseCase1.
 */
@Service
public class UseCase1DTOService {

    @Inject
    private UseCase1Repository useCase1Repository;

    @Transactional(readOnly = true)
    public UseCase1DTO findOne(UseCase1Pk id) {
        return toDTO(useCase1Repository.findOne(id));
    }

    @Transactional(readOnly = true)
    public List<UseCase1DTO> complete(String query, int maxResults) {
        List<UseCase1> results = useCase1Repository.complete(query, maxResults);
        return results.stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PageResponse<UseCase1DTO> findAll(PageRequestByExample<UseCase1DTO> req) {
        Example<UseCase1> example = null;
        UseCase1 useCase1 = toEntity(req.example);

        if (useCase1 != null) {
            ExampleMatcher matcher = ExampleMatcher.matching() //
                    .withMatcher(UseCase1_.dummy.getName(), match -> match.ignoreCase().startsWith());

            example = Example.of(useCase1, matcher);
        }

        Page<UseCase1> page;
        if (example != null) {
            page = useCase1Repository.findAll(example, req.toPageable());
        } else {
            page = useCase1Repository.findAll(req.toPageable());
        }

        List<UseCase1DTO> content = page.getContent().stream().map(this::toDTO).collect(Collectors.toList());
        return new PageResponse<>(page.getTotalPages(), page.getTotalElements(), content);
    }

    /**
     * Save the passed dto as a new entity or update the corresponding entity if any.
     */
    @Transactional
    public UseCase1DTO save(UseCase1DTO dto) {
        if (dto == null) {
            return null;
        }

        final UseCase1 useCase1;

        if (dto.isIdSet()) {
            UseCase1 useCase1Tmp = useCase1Repository.findOne(dto.id);
            if (useCase1Tmp != null) {
                useCase1 = useCase1Tmp;
            } else {
                useCase1 = new UseCase1();
                useCase1.setId(dto.id);
            }
        } else {
            useCase1 = new UseCase1();
        }

        useCase1.setDummy(dto.dummy);

        return toDTO(useCase1Repository.save(useCase1));
    }

    /**
     * Converts the passed useCase1 to a DTO.
     */
    public UseCase1DTO toDTO(UseCase1 useCase1) {
        return toDTO(useCase1, 1);
    }

    /**
     * Converts the passed useCase1 to a DTO. The depth is used to control the
     * amount of association you want. It also prevents potential infinite serialization cycles.
     *
     * @param useCase1
     * @param depth the depth of the serialization. A depth equals to 0, means no x-to-one association will be serialized.
     *              A depth equals to 1 means that xToOne associations will be serialized. 2 means, xToOne associations of
     *              xToOne associations will be serialized, etc.
     */
    public UseCase1DTO toDTO(UseCase1 useCase1, int depth) {
        if (useCase1 == null) {
            return null;
        }

        UseCase1DTO dto = new UseCase1DTO();

        dto.id = useCase1.getId();
        dto.dummy = useCase1.getDummy();
        if (depth-- > 0) {
        }

        return dto;
    }

    /**
     * Converts the passed dto to a UseCase1.
     * Convenient for query by example.
     */
    public UseCase1 toEntity(UseCase1DTO dto) {
        return toEntity(dto, 1);
    }

    /**
     * Converts the passed dto to a UseCase1.
     * Convenient for query by example.
     */
    public UseCase1 toEntity(UseCase1DTO dto, int depth) {
        if (dto == null) {
            return null;
        }

        UseCase1 useCase1 = new UseCase1();

        useCase1.setId(dto.id);
        useCase1.setDummy(dto.dummy);
        if (depth-- > 0) {
        }

        return useCase1;
    }
}