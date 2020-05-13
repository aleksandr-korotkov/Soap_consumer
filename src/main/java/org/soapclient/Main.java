package org.soapclient;

import org.apache.log4j.Logger;
import org.flowersshop.*;
import org.soapclient.services.SoapService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class Main {
    final static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
    @Bean
    CommandLineRunner lookup(SoapService soapService) {
        return args -> {
            GetBouquetByNameResponse getBouquetByNameResponse = soapService.getBouquetByNameResponse("spring");
            getBouquetByNameResponse.getBouquet().stream().forEach(bouquet -> {
                logger.info("request: GetBouquetByName. response: " + bouquet.getId() + " "
                        + bouquet.getName() + " " + bouquet.getPrice());
            });

            GetBouquetByPriceResponse getBouquetByPriceResponse = soapService.getBouquetByPriceResponse(BigDecimal.valueOf(500));
            getBouquetByPriceResponse.getBouquet().stream().forEach(bouquet -> {
                logger.info("request: GetBouquetByPrice. response: " + bouquet.getId() + " " +
                        bouquet.getName() + " " + bouquet.getPrice());
            });

            GetBouquetByNameAndPriceResponse getBouquetByNameAndPriceResponse = soapService.getBouquetByNameAndPriceResponse("spring" ,BigDecimal.valueOf(500));
            getBouquetByNameAndPriceResponse.getBouquet().stream().forEach(bouquet -> {
                logger.info("request: GetBouquetByNameAndPrice. response: " + bouquet.getId() + " " +
                        bouquet.getName() + " " + bouquet.getPrice());
            });

            GetAllBouquetsResponse getAllBouquetsResponse = soapService.getAllBouquetsResponse();
            getAllBouquetsResponse.getBouquet().stream().forEach(bouquet -> {
                logger.info("request: GetAllBouquets. response: " + bouquet.getId() + " " +
                        bouquet.getName() + " " + bouquet.getPrice());
            });

            AddBouquetResponse addBouquetResponse = soapService.addBouquetResponse("space rose", BigDecimal.valueOf(3000));
            logger.info("request: AddBouquet. response: id = " + addBouquetResponse.getId() + ", status " + addBouquetResponse.getMessage());

            Bouquet bouquet = new Bouquet();
            bouquet.setId(addBouquetResponse.getId());
            bouquet.setName("SPACE ROSE");
            bouquet.setPrice(BigDecimal.valueOf(5000));
            UpdateBouquetResponse updateBouquetResponse = soapService.updateBouquetResponse(bouquet);
            logger.info("request: UpdateBouquet. response: status " + updateBouquetResponse.getMessage());

            DeleteBouquetResponse deleteBouquetResponse = soapService.deleteBouquetResponse(addBouquetResponse.getId());
            logger.info("request: DeleteBouquet. response: status " + deleteBouquetResponse.getMessage());
        };
    }

}