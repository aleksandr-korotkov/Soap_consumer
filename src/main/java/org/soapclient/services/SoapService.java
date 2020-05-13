package org.soapclient.services;

import org.flowersshop.*;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import java.math.BigDecimal;

public class SoapService extends WebServiceGatewaySupport {

    public GetBouquetByNameResponse getBouquetByNameResponse(String name) {
        GetBouquetByNameRequest request = new GetBouquetByNameRequest();
        request.setName(name);
        return  (GetBouquetByNameResponse) getWebServiceTemplate().marshalSendAndReceive(
                request, new SoapActionCallback("http://localhost:8080/ws/GetBouquetByNameRequest"));
    }

    public GetBouquetByPriceResponse getBouquetByPriceResponse(BigDecimal price) {
        GetBouquetByPriceRequest request = new GetBouquetByPriceRequest();
        request.setPrice(price);
        return (GetBouquetByPriceResponse) getWebServiceTemplate().marshalSendAndReceive(
                request, new SoapActionCallback("http://localhost:8080/ws/GetBouquetByPriceRequest"));
    }

    public GetBouquetByNameAndPriceResponse getBouquetByNameAndPriceResponse(String name, BigDecimal price) {
        GetBouquetByNameAndPriceRequest request = new GetBouquetByNameAndPriceRequest();
        request.setName(name);
        request.setPrice(price);
        return (GetBouquetByNameAndPriceResponse) getWebServiceTemplate().marshalSendAndReceive(
                request, new SoapActionCallback("http://localhost:8080/ws/GetBouquetByNameAndPriceRequest"));
    }

    public GetAllBouquetsResponse getAllBouquetsResponse() {
        GetAllBouquetsRequest request = new GetAllBouquetsRequest();
        return (GetAllBouquetsResponse) getWebServiceTemplate().marshalSendAndReceive(
                request, new SoapActionCallback("http://localhost:8080/ws/GetAllBouquetsRequest"));
    }

    public AddBouquetResponse addBouquetResponse(String name, BigDecimal price) {
        AddBouquetRequest request = new AddBouquetRequest();
        request.setName(name);
        request.setPrice(price);
        return (AddBouquetResponse) getWebServiceTemplate().marshalSendAndReceive(
                request, new SoapActionCallback("http://localhost:8080/ws/AddBouquetRequest"));
    }

    public UpdateBouquetResponse updateBouquetResponse(Bouquet bouquet) {
        UpdateBouquetRequest request = new UpdateBouquetRequest();
        request.setBouquet(bouquet);
        return (UpdateBouquetResponse) getWebServiceTemplate().marshalSendAndReceive(
                request, new SoapActionCallback("http://localhost:8080/ws/UpdateBouquetRequest"));
    }

    public DeleteBouquetResponse deleteBouquetResponse(Long id) {
        DeleteBouquetRequest request = new DeleteBouquetRequest();
        request.setBouquetId(id);
        return (DeleteBouquetResponse) getWebServiceTemplate().marshalSendAndReceive(
                request, new SoapActionCallback("http://localhost:8080/ws/DeleteBouquetRequest"));
    }
}