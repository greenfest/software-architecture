import {Point3D} from "./Point3D";

export class Poligon {
    private _points: Point3D[];

    constructor(points: Point3D[]) {
        this._points = points;
    }

    get points(): Point3D[] {
        return this._points;
    }

    set points(value: Point3D[]) {
        this._points = value;
    }
}