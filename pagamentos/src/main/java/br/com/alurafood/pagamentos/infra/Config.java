package br.com.alurafood.pagamentos.infra;

import br.com.alurafood.pagamentos.http.PedidoClient;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

}
