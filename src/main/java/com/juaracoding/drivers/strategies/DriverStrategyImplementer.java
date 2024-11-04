package com.juaracoding.drivers.strategies;

public class DriverStrategyImplementer {

    public static DriverStrategy chooseStrategy(String strategy){
        return switch (strategy){
          case "chrome" -> new Chrome();
          case "firefox" -> new Firefox();
            default -> null;
        };
    }
}
