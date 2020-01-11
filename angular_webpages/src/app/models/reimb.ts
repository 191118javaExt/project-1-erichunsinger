import { Timestamp } from 'rxjs';

export class Reimb {

    amount: number;
    type: string;
    status: string;
    description: string;
    receipt: Blob;

    constructor(amount, type, status, description, receipt){
        
        this.amount = amount;
        this.type = type;
        this.status = status;
        this.description = description;
        this.receipt = receipt;

    }

}
