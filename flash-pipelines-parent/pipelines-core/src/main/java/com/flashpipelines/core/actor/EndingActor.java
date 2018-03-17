package com.flashpipelines.core.actor;

import akka.actor.AbstractActor;
import com.flashpipelines.core.Envelope;
import com.flashpipelines.core.Service;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class EndingActor extends AbstractActor {

    private final Service service;

    public EndingActor(Service service) {
        this.service = service;
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
            .match(Envelope.class, service::apply)
            .build();
    }
}
