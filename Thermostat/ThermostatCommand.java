package Thermostat;

import Controller.Command;
import Controller.CentralHub;

abstract class ThermostatCommand implements Command{
    protected Thermostat thermostat;
    public ThermostatCommand(Thermostat thermostat){
        this.thermostat = thermostat;
    }
}
