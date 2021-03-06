package lsp.parking;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ParkingTest {

    @Test
    public void accept() {
        Parking parking = new Parking();
        Machine truck = new Truck();
        Assert.assertTrue(parking.accept(truck));
    }

    @Test
    public void acceptAll() {
        Parking parking = new Parking();
        Machine truck = new Truck();
        Machine car = new Truck();
        List<Machine> allMashines = new ArrayList<>();
        allMashines.add(car);
        allMashines.add(truck);
        Assert.assertTrue(parking.acceptAll(allMashines));
    }

    @Test
    public void remove() {
        Parking parking = new Parking();
        Machine truck = new Truck();
        parking.accept(truck);
        Assert.assertTrue(parking.remove("123"));
    }
}