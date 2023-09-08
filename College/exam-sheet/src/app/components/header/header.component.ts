import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent {

  @Input() showBackground!: boolean;
  @Output() showBackgroundChange = new EventEmitter<boolean>();


  setToggle(data: any) {
    this.showBackground = data;
    this.showBackgroundChange.emit(this.showBackground)
  }
}
