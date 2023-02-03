import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AlertModalComponent } from './modals/alert-modal/alert-modal.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';



@NgModule({
  declarations: [
    AlertModalComponent
  ],
  imports: [
    CommonModule,
    NgbModule
  ],
  exports:[
    AlertModalComponent
  ],
  entryComponents:[AlertModalComponent]
})
export class SharedModule { }
