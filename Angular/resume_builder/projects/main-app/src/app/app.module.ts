import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ResumeComponent } from './component/resume/resume/resume.component';
import { RendererComponent } from './component/renderer/renderer/renderer.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { DragDropModule } from '@angular/cdk/drag-drop';
import { ResumeHeaderComponent } from './component/resume/resume/resume-header/resume-header.component';
import { ColumnLeftComponent } from './component/resume/resume/column-left/column-left.component';
import { ColumnRightComponent } from './component/resume/resume/column-right/column-right.component';
@NgModule({
  declarations: [
    AppComponent,
    ResumeComponent,
    RendererComponent,
    ResumeHeaderComponent,
    ColumnLeftComponent,
    ColumnRightComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    DragDropModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
