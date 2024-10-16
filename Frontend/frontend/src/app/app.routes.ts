import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { RestaurantListingComponentComponent } from './restaurant-listing-component/restaurant-listing-component.component';
import { HomeComponent } from './home/home.component';
import { IteneraryComponent } from './itenerary/itenerary.component';
import { ExperiencesComponent } from './experiences/experiences.component';
import { ItineraryFormComponent } from './itinerary-form/itinerary-form.component';

export const routes: Routes = [


    { path: '', redirectTo: '/home', pathMatch: 'full' },
    { path: 'home', component: HomeComponent },

    { path: '', redirectTo: '/restaurants', pathMatch: 'full' },
    { path: 'restaurants', component: RestaurantListingComponentComponent },

    { path: '', redirectTo: '/experiences', pathMatch: 'full' },
    { path: 'experiences', component: ExperiencesComponent },

    { path: '', redirectTo: '/itenerary', pathMatch: 'full' },
    { path: 'itenerary', component: IteneraryComponent },

    { path: '', redirectTo: '/itenerary-form', pathMatch: 'full' },
    { path: 'itenerary-form', component: ItineraryFormComponent },

    { path: 'home', component: HomeComponent },
  { path: 'itenerary', component: IteneraryComponent },
  { path: 'experiences', component: ExperiencesComponent },
  { path: 'restaurants', component: RestaurantListingComponentComponent },


  { path: 'itenerary/itinerary-form', component: ItineraryFormComponent },
  { path: 'itinerary-form/itenerary', component: IteneraryComponent },
//   { path: 'profile', component: ProfileComponent },
  { path: '', redirectTo: '/home', pathMatch: 'full' }
];


@NgModule({
    imports: [RouterModule.forRoot(routes)],  // Import routes
    exports: [RouterModule]
  })
  export class AppRoutingModule { }