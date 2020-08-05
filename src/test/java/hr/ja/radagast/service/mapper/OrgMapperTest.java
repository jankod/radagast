package hr.ja.radagast.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class OrgMapperTest {

    private OrgMapper orgMapper;

    @BeforeEach
    public void setUp() {
        orgMapper = new OrgMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(orgMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(orgMapper.fromId(null)).isNull();
    }
}
