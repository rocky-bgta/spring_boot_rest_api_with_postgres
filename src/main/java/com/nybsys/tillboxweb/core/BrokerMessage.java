/**
 * Created By: Md. Nazmus Salahin
 * Created Date: 22-Dec-17
 * Time: 11:58 AM
 * Modified By:
 * Modified date:
 * (C) CopyRight Nybsys ltd.
 */
package com.nybsys.tillboxweb.core;

public class BrokerMessage {

    public BrokerMessage(){
        super();
        this.qos=0;
    }

    public String topicId;
    public String serviceName;
    public int qos;
    public String messageId;
    public int requestFrom;
}
