package com.digigoyal.whatsappchatbot;


import com.twilio.Twilio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;



@Configuration
public class TwilioInitializer {

    private final static Logger LOGGER=  LoggerFactory.getLogger(TwilioInitializer.class);

    private TwilioConfiguration twilioConfiguration;
    @Autowired
    public TwilioInitializer(TwilioConfiguration twilioConfiguration)
    {
        this.twilioConfiguration=twilioConfiguration;
        Twilio.init(twilioConfiguration.getAccountSid(),twilioConfiguration.getAuthToken());
        LOGGER.info("Twilio intialized  ... with account sid {}", twilioConfiguration.getAccountSid());

    }

}
