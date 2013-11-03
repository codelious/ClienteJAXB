package com.codelious.clientejaxb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.codelious.clientejaxb.generados.SaludoRequest;
import com.codelious.clientejaxb.generados.SaludoResponse;


@Controller
public class SaludoController {


	@Autowired
	@Qualifier("webServiceTemplate")
	private WebServiceTemplate webServiceTemplate;
	
	@RequestMapping("/saludo")
	public ModelAndView saludo() {
		
		// crear solicitud al ws
		SaludoRequest solicitud = new SaludoRequest();
		solicitud.setNombre("Mario Espinoza Aguayo");
		
		// obtener la respuesta
		SaludoResponse respuesta = (SaludoResponse) webServiceTemplate.marshalSendAndReceive(solicitud);
				 
		// obtiene el saludo
		String mensaje = respuesta.getSaludo();
		
		return new ModelAndView("saludo", "mensaje", mensaje);
	}
}
