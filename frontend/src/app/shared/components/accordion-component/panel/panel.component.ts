import { Component, Input, Output, EventEmitter, ViewChild, ElementRef, HostBinding} from "@angular/core";

@Component({
  selector: "expansion-panel",
  templateUrl: "./panel.component.html",
  styleUrls: ["./panel.component.scss"],

})

export class AccordionGroupComponent {

  @Input() iconColor: string
  @Input() height: number
  @Input() position: string

  @Input() opened = false;
  @Output() toggle: EventEmitter<any> = new EventEmitter<any>();

  @ViewChild("panel", {static: false}) panel: ElementRef;
  @ViewChild("panelContainer", {static: false}) panelContainer: ElementRef;

}
