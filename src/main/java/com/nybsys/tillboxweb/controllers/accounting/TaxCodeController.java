
package com.nybsys.tillboxweb.controllers.accounting;

import com.nybsys.tillboxweb.constant.AccountModuleConstant;
import com.nybsys.tillboxweb.core.RequestHelper;
import com.nybsys.tillboxweb.core.RequestMessage;
import com.nybsys.tillboxweb.core.ResponseMessage;
import com.nybsys.tillboxweb.models.accounting.TaxCodeModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static com.nybsys.tillboxweb.constant.WorkerPublishedConstants.WORKER_USER_REGISTRATION_MODULE_TOPIC;

@RestController
@RequestMapping(AccountModuleConstant.TAX_CODE_BASE_URL)
@Api(tags = "Accounting", value = AccountModuleConstant.TAX_CODE_CONTROLLER_NAME, description = AccountModuleConstant.TAX_CODE_CONTROLLER_DESCRIPTION)
public class TaxCodeController {


    @ApiOperation(value = AccountModuleConstant.TAX_CODE_SAVE_DESCRIPTION, response = TaxCodeModel.class)
    @RequestMapping(value = AccountModuleConstant.SAVE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage save(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(AccountModuleConstant.TAX_CODE_BASE_URL + AccountModuleConstant.SAVE, WORKER_USER_REGISTRATION_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock, publishedMessageId);

        return responseMessage;
    }

    @ApiOperation(value = AccountModuleConstant.TAX_CODE_TYPE_GET_DESCRIPTION, response = TaxCodeModel.class)
    @RequestMapping(value = AccountModuleConstant.TAX_CODE_TYPE_GET, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage getByID(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(AccountModuleConstant.TAX_CODE_BASE_URL + AccountModuleConstant.TAX_CODE_TYPE_GET, WORKER_USER_REGISTRATION_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock, publishedMessageId);

        return responseMessage;
    }

    @ApiOperation(value = AccountModuleConstant.TAX_CODE_GET_DESCRIPTION, response = TaxCodeModel.class)
    @RequestMapping(value = AccountModuleConstant.GET, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage search(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(AccountModuleConstant.TAX_CODE_BASE_URL + AccountModuleConstant.GET, WORKER_USER_REGISTRATION_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock, publishedMessageId);

        return responseMessage;
    }

}
