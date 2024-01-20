import { JsonPipe } from '@angular/common';
import { Component, EventEmitter, Output } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { NgbDatepickerModule, NgbAlertModule, NgbDateStruct } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-datepicker-popup',
  standalone: true,
  imports: [NgbDatepickerModule, NgbAlertModule, FormsModule, JsonPipe],
  templateUrl: './datepicker-popup.component.html',
  styleUrl: './datepicker-popup.component.scss'
})
export class DatepickerPopupComponent {
  private _model!: NgbDateStruct;
  @Output() dateChange = new EventEmitter<string>();
  public get model(): NgbDateStruct {
    return this._model;
  }
  public set model(value: NgbDateStruct) {
    this._model = value;
    this.dateChange.emit(`${value.day}-${value.month}-${value.year}`);
  }
}
