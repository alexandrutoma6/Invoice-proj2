package ro.alex;

public class DataProcessing {

    public static Address addressProcessing(String string){
        String[] buffer = string.split(" ");
        Address address = new Address(buffer[0],buffer[1],Integer.parseInt(buffer[2]));
        return address;
    }

    public static Date_alex dateProcessing(String string){
        String[] buffer2 = string.split("\\.");
        Date_alex date = new Date_alex(Integer.parseInt(buffer2[0]),Integer.parseInt(buffer2[1]),Integer.parseInt(buffer2[2]));
        return date;
    }
}
