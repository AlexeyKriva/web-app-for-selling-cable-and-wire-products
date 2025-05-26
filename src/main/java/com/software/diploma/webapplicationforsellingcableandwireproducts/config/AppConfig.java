package com.software.diploma.webapplicationforsellingcableandwireproducts.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Web-app API",
                description = "web app for selling cable and wire products",
                contact = @Contact(
                        name = "Mikhail Korotkiy",
                        email = "mktoto.test@gmail.com"
                )
        )
)
public class AppConfig {

}
