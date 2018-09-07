/**
 * Created By: Md. Nazmus Salahin
 * Created Date: 5/11/2018
 * Time: 9:32 PM
 * Modified By:
 * Modified date:
 * (C) CopyRight Nybsys ltd.
 */

package com.nybsys.tillboxweb.broker.client;

import com.nybsys.tillboxweb.appenum.TillBoxAppEnum;
import com.nybsys.tillboxweb.core.Core;
import com.nybsys.tillboxweb.core.RequestMessage;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BrokerMessagePublisher extends Core {
    private static final Logger log = LoggerFactory.getLogger(BrokerMessagePublisher.class);

    private String messageId;
    private String jsonString;
    private MqttMessage mqttMessage;

    private static MqttClient mqttClient;
    private String publishedTopic;

    static {
        try {
            mqttClient = MqttUtils.getMqttClient();
        } catch (Exception e) {
            log.error("Exception from Api Controller Publisher");
            e.printStackTrace();
        }
    }

    public void publishedMessageToBroker(String serviceName, RequestMessage requestMessage) {
        requestMessage.brokerMessage.messageId = this.messageId;
        requestMessage.brokerMessage.serviceName = serviceName;
        System.out.println("Request Service url : "+ serviceName);

        requestMessage.brokerMessage.qos = QoS;
        requestMessage.brokerMessage.requestFrom =
                TillBoxAppEnum.BrokerRequestType.API_CONTROLLER.get();
        try {
            jsonString = Core.jsonMapper.writeValueAsString(requestMessage);

            this.mqttMessage = MqttUtils.getMqttDefaultMessage();
            this.mqttMessage.setPayload(jsonString.getBytes());

            mqttClient.publish(this.publishedTopic, this.mqttMessage);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void setPublishedTopic(String publishedTopic) {
        this.publishedTopic = publishedTopic;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }
}
