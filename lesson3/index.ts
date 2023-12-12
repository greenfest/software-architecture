enum Color {
    Red,
    Green,
    Blue,
}

enum CarType {
    Sedan,
    Hatchback,
    Pickup,
    Sport,
}

enum FuelType {
    Gasoline,
    Diesel,
}

enum GearboxType {
    AT,
    MT,
}

interface Refueling {
    fuel(type: FuelType): void;
}

interface Driving {
    movement(): void;
}

interface Maintenance {
    maintenance(): void;
}

interface LightsControl {
    switchHeadlights(): boolean;
    switchFogLights(): boolean;
}

interface WipersControl {
    switchWipers(): boolean;
}

interface CargoTransportation {
    transportCargo(): void;
}

interface Sweeper {
    sweepStreet(): void;
}



interface Car extends Refueling, Driving, Maintenance, LightsControl, WipersControl {}

interface CarWash {
    wash(): void;
}


abstract class AbstractCar implements Car {
    private refueling: Refueling | null = null;
    private fogLights: boolean = false;

    constructor(
        private make: string,
        private model: string,
        private color: Color,
        protected type: CarType,
        protected wheelsCount: number = 4,
        protected fuelType: FuelType = FuelType.Diesel,
        private gearboxType?: GearboxType,
        private engineCapacity?: number
    ) {}

    setRefuelingStation(refuelingStation: Refueling): void {
        this.refueling = refuelingStation;
    }

    fuel(): void {
        if (this.refueling !== null) {
            this.refueling.fuel(this.fuelType);
        }
    }

    abstract movement(): void;
    abstract maintenance(): void;
    abstract switchHeadlights(): boolean;
    abstract switchWipers(): boolean;

    switchFogLights(): boolean {
        this.fogLights = !this.fogLights;
        return this.fogLights;
    }
}

class ConcreteCar extends AbstractCar {
    switchHeadlights(): boolean {
        return false;
    }

    switchWipers(): boolean {
        return false;
    }

    movement(): void {
    }

    maintenance(): void {
    }
}

class ConcreteCarWithThreeWheels extends AbstractCar {
    constructor(
        make: string,
        model: string,
        color: Color,
        type: CarType,
        fuelType: FuelType,
        gearboxType: GearboxType,
        engineCapacity: number
    ) {
        super(make, model, color, type, 3, fuelType, gearboxType, engineCapacity);
    }

    switchHeadlights(): boolean {
        return false;
    }

    switchWipers(): boolean {
        return false;
    }

    movement(): void {
    }

    maintenance(): void {
    }
}

class CarService implements Refueling, LightsControl, WipersControl {
    fuel(type: FuelType): void {
    }

    switchHeadlights(): boolean {
        return false;
    }

    switchWipers(): boolean {
        return false;
    }

    switchFogLights(): boolean {
        return false;
    }
}

class CarWashStation implements CarWash {

    switchHeadlights(): boolean {
        return false;
    }

    switchWipers(): boolean {
        return false;
    }

    wipeWindshield(): void {
    }

    wipeHeadlights(): void {
    }

    wipeMirrors(): void {
    }

    wash(): void {
    }
}

// Пример использования:

const car = new ConcreteCar(
    "Toyota",
    "Camry",
    Color.Blue,
    CarType.Sedan,
    4,
    FuelType.Gasoline,
    GearboxType.AT,
    2.5
);

const threeWheelsCar = new ConcreteCarWithThreeWheels(
    "SomeBrand",
    "ThreeWheeler",
    Color.Red,
    CarType.Pickup,
    FuelType.Diesel,
    GearboxType.MT,
    1.2
);

const serviceStation = new CarService();

const carWashStation = new CarWashStation();

car.setRefuelingStation(serviceStation);
threeWheelsCar.setRefuelingStation(serviceStation);

car.fuel();
threeWheelsCar.fuel();
car.maintenance();
threeWheelsCar.maintenance();

serviceStation.switchHeadlights();
serviceStation.switchWipers();

carWashStation.wash();
carWashStation.wipeWindshield();
carWashStation.wipeHeadlights();
carWashStation.wipeMirrors();
