package hr.ja.radagast.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;
import hr.ja.radagast.domain.enumeration.OrgStatus;

/**
 * A DTO for the {@link hr.ja.radagast.domain.Org} entity.
 */
public class OrgDTO implements Serializable {
    
    private Long id;

    @NotNull
    @Size(max = 200)
    private String name;

    @Size(max = 4000)
    private String description;

    private OrgStatus status;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OrgStatus getStatus() {
        return status;
    }

    public void setStatus(OrgStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof OrgDTO)) {
            return false;
        }

        return id != null && id.equals(((OrgDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "OrgDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            ", status='" + getStatus() + "'" +
            "}";
    }
}
