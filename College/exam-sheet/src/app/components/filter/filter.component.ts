import { AfterViewInit, Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-filter',
  templateUrl: './filter.component.html',
  styleUrls: ['./filter.component.scss']
})
export class FilterComponent implements AfterViewInit {

  @Input() applicationData: any;
  @Input() selectedSemester: any;
  @Input() filterParamters = {
    COURSE: "MCA",
    SEMESTER_NAME: "2",
    SUBJECT_NAME: "Advanced Internet Programming"
  };
  @Output() searchChange: EventEmitter<string> = new EventEmitter<string>();;
  ngAfterViewInit(): void {

  }
  selectSemester(item: any) {
    this.filterParamters.SEMESTER_NAME = item.SEMESTER_NAME;
    this.selectedSemester = item;
  }

  selectSubject(item: any) {
    this.filterParamters.SUBJECT_NAME = item.SUBJECT_NAME;
  }

  private _keyup: string = "";
  public get keyup(): string {
    return this._keyup;
  }
  public set keyup(value: string) {
    this._keyup = value;
    this.searchChange.emit(value);
  }

}
