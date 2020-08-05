import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { RadagastSharedModule } from 'app/shared/shared.module';
import { OrgComponent } from './org.component';
import { OrgDetailComponent } from './org-detail.component';
import { OrgUpdateComponent } from './org-update.component';
import { OrgDeleteDialogComponent } from './org-delete-dialog.component';
import { orgRoute } from './org.route';

@NgModule({
  imports: [RadagastSharedModule, RouterModule.forChild(orgRoute)],
  declarations: [OrgComponent, OrgDetailComponent, OrgUpdateComponent, OrgDeleteDialogComponent],
  entryComponents: [OrgDeleteDialogComponent],
})
export class RadagastOrgModule {}
