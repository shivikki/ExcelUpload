# ExcelUpload

Created rest call to upload an excel file. Store the contents of excel sheet in DB.

From frontend added function to upload file


#Add Tooltip using NgbBoostrap

> ng add @ng-bootstrap/ng-bootstrap
> In app.module.ts add dependency
   import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
   
   
> In uploadComponent.ts 
 import { NgbTooltipModule } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-upload',
  templateUrl: './upload.component.html',
  styleUrls: ['./upload.component.scss'],
  providers:[NgbTooltipModule]
})



#Create reusable modal popup inside shared module

> Create new module - ng g m shared
> create component for modal popup - ng g c alert-modal
> Use NgbActiveModal inside ts file of modal
> do the sttying of modal in html/css files
> In shared.module.ts file define exports, entryComponents, declaration
> Import NgbModal & AlertModalComponent inside the component wherever Modal needs to be called


#Dynamic Read More & read less added for list


#Drag & Drop file to upload 

#Custom radio btn & checkbox

#added sticky header & footer

#custom timepicker
> In component ts file add dependency for timepicker
 
import { FormsModule } from '@angular/forms';
import { JsonPipe } from '@angular/common';
import { NgbTimepickerModule } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-upload',
  templateUrl: './upload.component.html',
  styleUrls: ['./upload.component.scss'],
  providers:[NgbTooltipModule,NgbTimepickerModule, FormsModule, JsonPipe]
})


#Type search dropdowm added
> Used ng-2-search filter
> npm i ng2-search-filter --save
> in app.module.ts
   import { Ng2SearchPipeModule } from 'ng2-search-filter';
   @NgModule({
  imports: [BrowserModule, Ng2SearchPipeModule],
  declarations: [AppComponent],
  bootstrap: [AppComponent]
})

> for dropdown used ngbDropdown

#Gloabal spinner
> inside shared folder
   ng g s loader
   
   create class LoaderInterceptor
 > In app.module.ts
 inside providers mention interceptor
 
 providers: [   LoaderService,{ provide: HTTP_INTERCEPTORS, useClass: LoaderInterService, multi: true }]
