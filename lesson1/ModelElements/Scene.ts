import {PoligonalModel} from "./PoligonalModel";
import {Flash} from "./Flash";

class Scene {
    private _id: number;
    private _models: PoligonalModel[];
    private _Flashes: Flash;

    constructor(models: PoligonalModel[], Flashes: Flash) {
        this._models = models;
        this._Flashes = Flashes;
    }

    get id(): number {
        return this._id;
    }

    get models(): PoligonalModel[] {
        return this._models;
    }

    set models(value: PoligonalModel[]) {
        this._models = value;
    }

    get Flashes(): Flash {
        return this._Flashes;
    }

    set Flashes(value: Flash) {
        this._Flashes = value;
    }

    public method1(object: object): object {
        return object;
    }

    public method2(object1: object, object2: object): object[] {
        return [object1, object2];
    }
}