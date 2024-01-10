package plano.saude.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import plano.saude.api.domain.Beneficiario;
import plano.saude.api.domain.Documento;
import plano.saude.api.domain.enums.TipoDocumentoEnum;
import plano.saude.api.repository.BeneficiarioRepository;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Arrays;
import java.util.Date;
import java.util.TimeZone;

@Configuration
@Profile(value = "test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private BeneficiarioRepository beneficiarioRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        Documento c1 = new Documento(null, "desc c1", Instant.now(), Instant.now(), TipoDocumentoEnum.RG, null);
        Documento c2 = new Documento(null, "desc c2", Instant.now(), Instant.now(), TipoDocumentoEnum.CPF, null);

        Beneficiario b1 = new Beneficiario(null, "Eduardo", "11998765432", sdf.parse("1998-11-02"));
        Beneficiario b2 = new Beneficiario(null, "Amanda", "11987654321", sdf.parse("1998-08-12"));

        b1.getDocumentos().add(c1);
        b2.getDocumentos().add(c2);

        beneficiarioRepository.saveAll(Arrays.asList(b1, b2));
    }
}
