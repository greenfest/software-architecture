import { Poligon } from "./Poligon";
import { Texture } from "./Texture";

export class PoligonalModel {
    private _poligons: Poligon[];
    private _textures: Texture[];
    constructor(poligons: Poligon[], textures: Texture[]) {
        this._poligons = poligons;
        this._textures = textures;
    }

    get poligons(): Poligon[] {
        return this._poligons;
    }

    set poligons(value: Poligon[]) {
        this._poligons = value;
    }

    get textures(): Texture[] {
        return this._textures;
    }

    set textures(value: Texture[]) {
        this._textures = value;
    }
}