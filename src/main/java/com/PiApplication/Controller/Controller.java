package com.PiApplication.Controller;

import com.pi4j.io.gpio.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    boolean light = false;


    @RequestMapping("/")
    public String test(){
        return "Program On";
    }
   GpioPinDigitalOutput pin00;


    @RequestMapping("/light")
    public String power() {
        if (pin00 == null){
            GpioController gpio = GpioFactory.getInstance();
            GpioPinDigitalOutput pin01 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, "My Led", PinState.LOW);
        }
        pin00.toggle();
        if(!light){
            light = true;
            return "Light on";
        }else {
                light = false;
                return "Light off";
            }

        }

}




