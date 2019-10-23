import { Directive, ElementRef, Input, OnInit } from '@angular/core';

@Directive({
  selector: '[accordion]'
})
export class AccordionOptionsDirective{

  constructor(private element: ElementRef) { }

  @Input()
  set iconColor(color: string){
    this.element.nativeElement.querySelector('.icon').style.borderBottomColor = color
  }

  @Input()
  set heightPanel(value: number){
    this.element.nativeElement.style.height = `${value}px`
  }

  @Input()
  set position(value: string){
    if(value === 'left'){
      this.element.nativeElement.style.flexDirection = "row-reverse";
    } else{
      this.element.nativeElement.style.flexDirection = "row";
    }
  }
}
