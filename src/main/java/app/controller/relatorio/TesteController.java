package app.controller.relatorio;

import app.model.Cliente;
import app.model.Produto;
import app.relatorio.ClienteTeste;
import app.relatorio.Estoque;
import app.repository.ClienteRepository;
import app.repository.ProdutoRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/teste")
public class TesteController {


    @Autowired
    private ProdutoRepository repository;

    @GetMapping
    public ResponseEntity<byte[]> gerarRelatorio() throws JRException, FileNotFoundException {
        List<Estoque> lista = new ArrayList<>();
        try {

            for (Produto p : repository.findAll()) {
                Estoque e = new Estoque();
               e.setNome(p.getNome());
               e.setValorUnitario(p.getValorUnitario());
               e.setQuantidade(p.getQuantidade());
               e.setValorTotal(p.getQuantidade()*p.getValorUnitario());
                lista.add(e);
            }
            Map<String, Object> empParams = new HashMap<String, Object>();
            empParams.put("Araujo", "app");
            empParams.put("Estoque", new JRBeanCollectionDataSource(lista));

            JasperPrint empReport =
                    JasperFillManager.fillReport
                            (
                                    JasperCompileManager.compileReport(
                                            ResourceUtils
                                                    .getFile("classpath:Estoque.jrxml")
                                                    .getAbsolutePath()) // path of the jasper report
                                    , empParams // dynamic parameters
                                    , new JRBeanCollectionDataSource(lista)
                            );


            HttpHeaders headers = new HttpHeaders();
            //set the PDF format
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("filename", "Estoque.pdf");
            //create the report in PDF format
            return new ResponseEntity<byte[]>
                    (JasperExportManager.exportReportToPdf(empReport), headers, HttpStatus.OK);

        } catch(Exception e) {
            return new ResponseEntity<byte[]>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


}
