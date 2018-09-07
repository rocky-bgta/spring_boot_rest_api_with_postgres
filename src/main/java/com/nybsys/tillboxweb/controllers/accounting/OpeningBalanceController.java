
package com.nybsys.tillboxweb.controllers.accounting;

import com.nybsys.tillboxweb.constant.AccountModuleConstant;
import com.nybsys.tillboxweb.core.RequestHelper;
import com.nybsys.tillboxweb.core.RequestMessage;
import com.nybsys.tillboxweb.core.ResponseMessage;
import com.nybsys.tillboxweb.models.accounting.OpeningBalanceModel;
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
@RequestMapping(AccountModuleConstant.OPENING_BALANCE_BASE_URL)
@Api(tags = "Accounting", value = AccountModuleConstant.OPENING_BALANCE_CONTROLLER_NAME, description = AccountModuleConstant.OPENING_BALANCE_CONTROLLER_DESCRIPTION)
public class OpeningBalanceController {

    @ApiOperation(value = AccountModuleConstant.OPENING_BALANCE_GET_BY_ACCOUNTID_DESCRIPTION, response = OpeningBalanceModel.class)
    @RequestMapping(value = AccountModuleConstant.OPENING_BALANCE_GET_BY_ACCOUNTID, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage getDropDown(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(AccountModuleConstant.OPENING_BALANCE_BASE_URL + AccountModuleConstant.OPENING_BALANCE_GET_BY_ACCOUNTID, WORKER_ACCOUNTING_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock, publishedMessageId);

        return responseMessage;
    }

    @ApiOperation(value = AccountModuleConstant.OPENING_BALANCE_GET_BY_BUSINESSID_DESCRIPTION, response = OpeningBalanceModel.class)
    @RequestMapping(value = AccountModuleConstant.OPENING_BALANCE_GET_BY_BUSINESSID, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage getAccountClassificationList(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(AccountModuleConstant.OPENING_BALANCE_BASE_URL + AccountModuleConstant.OPENING_BALANCE_GET_BY_BUSINESSID, WORKER_ACCOUNTING_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock, publishedMessageId);

        return responseMessage;
    }


    @ApiOperation(value = AccountModuleConstant.OPENING_BALANCE_SAVE_BY_BUSINESSID_DESCRIPTION, response = OpeningBalanceModel.class)
    @RequestMapping(value = AccountModuleConstant.SAVE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage save(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(AccountModuleConstant.OPENING_BALANCE_BASE_URL + AccountModuleConstant.SAVE, WORKER_ACCOUNTING_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock, publishedMessageId);

        return responseMessage;
    }

    @ApiOperation(value = "Search opening balance", response = OpeningBalanceModel.class)
    @RequestMapping(value = AccountModuleConstant.SEARCH, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage search(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(AccountModuleConstant.OPENING_BALANCE_BASE_URL + AccountModuleConstant.SEARCH, WORKER_ACCOUNTING_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock, publishedMessageId);

        return responseMessage;
    }

    @ApiOperation(value = AccountModuleConstant.OPENING_BALANCE_OF_ITEM_SAVE_DESCRIPTION, response = OpeningBalanceModel.class)
    @RequestMapping(value = AccountModuleConstant.OPENING_BALANCE_OF_ITEM_SAVE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage itemOpeningBalanceSave(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(AccountModuleConstant.OPENING_BALANCE_BASE_URL + AccountModuleConstant.OPENING_BALANCE_OF_ITEM_SAVE, WORKER_ACCOUNTING_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock, publishedMessageId);

        return responseMessage;
    }

    @ApiOperation(value = AccountModuleConstant.OPENING_BALANCE_DELETE_DESCRIPTION, response = OpeningBalanceModel.class)
    @RequestMapping(value = AccountModuleConstant.DELETE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage delete(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(AccountModuleConstant.OPENING_BALANCE_BASE_URL + AccountModuleConstant.DELETE, WORKER_ACCOUNTING_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock, publishedMessageId);

        return responseMessage;
    }

}
