/**
 * Created By: Md. Nazmus Salahin
 * Created Date: 17-Jan-18
 * Time: 11:28 AM
 * Modified By:
 * Modified date:
 * (C) CopyRight Nybsys ltd.
 */
package com.nybsys.tillboxweb.core;

import com.nybsys.tillboxweb.broker.client.BrokerCallBack;
import com.nybsys.tillboxweb.broker.client.BrokerMessagePublisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestHelper extends Core {
    //private static final Logger log = LoggerFactory.getLogger(RequestHelper.class);
    private String publishedMessageId;
    private String responseServiceName;

    public Object getLock(String serviceUrl, String publishedTopic, RequestMessage requestMessage) {
        this.publishedMessageId = this.getUUID();
        this.responseServiceName = serviceUrl;
        System.out.println("Request Service url: "+ serviceUrl);
        Object lock = BrokerCallBack.getLock();
        BrokerMessagePublisher brokerMessagePublisher = new BrokerMessagePublisher();
        brokerMessagePublisher.setMessageId(this.publishedMessageId);
        brokerMessagePublisher.setPublishedTopic(publishedTopic);
        brokerMessagePublisher.publishedMessageToBroker(serviceUrl, requestMessage);
        return lock;
    }

    public ResponseMessage getResponse(Object lock, String publishedMessageId) {
        ResponseMessage responseMessage = null;
        Boolean workCompleteWithInAllowTime;
        //String responseMessageId;
        Boolean foundResponse = false;
        try {
            long startTime = System.nanoTime();

            do {
                synchronized (lock) {
                    lock.wait(60000);//31 second
                    workCompleteWithInAllowTime = this.isResponseWithInAllowedTime(startTime, 59000);
                    //If response don't get with in allowed time then discarded
                    if (!workCompleteWithInAllowTime) {
                        responseMessage = new ResponseMessage();
                        responseMessage.message = "Sorry server busy try again later";
                        responseMessage.responseCode = 404;
                        responseMessage.brokerMessageId = publishedMessageId;
                        responseMessage.responseObj = null;
                        System.out.println("Sorry to serve service url: "+ this.responseServiceName);
                        //Core.responseCollection.remove(publishedMessageId);
                        break;
                    }

                    responseMessage = BrokerCallBack.getResponseMessage();
                    if (publishedMessageId.equals(responseMessage.brokerMessageId)) {
                        foundResponse = true;
                        System.out.println("Response Service url: "+ this.responseServiceName);
                    }
                }

                //System.out.println("Loop continue for messageID: " + publishedMessageId);
            } while (!foundResponse);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //Core.responseCollection.remove(publishedMessageId);
            //System.out.println("Serve request: " + responseMessage.brokerMessageId);
        }
        return responseMessage;
    }

    public String getPublishedMessageId() {
        return publishedMessageId;
    }

    /*@Override
    public void finalize() {
        System.out.println("Garbage Called");
    }*/
}
