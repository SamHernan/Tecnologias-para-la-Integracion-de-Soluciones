package com.example.demo;

import org.example.conversor.PesosDivRequest;
import org.example.conversor.PesosDivResponse;
import org.example.conversor.PesosMulRequest;
import org.example.conversor.PesosMulResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ConversorEndPoint {
    
    @PayloadRoot (namespace="http://www.example.org/conversor", localPart= "PesosDivRequest")
    
    @ResponsePayload
    public PesosDivResponse dameDiv(@RequestPayload PesosDivRequest peticion){
        PesosDivResponse respuesta= new PesosDivResponse();
        respuesta.setResultado( String.valueOf(
            Float.parseFloat(peticion.getA()) / Float.parseFloat(peticion.getB())
        ));
        return respuesta;
    }

    @PayloadRoot (namespace="http://www.example.org/conversor", localPart= "PesosMulRequest")
    
    @ResponsePayload
    public PesosMulResponse dameMul(@RequestPayload PesosMulRequest peticion){
        PesosMulResponse respuesta= new PesosMulResponse();
        respuesta.setResultado(String.valueOf(
            Float.parseFloat(peticion.getA()) * Float.parseFloat(peticion.getB())
        ));
        return respuesta;
    }
}