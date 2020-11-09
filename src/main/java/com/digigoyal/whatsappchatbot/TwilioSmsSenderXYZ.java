package com.digigoyal.whatsappchatbot;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("twilioxyz")
public class TwilioSmsSenderXYZ implements SmsSender{
    private final TwilioConfiguration twilioConfiguration;
    private static final Logger LOGGER= LoggerFactory.getLogger(TwilioSmsSenderXYZ.class);

    @Autowired
    public TwilioSmsSenderXYZ(TwilioConfiguration twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
    }

    @Override
    public void sendSms(SmsRequest smsRequest) {
        if(isPhoneNumberValid()) {
            PhoneNumber to = new PhoneNumber(smsRequest.getPhoneNumber());
            PhoneNumber from = new PhoneNumber(twilioConfiguration.getTrailNumber());
            String message = smsRequest.getMessage()+"XYZ";
            MessageCreator creator = Message.creator(to, from, message);
            creator.create();
            LOGGER.info("Send sms {}"+smsRequest);
        }
        else{
            throw new IllegalArgumentException("Phone Number ["+smsRequest.getPhoneNumber()+"] is not a valid Number.");
        }



    }

    private boolean isPhoneNumberValid() {
        //TODO: Implement phone number validator
        return true;
    }
}

