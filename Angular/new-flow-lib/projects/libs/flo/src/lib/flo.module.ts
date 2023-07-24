import { NgModule } from '@angular/core';
import { Palette, EditorComponent, ResizerDirective, DslEditorComponent, CodeEditorComponent, PropertiesGroupComponent, DynamicFormPropertyComponent } from '../public-api';
import { PaperComponent } from './component/editor/paper.component';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { FloComponent } from './flo.component';



@NgModule({
  declarations: [
    FloComponent,
    Palette,
    EditorComponent,
    ResizerDirective,
    DslEditorComponent,
    CodeEditorComponent,
    PropertiesGroupComponent,
    DynamicFormPropertyComponent,
    PaperComponent
  ],
  imports: [
    FormsModule,
    CommonModule,
    ReactiveFormsModule
  ],
  exports: [
    EditorComponent,
    DslEditorComponent,
    DynamicFormPropertyComponent,
    PropertiesGroupComponent
  ]
})
export class FloModule { }
