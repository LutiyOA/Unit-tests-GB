package seminars.second.hw;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import second.hw.Car;
import second.hw.Motorcycle;
import second.hw.Vehicle;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {
    Car car = null;
    Motorcycle motorcycle = null;

    @BeforeEach
    public void createObjects() {
        car = new Car("Hyundai", "Solaris", 2012);
        motorcycle = new Motorcycle("Harley Davidson", "Speedy", 2006);
    }

    @Test
    public void allTests() {
//        - проверка того, что экземпляр объекта Car также является экземпляром транспортного средства; (instanceof)
        assertInstanceOf(Vehicle.class, car);

//        - проверка того, объект Car создается с 4-мя колесами
        assertEquals(4, car.getNumWheels());

//        - проверка того, объект Motorcycle создается с 2-мя колесами
        assertEquals(2, motorcycle.getNumWheels());

//        - проверка того, объект Car развивает скорость 60 в режиме тестового вождения (testDrive())
        car.testDrive();
        assertEquals(60,car.getSpeed());

//        - проверка того, объект Motorcycle развивает скорость 75 в режиме тестового вождения (testDrive())
        motorcycle.testDrive();
        assertEquals(75,motorcycle.getSpeed());

//        - проверить, что в режиме парковки (сначала testDrive, потом park, т.е эмуляция движения транспорта) машина останавливается (speed = 0)
        car.testDrive();
        car.park();
        assertEquals(0,car.getSpeed());

//        - проверить, что в режиме парковки (сначала testDrive, потом park  т.е эмуляция движения транспорта) мотоцикл останавливается (speed = 0)
        motorcycle.testDrive();
        motorcycle.park();
        assertEquals(0,motorcycle.getSpeed());

    }

}