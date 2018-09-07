package com.nybsys.tillboxweb.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.nybsys.tillboxweb.broker.client.BrokerCallBack;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public abstract class Core {

    public static final AtomicLong numberOfRequestServe = new AtomicLong(0);

    public static final AtomicLong numberOfRequestServeNotServe = new AtomicLong(0);

    public static final Integer allowedTime = 59000;//TillBoxAppConstant.allowedTime;

    //public final Integer allowedTime = 10000;
    private final Long nanoSecond = TimeUnit.NANOSECONDS.convert(allowedTime, TimeUnit.MILLISECONDS);

    public static final int QoS=0;

    public static final List<String> messageIdList; //= new ArrayList<>();

    public static final Map<String,ResponseMessage> responseCollection;

    private ArrayList finishingOrder;

    static
    {
        messageIdList = Collections.synchronizedList(new ArrayList<String>());
        responseCollection = Collections.synchronizedMap(new HashMap<String, ResponseMessage>());
    }
    //public final static List<Condition> brokerMessageIdList = new ArrayList<>();
    public final static ObjectMapper jsonMapper = new ObjectMapper().configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);;
    public final static BrokerCallBack brokerCallBack = new BrokerCallBack();
    //public final static Object brokerLockObject = new Object();
    // A common lock for synchronization
    public final static Lock callBackLock = new ReentrantLock();
    //public static Condition joeArrival = callBackLock.newCondition();
    public final static Object callBackRemoveLock = new Object();

    public static final ConcurrentHashMap<String, Condition> clientLockWithMessageId = new ConcurrentHashMap<String, Condition>();

    public String getUUID(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString()+System.nanoTime();
    }

    public boolean isResponseWithInAllowedTime(long startTime) {
        return isResponseWithInAllowedTime(startTime, this.allowedTime);
    }

    public boolean isResponseWithInAllowedTime(long startTime, long allowedTime) {
        Long nanoSecond = TimeUnit.NANOSECONDS.convert(allowedTime,TimeUnit.MILLISECONDS);
        if ((System.nanoTime() - startTime) > nanoSecond)
            return false;
        else
            return true;
    }
}
