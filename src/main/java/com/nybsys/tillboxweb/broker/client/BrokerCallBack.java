/**
 * Created By: Md. Nazmus Salahin
 * Created Date: 5/11/2018
 * Time: 8:33 PM
 * Modified By:
 * Modified date:
 * (C) CopyRight Nybsys ltd.
 */

package com.nybsys.tillboxweb.broker.client;

import com.nybsys.tillboxweb.core.Core;
import com.nybsys.tillboxweb.core.ResponseMessage;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class BrokerCallBack implements MqttCallback {
    private static final Logger log = LoggerFactory.getLogger(BrokerCallBack.class);
    private static final Object lock = new Object();
    private static final Integer sleepTime = 5;
    private static final Long milliSeconds = TimeUnit.MILLISECONDS.convert(sleepTime, TimeUnit.SECONDS);
    private static ResponseMessage responseMessage;
    private BrokerSubscriber subscriber;

    @Override
    public void connectionLost(Throwable cause) {
        Boolean isClientWithBroker;
        log.error("Connection to MQTT broker lost!");
        //Core.responseCollection.clear();
        Object lock = new Object();
        this.subscriber = new BrokerSubscriber();
        //Re - try to connect with broker
        try {
            do{
                synchronized (lock) {
                    //Wait for 5 second
                    lock.wait(milliSeconds);
                    isClientWithBroker = this.subscriber.subscribe();
                }
            }while (!isClientWithBroker);

        }catch (Exception ex){
            log.error(ex.getMessage());
        }
    }

    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {
        String incomingMessage = new String(message.getPayload());

        if (incomingMessage == null)
            throw new Exception();

        responseMessage = Core.jsonMapper.readValue(incomingMessage, ResponseMessage.class);



        try {

            synchronized (lock) {
                //Core.responseCollection.put(this.responseMessage.brokerMessageId, this.responseMessage);
                //log.info("======== In new lock ===========");
                this.lock.notifyAll();
                //log.info("======== Lock release new ======");
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        log.info("======== Message Delivered ===========");
    }

   /* public ResponseMessage getResponseMessage() {
        return this.responseMessage;
    }*/

    public static ResponseMessage getResponseMessage() {
        return responseMessage;
    }

    public static Object getLock() {
        return lock;
    }
}
