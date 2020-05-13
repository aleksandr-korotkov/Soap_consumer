package org.soapclient.configs;

import org.soapclient.services.SoapService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class WSConfigClient {
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("org.flowersshop");
        return marshaller;
    }
    @Bean
    public SoapService articleClient(Jaxb2Marshaller marshaller) {
        SoapService client = new SoapService();
        client.setDefaultUri("http://localhost:8080/ws/bouquets.wsdl");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}