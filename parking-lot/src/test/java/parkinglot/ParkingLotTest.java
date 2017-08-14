package parkinglot;
import executor.ParkExecutor;
import executor.ParkingLotExecutor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class ParkingLotTest {

    ParkingLotExecutor parkingLot = new ParkingLotExecutor();
    ParkExecutor park = new ParkExecutor();

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void createParkingLot() throws Exception {
        parkingLot.execute("create_parking_lot 6");
        assertEquals(6, parkingLot.getSlots().length);
    }


}
