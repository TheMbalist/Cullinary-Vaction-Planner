import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { RestaurantListingComponentComponent } from './restaurant-listing-component/restaurant-listing-component.component';

export const routes: Routes = [


    { path: '', redirectTo: '/restaurants', pathMatch: 'full' },
    { path: 'restaurants', component: RestaurantListingComponentComponent },
];


@NgModule({
    imports: [RouterModule.forRoot(routes)],  // Import routes
    exports: [RouterModule]
  })
  export class AppRoutingModule { }