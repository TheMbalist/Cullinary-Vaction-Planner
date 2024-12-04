import { bootstrapApplication } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http'; 
import { appConfig } from './app/app.config';
import { AppComponent } from './app/app.component';



bootstrapApplication(AppComponent, {
  providers: [
    HttpClientModule,  // Provide HttpClientModule globally
    ...appConfig.providers  // Add the rest of the providers
  ],
})
  .catch((err) => console.error(err));

