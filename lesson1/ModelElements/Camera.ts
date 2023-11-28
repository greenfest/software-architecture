import {Point3D} from "./Point3D";
import {Angle3D} from "./Angle3D";

export class Camera {
    private _location: Point3D;
    private _angle: Angle3D;

    constructor(location: Point3D, angle: Angle3D) {
        this._location = location;
        this._angle = angle;
    }

    get location(): Point3D {
        return this._location;
    }

    set location(value: Point3D) {
        this._location = value;
    }

    get angle(): Angle3D {
        return this._angle;
    }

    set angle(value: Angle3D) {
        this._angle = value;
    }

    public rotate(angle: Angle3D): void {}
    public move(point: Point3D): void {}

}