package hr.ja.radagast.web.rest;

import hr.ja.radagast.service.OrgService;
import hr.ja.radagast.web.rest.errors.BadRequestAlertException;
import hr.ja.radagast.service.dto.OrgDTO;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link hr.ja.radagast.domain.Org}.
 */
@RestController
@RequestMapping("/api")
public class OrgResource {

    private final Logger log = LoggerFactory.getLogger(OrgResource.class);

    private static final String ENTITY_NAME = "org";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final OrgService orgService;

    public OrgResource(OrgService orgService) {
        this.orgService = orgService;
    }

    /**
     * {@code POST  /orgs} : Create a new org.
     *
     * @param orgDTO the orgDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new orgDTO, or with status {@code 400 (Bad Request)} if the org has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/orgs")
    public ResponseEntity<OrgDTO> createOrg(@Valid @RequestBody OrgDTO orgDTO) throws URISyntaxException {
        log.debug("REST request to save Org : {}", orgDTO);
        if (orgDTO.getId() != null) {
            throw new BadRequestAlertException("A new org cannot already have an ID", ENTITY_NAME, "idexists");
        }
        OrgDTO result = orgService.save(orgDTO);
        return ResponseEntity.created(new URI("/api/orgs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /orgs} : Updates an existing org.
     *
     * @param orgDTO the orgDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated orgDTO,
     * or with status {@code 400 (Bad Request)} if the orgDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the orgDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/orgs")
    public ResponseEntity<OrgDTO> updateOrg(@Valid @RequestBody OrgDTO orgDTO) throws URISyntaxException {
        log.debug("REST request to update Org : {}", orgDTO);
        if (orgDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        OrgDTO result = orgService.save(orgDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, orgDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /orgs} : get all the orgs.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of orgs in body.
     */
    @GetMapping("/orgs")
    public ResponseEntity<List<OrgDTO>> getAllOrgs(Pageable pageable) {
        log.debug("REST request to get a page of Orgs");
        Page<OrgDTO> page = orgService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /orgs/:id} : get the "id" org.
     *
     * @param id the id of the orgDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the orgDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/orgs/{id}")
    public ResponseEntity<OrgDTO> getOrg(@PathVariable Long id) {
        log.debug("REST request to get Org : {}", id);
        Optional<OrgDTO> orgDTO = orgService.findOne(id);
        return ResponseUtil.wrapOrNotFound(orgDTO);
    }

    /**
     * {@code DELETE  /orgs/:id} : delete the "id" org.
     *
     * @param id the id of the orgDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/orgs/{id}")
    public ResponseEntity<Void> deleteOrg(@PathVariable Long id) {
        log.debug("REST request to delete Org : {}", id);
        orgService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
