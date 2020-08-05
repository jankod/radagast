export interface IUserProfile {
  id?: number;
  firstName?: string;
  lastName?: string;
  oib?: string;
  userId?: number;
}

export class UserProfile implements IUserProfile {
  constructor(public id?: number, public firstName?: string, public lastName?: string, public oib?: string, public userId?: number) {}
}
