import { Injectable, ComponentFactoryResolver, ApplicationRef, Injector } from '@angular/core';
import { SuccessAlertComponent } from '../success-alert/success-alert.component';
import { ErrorAlertComponent } from '../error-alert/error-alert.component';

@Injectable({
  providedIn: 'root'
})
export class AlertserviceService {

  constructor(
    private componentFactoryResolver: ComponentFactoryResolver,
    private appRef: ApplicationRef,
    private injector: Injector
  ) {}

  showSuccessAlert(message: string): void {
    const componentFactory = this.componentFactoryResolver.resolveComponentFactory(SuccessAlertComponent);
    const componentRef = componentFactory.create(this.injector);

    componentRef.instance.message = message;

    this.appRef.attachView(componentRef.hostView);
    const domElem = (componentRef.hostView as any).rootNodes[0] as HTMLElement;
    document.body.appendChild(domElem);

    // Remove the alert after it disappears
    setTimeout(() => {
      this.appRef.detachView(componentRef.hostView);
      componentRef.destroy();
    }, 5000); // Customize this time based on the alert duration
  }


  showErrorAlert(message: string): void {
    const componentFactory = this.componentFactoryResolver.resolveComponentFactory(ErrorAlertComponent);
    const componentRef = componentFactory.create(this.injector);

    componentRef.instance.message = message;

    this.appRef.attachView(componentRef.hostView);
    const domElem = (componentRef.hostView as any).rootNodes[0] as HTMLElement;
    document.body.appendChild(domElem);

    // Remove the alert after it disappears
    setTimeout(() => {
      this.appRef.detachView(componentRef.hostView);
      componentRef.destroy();
    }, 5000); // Customize this time based on the alert duration
  }
}
