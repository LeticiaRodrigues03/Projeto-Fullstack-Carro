import { Carro } from "./carro";
import { User } from "./user";

export class Curtida {
    id: number;
    user: User;
    carro: Carro;
    curtido: boolean;
}