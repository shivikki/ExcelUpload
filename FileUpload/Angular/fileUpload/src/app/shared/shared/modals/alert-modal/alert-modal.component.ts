import { Component, Input, OnInit } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
@Component({
  selector: 'app-alert-modal',
  templateUrl: './alert-modal.component.html',
  styleUrls: ['./alert-modal.component.scss']
})
export class AlertModalComponent implements OnInit {

  @Input() content:String='';
  public modalTitle='';
  public modalType='';
  constructor(public activeModal:NgbActiveModal) { }

  ngOnInit(): void {
  }
  

}
