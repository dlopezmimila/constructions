package com.dlm.constructions.rest;

import com.dlm.constructions.service.ContructionService;
import com.dlm.constructions.views.ConstructionView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("constructions")

public class ConstructionRest {

    private final Logger logger=LoggerFactory.getLogger(ConstructionRest.class);
    private ContructionService contructionService;
    @Autowired
    public void setContructionService(ContructionService contructionService) {
        this.contructionService = contructionService;
    }

    @PostMapping
    public void addContruction(@RequestBody @Valid ConstructionView view){
        logger.info("creando una nueva construcion: {} ", view);
        contructionService.addConstruction(view);
    }
    //Este es un Get
    @GetMapping("{id}")
    public ConstructionView finById (@PathVariable Long id){
       logger.info("Obteniedno construccion: {}",id);
       return contructionService.findById(id);

    }

    @GetMapping
    public List<ConstructionView> findList(@RequestParam(required = false) Long rowVersion){
        logger.info("Seleccionado lista de cosntrucciones: version {}",rowVersion);
        return contructionService.searchContructions(rowVersion);
    }
    @DeleteMapping("{id}")
    public void dleteConstruction(@PathVariable Long id){
        logger.info("Eliminando constrcuccion: {}",id);
        contructionService.deleteConstruction(id);
    }
    @PutMapping ("{id}")
    public void updateContruction(@RequestBody @Valid ConstructionView view,@PathVariable()Long id){
        logger.info("Se esta actulizando la tabla: {} ", view);
        view.setIdType(id);
        contructionService.updateConstruction(view);
    }

}
