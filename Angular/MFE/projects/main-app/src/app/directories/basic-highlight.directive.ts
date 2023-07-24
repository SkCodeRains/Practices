import { Directive, ElementRef, OnInit } from "@angular/core";
import { fromEvent } from "rxjs";

@Directive({
  selector: "[appBasicHighlight]"
})


export class BasicHightlightDirective implements OnInit {
  constructor(private elementRef: ElementRef,) {

  }
  ngOnInit(): void {
    fromEvent(this.elementRef.nativeElement, "mouseover").subscribe((elementRef)=>{
      this.elementRef.nativeElement.style.backgroundColor="green";
    })
    fromEvent(this.elementRef.nativeElement, "mouseout").subscribe((elementRef)=>{
      this.elementRef.nativeElement.style.backgroundColor="";
    })
  }
}
