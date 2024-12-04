import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { RestaurantListingComponentComponent } from './restaurant-listing-component/restaurant-listing-component.component';
import { HomeComponent } from './home/home.component';
import { IteneraryComponent } from './itenerary/itenerary.component';
import { ExperiencesComponent } from './experiences/experiences.component';
import { CreateExperienceComponent } from './create-experience/create-experience.component';
import { ItineraryFormComponent } from './itinerary-form/itinerary-form.component';
import { ViewItineraryComponent } from './view-itinerary/view-itinerary.component';

export const routes: Routes = [


    { path: '', redirectTo: '/home', pathMatch: 'full' },
    { path: 'home', component: HomeComponent },

    { path: '', redirectTo: '/restaurants', pathMatch: 'full' },
    { path: 'restaurants', component: RestaurantListingComponentComponent },

    { path: '', redirectTo: '/experiences', pathMatch: 'full' },
    { path: 'experiences', component: ExperiencesComponent },

    { path: '', redirectTo: '/itinerary', pathMatch: 'full' },
    { path: 'itinerary', component: IteneraryComponent },

    { path: '', redirectTo: '/itinerary-form', pathMatch: 'full' },
    { path: 'itinerary-form', component: ItineraryFormComponent },

    { path: 'home', component: HomeComponent },
  { path: 'itinerary', component: IteneraryComponent },
  { path: 'experiences', component: ExperiencesComponent },
  { path: 'restaurants', component: RestaurantListingComponentComponent },
  { path: 'create-experiences', component: CreateExperienceComponent },


  { path: 'itinerary/itinerary-form', component: ItineraryFormComponent },
  { path: 'itinerary-form/itinerary', component: IteneraryComponent },

  { path: 'itinerary/view-itinerary', component: ViewItineraryComponent },
  { path: 'view-itinerary/itinerary', component: IteneraryComponent },

  { path: 'itinerary/:id', component: ViewItineraryComponent },


  { path: 'experiences/create-experiences', component: CreateExperienceComponent },
  { path: 'create-experiences/experiences', component: ExperiencesComponent },

];


@NgModule({
    imports: [RouterModule.forRoot(routes)],  // Import routes
    exports: [RouterModule]
  })
  export class AppRoutingModule { }