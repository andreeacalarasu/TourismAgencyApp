package model;

public enum TransportType {
    PERSONALCAR(1, "car"),
    PLANE(2, "plane"),
    BUS(3, "bus");

    private int id;
    private String transportName;

    TransportType(int id, String transportName){
        this.id = id;
        this.transportName = transportName;
    }
    public int getId(){
        return id;
    }
    public String getTransportName(){
        return transportName;
    }
}
