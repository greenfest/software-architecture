import {IModelChanger} from "./IModelChanger";
import {IModelChangeObserver} from "./IModelChangeObserver";
import {PoligonalModel} from "../ModelElements/PoligonalModel";
import {Flash} from "../ModelElements/Flash";
import {Camera} from "../ModelElements/Camera";

export class ModelStore implements IModelChanger, IModelChangeObserver {
    private _models: PoligonalModel[];
    private _flashes: Flash[];
    private _cameras: Camera[];

    constructor(models: PoligonalModel[], flashes: Flash[], cameras: Camera[]) {
        this._models = models;
        this._flashes = flashes;
        this._cameras = cameras;
    }

    get models(): PoligonalModel[] {
        return this._models;
    }

    set models(value: PoligonalModel[]) {
        this._models = value;
    }

    get flashes(): Flash[] {
        return this._flashes;
    }

    set flashes(value: Flash[]) {
        this._flashes = value;
    }

    get cameras(): Camera[] {
        return this._cameras;
    }

    set cameras(value: Camera[]) {
        this._cameras = value;
    }

    public notifyChange(): void {
    }

    public applyUpdateModel(): void {
    }

}