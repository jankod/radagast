package hr.ja.radagast.service.mapper;


import hr.ja.radagast.domain.*;
import hr.ja.radagast.service.dto.OrgDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Org} and its DTO {@link OrgDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface OrgMapper extends EntityMapper<OrgDTO, Org> {


    @Mapping(target = "resources", ignore = true)
    @Mapping(target = "removeResource", ignore = true)
    Org toEntity(OrgDTO orgDTO);

    default Org fromId(Long id) {
        if (id == null) {
            return null;
        }
        Org org = new Org();
        org.setId(id);
        return org;
    }
}
