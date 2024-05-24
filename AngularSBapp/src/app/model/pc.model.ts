import { Marque } from "./marque.model";
import { User } from "./user.model";

export class Pc {
    idPc? : number;
    processeurPc? : string;
    nomPc? : string;
    memoirePc? : number;
    diqueDurPc? : number;
    prixPc? : number;
    marque? : Marque;
    user? : User;
    }
    