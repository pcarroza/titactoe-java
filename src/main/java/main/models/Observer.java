package main.models;

public interface Observer {

    void initialize();

    void begin();

    void end();

    void exit();
}
