
import { LiveAnnouncer } from '@angular/cdk/a11y';
import { AfterViewInit, Component, Input, ViewChild } from '@angular/core';
import { MatSort, Sort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { PeriodicElement, applicationData } from 'src/assets/data';


const ELEMENT_DATA = applicationData;

/**
 * @title Table with sorting
 */


@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.scss']
})
export class TableComponent implements AfterViewInit {
  @ViewChild(MatSort) sort!: MatSort;

  displayedColumns: string[] = ['Q', 'A'];
  dataSource: any;

  @Input() set searchText(text: string) {
    if (text) {
      this.dataSource.filter = text.trim();
    }
  }

  constructor(private _liveAnnouncer: LiveAnnouncer) { }




  @Input() set tableData(data: any) {
    if (data) {
      this.dataSource = new MatTableDataSource(data);
      this.dataSource.sort = this.sort;
    }
  };

  ngAfterViewInit() {
  }

  /** Announce the change in sort state for assistive technology. */
  announceSortChange(sortState: Sort) {
    // This example uses English messages. If your application supports
    // multiple language, you would internationalize these strings.
    // Furthermore, you can customize the message to add additional
    // details about the values being sorted.
    if (sortState.direction) {
      this._liveAnnouncer.announce(`Sorted ${sortState.direction}ending`);
    } else {
      this._liveAnnouncer.announce('Sorting cleared');
    }
  }
}