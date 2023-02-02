import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-upload',
  templateUrl: './upload.component.html',
  styleUrls: ['./upload.component.scss']
})
export class UploadComponent implements OnInit {

  public fileUploadUrl="http://localhost:8080/upload";
  constructor(private http:HttpClient) { }
  public file:any;
  ngOnInit(): void {
  }

  selectFile(event:any){
    this.file=event.target.files[0];
    console.log(this.file);
  }


  uploadFile()
  {
    let formData=new FormData();
    //in request param file is used as key
    formData.append('file',this.file);
    this.http.post(this.fileUploadUrl,formData).subscribe(
      data=>{
        console.log("file uploaded",data);
        alert("file uploaded");
      },
      error=>{
        console.error(error);
      }
    )
  }
}
