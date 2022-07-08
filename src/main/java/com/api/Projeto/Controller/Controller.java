package com.api.Projeto.Controller;

import com.api.Projeto.Dto.EstadoDto;
import com.api.Projeto.Dto.FeignDto;
import com.api.Projeto.Dto.ListDto;
import com.api.Projeto.Model.DtoConverter;
import com.api.Projeto.Model.EstadoModel;
import com.api.Projeto.Service.EstadoService;
import com.api.Projeto.repository.EstadoRepository;
import com.api.Projeto.repository.FeignRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import java.util.Optional;


//RestController ja vem com RespondeBody
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/estado")

public class Controller {
    //ponto de injecao

    @Autowired
    private EstadoRepository estadoRepository;
    @Autowired
    private EstadoService estadoService;
    @Autowired
    private FeignRepository feignRepository;
    @Autowired



    public Controller(EstadoService estadoService){

        this.estadoService = estadoService;
    }

    @GetMapping(value = "/aa")
    @ResponseStatus(HttpStatus.OK)
    public ListDto getALlPosts(){
        ListDto listDto = feignRepository.getAllPosts();

        for(FeignDto feignDto : listDto.getValue()){
            EstadoModel estadoModel = DtoConverter.getList(feignDto);
            estadoService.getAllPosts(estadoModel);
        }

        return listDto;
    }

    @GetMapping(value = "/dados")
     private String dados(){
        String uri = "https://olinda.bcb.gov.br/olinda/servico/SICOR/versao/v2/odata/InvestMunicipioProduto?$top=200&$format=json&$select=Municipio,nomeProduto,MesEmissao,AnoEmissao,cdPrograma,cdSubPrograma,cdFonteRecurso,cdTipoSeguro,cdEstado,VlCusteio,cdProduto,cdMunicipio,Atividade,cdModalidade,AreaInvest";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri,String.class);
        return result;
    }


    @PostMapping
    public ResponseEntity<Object> saveEstado(@RequestBody EstadoDto estadoDto){
        var estadoModel = new EstadoModel();
        BeanUtils.copyProperties(estadoDto,estadoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(estadoService.save(estadoModel));
    }

    @GetMapping
    public ResponseEntity<Page<EstadoModel>>getAllEstados(@PageableDefault (page =0 ,size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(estadoService.findAll(pageable));
    }
    @GetMapping("/{id}")

    public ResponseEntity<Object> getOneEstado(@PathVariable(value = "id") Long id){
        Optional<EstadoModel> estadoModelOptional = estadoService.findById(id);
        if(!estadoModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(estadoModelOptional.get());
    }
    @DeleteMapping("/{id}")

    public ResponseEntity<Object> deleteEstado(@PathVariable(value = "id") Long id){
        Optional<EstadoModel> estadoModelOptional = estadoService.findById(id);
        if (!estadoModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found. ");
        }
        estadoService.delete(estadoModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Deleted successfully. ");
    }
    @PutMapping("/{id}")

    public ResponseEntity<Object> updateEstado(@PathVariable(value = "id") Long id, @RequestBody EstadoDto estadoDto) {
        Optional<EstadoModel> estadoModelOptional = estadoService.findById(id);
        if (!estadoModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found. ");
        }
        var estadoModel = new EstadoModel();
        BeanUtils.copyProperties(estadoDto, estadoModel);
        estadoModel.setId(estadoModelOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(estadoService.save(estadoModel));

    }




    //crud*/
}
