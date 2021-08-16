package application;

import models.Car;
import models.User;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDataProvider {

    @DataProvider
    public Iterator<Object[]> createCarCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/createCar.csv"));
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(";");
            list.add(new Object[]{new Car().setAddress(split[0]).setMake(split[1]).setModel(split[2])
                    .setYear(split[3]).setEngine(split[4]).setFuel(split[5]).setGear(split[6])
                    .setWD(split[7]).setDoors(split[8]).setSeats(split[9]).setClasS(split[10])
                    .setFuelConsumption(split[11]).setCarRegNumber(split[12]).setPrice(split[13])
                    .setDistanceIncluded(split[14]).setTypeFeature(split[15])
                    .setAbout(split[16])});
            line = reader.readLine();
        }

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[] > validLoginDP() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"sym00@gmail.com","Pa$$gmailc0m"});
        list.add(new Object[]{"sym01@gmail.com","1Pa$$gmailc0m"});
        list.add(new Object[]{"sym02@gmail.com","Pa$$gmailc0m"});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> validLoginDPCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/login.csv"));
        String line = reader.readLine();
        while(line != null) {
           String[] split = line.split(";");
           list.add(new Object[]{new User().withEmail(split[0]).withPassword(split[1])});
            line = reader.readLine();
        }
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[] > validDataRegistrationDPClass() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Symba","King","sym03@gmail.com","Pa$$gmailc0m"});
        list.add(new Object[]{"Symba","King","sym04@gmail.com","Pa$$gmailc0m"});
        list.add(new Object[]{"Symba","King","sym05@gmail.com","Pa$$gmailc0m"});

        return list.iterator();
    }


    @DataProvider
    public Iterator<Object[] > registrationCSV()throws IOException {
        List<Object[]> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/reg.csv")));
        String line = reader.readLine();  //Lion;King2;pass@gmail.com;Pa$$gmailc0m
        while(line != null) {
            String[] split = line.split(";");
            list.add(new Object[]{new User().withName(split[0])
                    .withLastName(split[1])
                    .withEmail(split[2])
                    .withPassword(split[3])});
            line = reader.readLine();
        }
        return list.iterator();
    }
}