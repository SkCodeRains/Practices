import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  @Input() set feedMe(val: any) {
    console.log(val);

  }
  @Output() clicked: EventEmitter<any> = new EventEmitter<any>()

  emit() {
    this.clicked.emit("anuglar");
  }
  constructor() {
  }

}
