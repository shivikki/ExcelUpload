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

