package plano.saude.api.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import plano.saude.api.domain.Beneficiario;
import plano.saude.api.domain.dto.beneficiario.ListingBeneficiario;
import plano.saude.api.service.BeneficiarioService;

@RestController
@RequestMapping(value = "/beneficiarios")
public class BeneficiarioResource {

    @Autowired
    private BeneficiarioService service;

    @GetMapping
    public ResponseEntity<Page<ListingBeneficiario>> findAll(@PageableDefault(size = 20, sort = {"nome"}) Pageable p) {
        return ResponseEntity.ok(service.findAll(p).map(ListingBeneficiario::new));
    }
}
