package com.github.erf88.writer;

import com.github.erf88.model.out.ClienteOut;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class ArquivoClienteWriter {

    @Value("${spring.batch.file.clientes.out}")
    private Resource resource;

    @Bean
    public FlatFileItemWriter<ClienteOut> clienteWriter() {

        return new FlatFileItemWriterBuilder<ClienteOut>()
                .name("clienteWriter")
                .resource(resource)
                .formatted()
                .format("%-9d %-40s %-40s %-9s")
                .names(new String[] {  "id", "nomeCompleto", "email", "dataProcessamento" })
                .build();

    }

}
