package com.nybsys.tillboxweb.broker.client;

import com.nybsys.tillboxweb.core.Core;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BrokerSubscriber extends Core {

    private static final Logger log = LoggerFactory.getLogger(BrokerSubscriber.class);

    private BrokerCallBack brokerCallBack;


    public Boolean subscribe() {
        Boolean isConnected = false;
        String subscribeTopic = "till_box_web_api";
        this.brokerCallBack = new BrokerCallBack();

        try {
            MqttClient mqttClient = MqttUtils.getMqttClient();
            mqttClient.setCallback(this.brokerCallBack);
            mqttClient.subscribe(subscribeTopic, QoS);
            isConnected = true;
            log.info("== Subscribe To Broker ==");
        } catch (Exception ex) {
            log.error("Exception from Subscriber");
            ex.printStackTrace();
        }
        return isConnected;
    }
}