import { IResource } from 'app/shared/model/resource.model';
import { OrgStatus } from 'app/shared/model/enumerations/org-status.model';

export interface IOrg {
  id?: number;
  name?: string;
  description?: string;
  status?: OrgStatus;
  resources?: IResource[];
}

export class Org implements IOrg {
  constructor(
    public id?: number,
    public name?: string,
    public description?: string,
    public status?: OrgStatus,
    public resources?: IResource[]
  ) {}
}
