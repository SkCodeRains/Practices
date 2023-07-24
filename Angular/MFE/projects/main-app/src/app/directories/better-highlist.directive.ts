import { Directive, ElementRef, HostListener, OnInit, Renderer2 } from "@angular/core";
import { fromEvent } from "rxjs";

@Directive({
  selector: "[appBetterHighlight]"
})


export class BetterHightlightDirective implements OnInit {



  constructor(private elementRef: ElementRef, private rederer: Renderer2) { }
  ngOnInit(): void {
    /*   fromEvent(this.elementRef.nativeElement, "mouseover").subscribe((elementRef) => {
      })
      fromEvent(this.elementRef.nativeElement, "mouseout").subscribe((elementRef) => {
        this.rederer.setStyle(this.elementRef.nativeElement, 'background-color', '');
      }) */
  } @HostListener("mouseenter") mouseover(eventData: any) {
    this.rederer.setStyle(this.elementRef.nativeElement, 'background-color', 'red');
  }
  @HostListener("mouseover") mouseout(eventData: any) {
    this.rederer.setStyle(this.elementRef.nativeElement, 'background-color', '');
  }
}
