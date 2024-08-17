package com.microservice.user.domain.producers;


import com.microservice.user.domain.dtos.EmailDTO;
import com.microservice.user.domain.entities.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    @Value(value = "${broker.queue.email.name}")
    private String routingKey;

    public void publishMessageEmail(User userModel) {
        var emailDto = new EmailDTO();
        emailDto.setId(userModel.getId());
        emailDto.setEmailTo(userModel.getEmail());
        emailDto.setSubject("Cadastro realizado com sucesso!");
        emailDto.setText(userModel.getUsername() + ", seja bem vindo(a)! \nAgradecemos o seu cadastro, aproveite agora todos os recursos da nossa plataforma!");

        rabbitTemplate.convertAndSend("", routingKey, emailDto);
    }
}
