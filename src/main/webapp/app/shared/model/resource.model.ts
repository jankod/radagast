export interface IResource {
  id?: number;
  name?: string;
  orgId?: number;
}

export class Resource implements IResource {
  constructor(public id?: number, public name?: string, public orgId?: number) {}
}
