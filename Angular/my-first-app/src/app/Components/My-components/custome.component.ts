import { Component, EventEmitter, Input, Output } from "@angular/core";

@Component({
  selector: 'my-custom',
  template: `
  <h1>this is my custom comonent {{name}}</h1>  
  <button (click)="emitData()" >click me</button>
  `,
})
export class MyCustomComponent {
  @Input() name: string = ""

  @Output() nameChange: EventEmitter<string> = new EventEmitter<string>();

  emitData() {
    this.nameChange.emit("javed");
  }

}