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
import com.nybsys.tillboxweb.models.accounting.CombineAccountModel;
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
@RequestMapping(AccountModuleConstant.COMBINE_ACCOUNT_BASE_URL)
@Api(tags = "Accounting",value = AccountModuleConstant.COMBINE_ACCOUNT_CONTROLLER_NAME, description = AccountModuleConstant.COMBINE_ACCOUNT_CONTROLLER_DESCRIPTION)
public class CombineAccountController {

    @ApiOperation(value = AccountModuleConstant.COMBINE_ACCOUNT_SAVE_DESCRIPTION, response = CombineAccountModel.class)
    @RequestMapping(value = AccountModuleConstant.SAVE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage save(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(AccountModuleConstant.COMBINE_ACCOUNT_BASE_URL+AccountModuleConstant.SAVE, WORKER_ACCOUNTING_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock,publishedMessageId);

        return responseMessage;
    }

    @ApiOperation(value = AccountModuleConstant.COMBINE_ACCOUNT_GET_DESCRIPTION, response = CombineAccountModel.class)
    @RequestMapping(value = AccountModuleConstant.GET_BY_ID, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage getByID(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(AccountModuleConstant.COMBINE_ACCOUNT_BASE_URL+AccountModuleConstant.GET_BY_ID, WORKER_ACCOUNTING_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock,publishedMessageId);

        return responseMessage;
    }

    @ApiOperation(value = AccountModuleConstant.COMBINE_ACCOUNT_SEARCH_DESCRIPTION, response = CombineAccountModel.class)
    @RequestMapping(value = AccountModuleConstant.SEARCH, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage search(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(AccountModuleConstant.COMBINE_ACCOUNT_BASE_URL+AccountModuleConstant.SEARCH, WORKER_ACCOUNTING_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock,publishedMessageId);

        return responseMessage;
    }

}
