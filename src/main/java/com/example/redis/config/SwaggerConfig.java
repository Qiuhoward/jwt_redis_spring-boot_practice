package com.example.redis.config;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(info = @Info(title = "標題" ,version = "版本",description = "描述"),externalDocs = @ExternalDocumentation(description = "參考資料",url="網址"),servers = @Server(url =""))
@SecurityScheme(type= SecuritySchemeType.HTTP,name = "JWT",scheme = "bearer",in = SecuritySchemeIn.HEADER)
public class SwaggerConfig {


}


