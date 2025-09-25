package Thermostat;

import Controller.Command;

public class ThermostatDecreaseCommand implements Command {
    private Thermostat thermostat;
    private int degrees;

    public ThermostatDecreaseCommand(Thermostat thermostat, int degrees) {
        this.thermostat = thermostat;
        this.degrees = degrees;
    }

    @Override
    public void execute() {
        thermostat.decreaseTemperature(degrees);
    }

    @Override
    public void undo() {
        thermostat.increaseTemperature(degrees);
    }
}