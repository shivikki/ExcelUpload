import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgbTooltipModule } from '@ng-bootstrap/ng-bootstrap';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { AlertModalComponent } from 'src/app/shared/shared/modals/alert-modal/alert-modal.component';

import { FormsModule } from '@angular/forms';
import { JsonPipe } from '@angular/common';
import { NgbTimepickerModule } from '@ng-bootstrap/ng-bootstrap';

//dropdown
import { NgbDropdownModule } from '@ng-bootstrap/ng-bootstrap';
@Component({
  selector: 'app-upload',
  templateUrl: './upload.component.html',
  styleUrls: ['./upload.component.scss'],
  providers: [NgbTooltipModule, NgbTimepickerModule, FormsModule, JsonPipe,NgbDropdownModule]
})
export class UploadComponent implements OnInit {

  public fileUploadUrl = "http://localhost:8080/upload";
  constructor(private http: HttpClient, private ngbModal: NgbModal) { }
  public modalRef: any;
  public file: any;
  public fileDrag: any;
  public fileResult = '';

  //timepicker : dafault value added
  meridian = true;
  time = { hour: 13, minute: 30 };
  toggleMeridian() {
    this.meridian = !this.meridian;
  }

  //for read more read less
  public contentList = [{
    sr: 1,
    content: "hdsb hfsjkbf hfghvbs hgsfjkbf hafkjbfv hfdkjvbf hfebkjbvf hsvdhjnv",
    isReadMore: false
  },
  {
    sr: 2,
    content: "hdsb hfsjk",
    isReadMore: false
  },
  {
    sr: 3,
    content: "cghcv hjhv ftadsf hgdshf hgvshjb esrasd k;kl ",
    isReadMore: false
  }
  ];

  //typesearch dropdown
  public items = [{ name: "archie" }, { name: "jake" }, { name: "richard" }];
  public term = '';
  public nameSelected='Select Name';
  ngOnInit(): void {
  }

  selectFile(event: any) {
    this.file = event.target.files[0];
    console.log(this.file);
  }

  openModal() {
    this.modalRef = this.ngbModal.open(AlertModalComponent, {
      size: "md",
      keyboard: true,
      backdrop: 'static',
      centered: true
    })

    this.modalRef.componentInstance.content = "You are not authorized to use this !!!"
  }

  uploadFile() {
    let formData = new FormData();
    //in request param file is used as key
    formData.append('file', this.file);
    this.http.post(this.fileUploadUrl, formData).subscribe(
      data => {
        console.log("file uploaded", data);
        alert("file uploaded");
      },
      error => {
        console.error(error);
      }
    )
  }


  showText(i: any) {
    this.contentList[i].isReadMore = !this.contentList[i].isReadMore;

  }

  getDragFile(event: any) {
    //drag multiple files
    this.fileDrag = event.target.files[0];

    console.log(this.fileDrag)
  }

  selectName(name:any){
    this.nameSelected=name;
  }
}
