import java.util.*;
class GpsSensor{
    private double MyLocation;
    public double getGPS(){}
}
class Bluetooth{
    private double MyBit;
    public double getBluetooth(){

    }
}
class Ultrasound{
    private double mchUltrasound;
    private double Times;
    public String IdentifyUltrasound() {
    }
    public double getUltrasound() {
    }

}
class Warning{
    public void useWarning(){

    }
}
class Controller{
    private double Times;
    private GpsSensor mygps;
    private Ultrasound UltraS;
    private double MyBluetooth;
    private boolean SOS;
    public double GetDetectHeartbeat(){}
}
class GUI{
    private boolean MySOS;
    private String Name;
    private GpsSensor MyGPS;
    private double MyHeartbeat;
    public boolean Openlens(){}
}
class UserDatabase{}
class DbController{}
class DetectHeartbeat{
    private double MyHeartbeat;
    public double getMyHeartbeat(){
        return MyHeartbeat;
    }
    public String CheckHeartbeat{
        double high_standard =100
        double low_standard =60
        if (MyHeartbeat > high_standard){
            print("您的心率過高")
        }
        else if(MyHeartbeat < low_standard){
            print("您的心率過低")
        }
    }
}
class Sos{
    private GUI Name;
    private double mygps;
    public void CallNumber(){}
    public void SendMessage(){

    }
}
class SosController{
    public double getlocation(){}
    public double IdentifySOS(){}
}
class Lens{}
public static void main(String[] args){
}
