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

