import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: 'user-profile',
        loadChildren: () => import('./user-profile/user-profile.module').then(m => m.RadagastUserProfileModule),
      },
      {
        path: 'org',
        loadChildren: () => import('./org/org.module').then(m => m.RadagastOrgModule),
      },
      {
        path: 'resource',
        loadChildren: () => import('./resource/resource.module').then(m => m.RadagastResourceModule),
      },
      /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
    ]),
  ],
})
export class RadagastEntityModule {}
