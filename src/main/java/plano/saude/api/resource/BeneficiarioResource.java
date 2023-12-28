package plano.saude.api.resource;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import plano.saude.api.domain.dto.beneficiario.DetailBeneficiarioDTO;
import plano.saude.api.domain.dto.beneficiario.ListingBeneficiarioDTO;
import plano.saude.api.domain.dto.beneficiario.SaveBeneficiarioDTO;
import plano.saude.api.domain.dto.beneficiario.UpdateBeneficiarioDTO;
import plano.saude.api.service.BeneficiarioService;

import java.net.URI;

@RestController
@RequestMapping(value = "/beneficiarios")
public class BeneficiarioResource {

    @Autowired
    private BeneficiarioService service;

    @GetMapping
    public ResponseEntity<Page<ListingBeneficiarioDTO>> findAll(@PageableDefault(size = 20, sort = {"nome"}) Pageable p) {
        return ResponseEntity.ok(service.findAll(p));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DetailBeneficiarioDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.detail(id));
    }

    @PutMapping(value = "/{id}")
    ResponseEntity<DetailBeneficiarioDTO> update(@PathVariable Long id, @RequestBody @Valid UpdateBeneficiarioDTO data) {
        return ResponseEntity.ok(service.update(id, data));
    }

    @PostMapping
    public ResponseEntity<DetailBeneficiarioDTO> save(@RequestBody @Valid SaveBeneficiarioDTO data) {
        DetailBeneficiarioDTO beneficiario = service.save(data);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(beneficiario.id()).toUri();
        return ResponseEntity.created(uri).body(beneficiario);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
