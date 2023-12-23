package plano.saude.api.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import plano.saude.api.domain.Beneficiario;
import plano.saude.api.service.BeneficiarioService;

import java.util.List;

@RestController
@RequestMapping(value = "/beneficiarios")
public class BeneficiarioController {

    @Autowired
    private BeneficiarioService service;

    @GetMapping
    public ResponseEntity<List<Beneficiario>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }
}
