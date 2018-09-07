/**
 * Created By: Md. Rashed Khan Menon
 * Created Date: 03/02/2018
 * Modified By:
 * Modified date:
 * (C) CopyRight Nybsys ltd.
 */
package com.nybsys.tillboxweb.controllers.accounting;

import com.nybsys.tillboxweb.constant.AccountModuleConstant;
import com.nybsys.tillboxweb.core.RequestHelper;
import com.nybsys.tillboxweb.core.RequestMessage;
import com.nybsys.tillboxweb.core.ResponseMessage;
import com.nybsys.tillboxweb.models.accounting.AccountModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static com.nybsys.tillboxweb.constant.WorkerPublishedConstants.WORKER_ACCOUNTING_MODULE_TOPIC;

@RestController
@RequestMapping(AccountModuleConstant.ACCOUNT_BASE_URL)
@Api(tags = "Accounting",value = AccountModuleConstant.ACCOUNT_CONTROLLER_NAME, description = AccountModuleConstant.ACCOUNT_CONTROLLER_DESCRIPTION)
public class AccountController {

    @ApiOperation(value = AccountModuleConstant.ACCOUNT_DROP_DOWN_DESCRIPTION, response = AccountModel.class)
    @RequestMapping(value = AccountModuleConstant.ACCOUNT_DROP_DOWN, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage getDropDown(@RequestBody RequestMessage requestMessage) throws MqttException {
        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(AccountModuleConstant.ACCOUNT_BASE_URL+AccountModuleConstant.ACCOUNT_DROP_DOWN, WORKER_ACCOUNTING_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock,publishedMessageId);

        return responseMessage;
    }
    @ApiOperation(value = AccountModuleConstant.ACCOUNT_CLASSIFICATION_GET_DESCRIPTION, response = AccountModel.class)
    @RequestMapping(value = AccountModuleConstant.ACCOUNT_CLASSIFICATION_GET, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage getAccountClassificationList(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(AccountModuleConstant.ACCOUNT_BASE_URL+AccountModuleConstant.ACCOUNT_CLASSIFICATION_GET, WORKER_ACCOUNTING_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock,publishedMessageId);

        return responseMessage;
    }
    @ApiOperation(value = AccountModuleConstant.ACCOUNT_SAVE_DESCRIPTION, response = AccountModel.class)
    @RequestMapping(value = AccountModuleConstant.SAVE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage save(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(AccountModuleConstant.ACCOUNT_BASE_URL+AccountModuleConstant.SAVE, WORKER_ACCOUNTING_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock,publishedMessageId);

        return responseMessage;
    }
    @ApiOperation(value = AccountModuleConstant.ACCOUNT_GET_DESCRIPTION, response = AccountModel.class)
    @RequestMapping(value = AccountModuleConstant.GET, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage get(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(AccountModuleConstant.ACCOUNT_BASE_URL+AccountModuleConstant.GET, WORKER_ACCOUNTING_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock,publishedMessageId);

        return responseMessage;
    }

    @ApiOperation(value = AccountModuleConstant.ACCOUNT_GET_DEACTIVE_ACCOUNT_DESCRIPTION, response = AccountModel.class)
    @RequestMapping(value = AccountModuleConstant.ACCOUNT_GET_DEACTIVE_ACCOUNT, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage getDeActive(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(AccountModuleConstant.ACCOUNT_BASE_URL+AccountModuleConstant.ACCOUNT_GET_DEACTIVE_ACCOUNT, WORKER_ACCOUNTING_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock,publishedMessageId);

        return responseMessage;
    }
    @ApiOperation(value =  AccountModuleConstant.ACCOUNT_GET_ACCOUNT_WITH_OPENING_BALANCE_DESCRIPTION)
    @RequestMapping(value = AccountModuleConstant.ACCOUNT_GET_ACCOUNT_WITH_OPENING_BALANCE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage getWithOpeningBalance(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(AccountModuleConstant.ACCOUNT_BASE_URL+AccountModuleConstant.ACCOUNT_GET_ACCOUNT_WITH_OPENING_BALANCE, WORKER_ACCOUNTING_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock,publishedMessageId);

        return responseMessage;
    }

    @ApiOperation(value =  AccountModuleConstant.ACCOUNT_GET_ROOT_ACCOUNT_DESCRIPTION,response = AccountModel.class)
    @RequestMapping(value = AccountModuleConstant.ACCOUNT_GET_ROOT_ACCOUNT, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage getRootAccount(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(AccountModuleConstant.ACCOUNT_BASE_URL+AccountModuleConstant.ACCOUNT_GET_ROOT_ACCOUNT, WORKER_ACCOUNTING_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock,publishedMessageId);

        return responseMessage;
    }

    @ApiOperation(value =  "", response = AccountModel.class)
    @RequestMapping(value = "parentAccountForSupplierPayment", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage parentAccountForSupplierPayment(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock("api/account/parentAccountForSupplierPayment", WORKER_ACCOUNTING_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock,publishedMessageId);

        return responseMessage;
    }

}
