import { AfterViewInit, Component } from '@angular/core';
import { PeriodicElement, applicationData } from 'src/assets/data';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements AfterViewInit {

  showBackground: boolean = false;

  tableData!: PeriodicElement;
  searchedTText!: string;

  applicationData: any = JSON.parse(JSON.stringify(applicationData))

  filterParamters = {
    COURSE: "MCA",
    SEMESTER_NAME: "2",
    SUBJECT_NAME: "Advanced Internet Programming"
  }
  selectedSemester: any;

  ngAfterViewInit(): void {
    this.getFilterData();
  }
  getFilterData() {

    for (const iterator of this.applicationData[this.filterParamters.COURSE]) {
      if (iterator.SEMESTER_NAME === this.filterParamters.SEMESTER_NAME) {
        this.selectedSemester = iterator;
        for (const iterator2 of iterator.SUBJECTS) {
          if (iterator2.SUBJECT_NAME === this.filterParamters.SUBJECT_NAME) {
            this.tableData = iterator2.DATA
          }
          return;
        }
      }
    }

  }
}
