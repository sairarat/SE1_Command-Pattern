package Thermostat;

import Controller.Command;

public class ThermostatIncreaseCommand implements Command {
    private Thermostat thermostat;
    private int degrees;

    public ThermostatIncreaseCommand(Thermostat thermostat, int degrees) {
        this.thermostat = thermostat;
        this.degrees = degrees;
    }

    @Override
    public void execute() {
        thermostat.increaseTemperature(degrees);
    }

    @Override
    public void undo() {
        thermostat.decreaseTemperature(degrees);
    }
}