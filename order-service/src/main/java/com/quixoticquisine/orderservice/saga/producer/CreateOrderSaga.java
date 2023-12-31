package com.quixoticquisine.orderservice.saga.producer;

import com.quixoticquisine.commoneventuatekit.CreateTicketReply;
import com.quixoticquisine.orderservice.service.OrderMapper;
import io.eventuate.tram.sagas.orchestration.SagaDefinition;
import io.eventuate.tram.sagas.simpledsl.SimpleSaga;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CreateOrderSaga implements SimpleSaga<CreateOrderSagaData> {
    private final SagaDefinition<CreateOrderSagaData> sagaDefinition;

    CreateOrderSaga(ConsumerServiceProxy consumerServiceProxy,
                    OrderServiceProxy orderServiceProxy,
                    KitchenServiceProxy kitchenServiceProxy,
                    OrderMapper orderMapper) {
        sagaDefinition = step()
                .withCompensation(orderServiceProxy.rejectOrder, orderMapper::createOrderSagaDataToRejectOrderCommand)
                .step()
                .invokeParticipant(consumerServiceProxy.validateConsumer, orderMapper::createOrderSagaDataToValidateConsumerCommand)
                .step()
                .invokeParticipant(kitchenServiceProxy.createTicket, orderMapper::createOrderSagaDataToCreateTicketCommand)
                .onReply(CreateTicketReply.class, CreateOrderSagaData::handleCreateTicketReply)
                .build();
    }

    @Override
    public SagaDefinition<CreateOrderSagaData> getSagaDefinition() {
        return sagaDefinition;
    }
}
