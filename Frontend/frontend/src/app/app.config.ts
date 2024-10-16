import { ApplicationConfig } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { provideRouter } from '@angular/router';
import { CommonModule } from '@angular/common';
import { routes } from './app.routes';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import { provideHttpClient } from '@angular/common/http';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatIconModule } from '@angular/material/icon';
import { NgClass } from '@angular/common';
import { MatSelectModule } from '@angular/material/select';
import { MatInputModule } from '@angular/material/input'; 
import { MatOptionModule } from '@angular/material/core';
import { MatLabel } from '@angular/material/select';
import { MatFormFieldModule } from '@angular/material/form-field';
import { RouterModule } from '@angular/router';
import * as Masonry from 'masonry-layout';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { MatButtonModule } from '@angular/material/button';



export const appConfig: ApplicationConfig = {
  providers: [HttpClientModule, 
              CommonModule,
              MatPaginatorModule, 
              MatIconModule, 
              NgClass,
              MatInputModule, 
              MatSelectModule, 
              MatOptionModule, 
              MatLabel, 
              MatFormFieldModule, 
              RouterModule,
              MatSlideToggleModule,
              MatButtonModule,
              provideRouter(routes), 
              provideAnimationsAsync(),  
              provideHttpClient()]
};
