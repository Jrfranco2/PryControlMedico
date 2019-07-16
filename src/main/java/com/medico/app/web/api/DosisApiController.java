package com.medico.app.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.medico.app.web.models.entities.Dosis;

import com.medico.app.web.models.services.IDetalleRecetaService;
import com.medico.app.web.models.services.IDosisService;
import com.medico.app.web.models.services.IPacienteService;
import com.medico.app.web.models.services.IRecetaService;

@RestController
@RequestMapping(value="/api")
public class DosisApiController {
	@Autowired
    private IDosisService service;

  
   

    @GetMapping(value="/dosis/{id}" )
    public Dosis retrieve(@PathVariable(value = "id") Integer id){
    	return service.findById(id);
    }

    @GetMapping(value="/dosis" )
    public List<Dosis> list(){
        return service.findAll();
    }
    
    @GetMapping(value="/dosisxdetalle/{id}" )
    public List<Dosis> findAllOfOneDetail(@PathVariable(value = "id") Integer id){
    	return service.findAllOfOneDetail(id);
    }
}
