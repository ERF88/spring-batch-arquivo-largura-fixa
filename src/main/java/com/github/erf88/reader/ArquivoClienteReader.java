package com.github.erf88.reader;

import com.github.erf88.model.in.ClienteIn;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.transform.Range;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class ArquivoClienteReader {

    @Value("${spring.batch.file.clientes.in}")
    private Resource resource;

    @StepScope
    @Bean
    public FlatFileItemReader<ClienteIn> clienteReader() {
        return new FlatFileItemReaderBuilder<ClienteIn>()
                .name("clienteReader")
                .resource(resource)
                .fixedLength()
                .columns(new Range[]{ new Range(1, 10), new Range(11, 30), new Range(31, 50), new Range(51, 90), new Range(91, 100) })
                .names(new String[] {  "id", "nome", "sobrenome", "email", "status" })
                .targetType(ClienteIn.class)
                .build();
    }

}
