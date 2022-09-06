import { User } from "./user";

export class Carro {
    qtdCurtida: number;
    id: number;
    nome!: string;
    descricao!: string;
    tipo!: string;
    user: User;
    
}